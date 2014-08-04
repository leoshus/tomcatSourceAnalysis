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

	
	private OutputStream outputStream;
	private PrintWriter printWriter = null;
	
	public Response (OutputStream outputStream){
		this.outputStream = outputStream;
	}
	
	public OutputStream getOutput(){
		return outputStream;
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
