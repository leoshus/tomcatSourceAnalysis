/**
 * @Date 2014年8月5日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.connector.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import com.sdw.soft.socket.sample.SocketConstant;

/**
 * 
 * @author syd
 */
public class StaticResourceProcessor {

	private static int BUFFER_SIZE = 1024;
	public void process(HttpRequest httpRequest,HttpResponse httpResponse){
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		OutputStream outputStream = httpResponse.getOut();
		try {
			File file = new File(SocketConstant.WEB_ROOT,httpRequest.getRequestURI());
			if(file.exists()){
				fis = new FileInputStream(file);
				int ch = fis.read(bytes,0,BUFFER_SIZE);
				while(ch != -1){
					outputStream.write(bytes, 0, ch);
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
//				int len = 0;
//				while((len = fis.read(bytes)) != -1){
//					outputStream.write(bytes, 0, len);
//				}
			}else{// file not found
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
						+ "Content-Type: text/html\r\n"
						+ "Content-Length: 23\r\n"
						+ "\r\n"
						+ "<h1>File Not Found</h1>";
				outputStream.write(errorMessage.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			try {
				if(fis != null){
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
