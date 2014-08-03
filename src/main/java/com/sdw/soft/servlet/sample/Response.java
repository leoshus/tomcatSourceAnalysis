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
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

import com.sdw.soft.socket.sample.SocketConstant;

/**
 * 
 * @author syd
 */
public class Response implements ServletResponse{

	
	private static final int MAX_SIZE = 1024;
	private Request request;
	private OutputStream outputStream;
	private PrintWriter printWriter = null;
	
	public Response (OutputStream outputStream){
		this.outputStream = outputStream;
	}
	
	public void sendStaticResource(){
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
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	public void setRequest(Request request){
		this.request = request;
	}
	@Override
	public String getCharacterEncoding() {
		return null;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		printWriter = new PrintWriter(outputStream,true);
		return printWriter;
	}

	@Override
	public void setCharacterEncoding(String charset) {
		
	}

	@Override
	public void setContentLength(int len) {
		
	}

	@Override
	public void setContentType(String type) {
		
	}

	@Override
	public void setBufferSize(int size) {
		
	}

	@Override
	public int getBufferSize() {
		return 0;
	}

	@Override
	public void flushBuffer() throws IOException {
		
	}

	@Override
	public void resetBuffer() {
		
	}

	@Override
	public boolean isCommitted() {
		return false;
	}

	@Override
	public void reset() {
		
	}

	@Override
	public void setLocale(Locale loc) {
		
	}

	@Override
	public Locale getLocale() {
		return null;
	}

}
