/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.socket.sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author syd
 */
public class SampleServerSocket extends SocketConstant{
	//shutdown command
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	//the shutdown command received
	private boolean shutdown = false;
	
	public static void main(String[] args){
		SampleServerSocket server = new SampleServerSocket();
		System.out.println("Server is starting... ...");
		server.await();
	}

	public void await(){
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(BIND_PORT,1,InetAddress.getByName(BIND_ADDR));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		//loop waiting for a request
		while(!shutdown){
			Socket socket = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			
			try {
				socket = serverSocket.accept();
				inputStream = socket.getInputStream();
				outputStream = socket.getOutputStream();
				//create the Request Object and parse
				//samply to implement the parse of URI 
				Request request = new Request(inputStream);
				request.parse();
				//create Response Object
				Response response = new Response(outputStream);
				response.setRequest(request);
				response.sendStaticResource();
				//close the socket
				socket.close();
				//check if the previous URI is a shutdown command
				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	private void await1() {
		try {
			ServerSocket server = new ServerSocket(BIND_PORT, 1, InetAddress.getByName(BIND_ADDR));
			Socket socket = server.accept();
			InputStream is = socket.getInputStream();
			PrintWriter pw = new PrintWriter(System.out);
			StringBuilder sb = new StringBuilder("");
			int tmp ;
			while((tmp = is.read()) != -1){
				sb.append((char)tmp);
			}
			pw.write(sb.toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
