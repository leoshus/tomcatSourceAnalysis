/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.servlet.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import com.sdw.soft.socket.sample.SocketConstant;

/**
 * 
 * @author syd
 */
public class StaticResourceProcessor {
	
	private static final int MAX_SIZE = 1024;

	public void process(Request request ,Response response){
//		response.sendStaticResource();
		OutputStream outputStream = response.getOutput();
		FileInputStream fis = null;
		File file = new File(SocketConstant.WEB_ROOT,request.getUri());
		byte[] buffer = new byte[MAX_SIZE];
		try {
			if(file.exists()){
				fis = new FileInputStream(file);
				
				int len = fis.read(buffer,0,MAX_SIZE);
				while(len != -1){
					outputStream.write(buffer, 0, len);
					len = fis.read(buffer, 0, MAX_SIZE);
				}
			}else{
				String message = "HTTP/1.1 404 Not Found File\r\n"
						+ "Host:localhost:8099\r\n"
						+ "Content-Type:text/html\r\n"
						+ "Content-Length: 23\r\n"
						+ "\r\n"
						+ "<h1>File Not Found</h1>";
				outputStream.write(message.getBytes());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(fis != null){
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
