/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.servlet.sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.sdw.soft.socket.sample.SocketConstant;

/**
 * 
 * @author syd
 */
public class HttpServer extends SocketConstant{

	private static final String SHUTDOWN_COMMAND = "/shutdown";
	public static void main(String[] args){
		HttpServer server = new HttpServer();
		System.out.println("Server Starting ... ...");
		server.await();
	}
	
	public void await(){
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(BIND_PORT,1,InetAddress.getByName(BIND_ADDR));
		} catch (Exception e1) {
			e1.printStackTrace();
			System.exit(1);
		}
		
			boolean shutdown = false;
			while(!shutdown){
				Socket socket = null;
				InputStream inputStream = null;
				OutputStream outputStream = null;
				
				try {
					socket = serverSocket.accept();
					inputStream = socket.getInputStream();
					outputStream = socket.getOutputStream();
					Request request = new Request(inputStream);
					request.parse();
					
					Response response = new Response(outputStream);
					String uri = request.getUri();
					if(uri.startsWith("/servlet/")){
						ServletProcessor servletProcessor = new ServletProcessor();
						servletProcessor.process(request, response);
					}else{
						StaticResourceProcessor staticResourceProcessor = new StaticResourceProcessor();
						staticResourceProcessor.process(request, response);
					}
					
					socket.close();
					shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}
				
			}
	}
}
