/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.socket.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * @author syd
 */
/*
HTTP Response = Status-Line
  *(( general-header | response-header | entity-header ) CRLF)
  CRLF
  [ message-body ]
  Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
*/
public class Response {
	
	private static final int BUFFER_SIZE = 1024;
	private Request request ;
	private OutputStream outputStream;
	
	public Response(OutputStream outputStream){
		this.outputStream = outputStream;
	}
	
	public void setRequest(Request request){
		this.request = request;
	}
	
	public void sendStaticResource()throws IOException{
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			File file = new File(SocketConstant.WEB_ROOT,request.getUri());
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
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
