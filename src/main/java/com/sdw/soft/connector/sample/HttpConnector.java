/**
 * @Date 2014年8月4日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.connector.sample;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.sdw.soft.socket.sample.SocketConstant;

/**
 * 
 * @author syd
 */
public class HttpConnector implements Runnable{
	
	boolean shutdown = false;
	private String schema = "http";
	
	public String getSchema() {
		return schema;
	}

	@Override
	public void run() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(SocketConstant.BIND_PORT,1,InetAddress.getByName(SocketConstant.BIND_ADDR));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		while(!shutdown){
			Socket socket = null;
			try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				continue;
			}
		}
	}
	
	
	public void start(){
		Thread thread = new Thread(this);
		thread.start();
	}
}
