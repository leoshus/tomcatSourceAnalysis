/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.socket.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author syd
 */
public class SampleSocket extends SocketConstant{

	public static void main(String[] args){
		try {
			boolean autoFlush = true;
			Socket socket = new Socket(InetAddress.getByName(BIND_ADDR), BIND_PORT);
			PrintWriter pout = new PrintWriter(socket.getOutputStream(),autoFlush);
			pout.println("GET /sample/index.html HTTP/1.1");
			pout.println("Host: localhost:8080");
			pout.println("connection:close");
			pout.println();
			BufferedReader breader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			boolean loop = true;
			StringBuffer sb = new StringBuffer(8096);
			while(loop){
				int i = 0;
				while(i != -1){
					i = breader.read();
					sb.append((char)i);
				}
				loop = false;
			}
			Thread.currentThread().sleep(50);
			System.out.println("请求信息"+sb.toString());
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
