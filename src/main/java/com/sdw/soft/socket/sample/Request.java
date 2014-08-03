/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.socket.sample;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author syd
 */
public class Request {

	private InputStream inputStream;
	private String uri;
	
	public Request(InputStream inputStream){
		this.inputStream = inputStream;
	}
	
	public void parse(){
		StringBuffer sb = new StringBuffer(2048);
		int i = 0;
		byte[] buffer = new byte[2048];
		try {
			i = inputStream.read(buffer);
		} catch (Exception e) {
			e.printStackTrace();
			i = -1;
		}
		for(int n = 0;n < i;n++){
			sb.append((char)buffer[n]);
		}
		System.out.println("请求信息:");
		System.out.println(sb.toString());
		uri = parseUri(sb.toString());
	}
	
	private String parseUri(String requestString){
		int index_first = requestString.indexOf(' ');
		int index_second = requestString.indexOf(' ',index_first + 1);
		if(index_second > index_first){
			return requestString.substring(index_first + 1, index_second);
		}
		return null;
	}
	
	public String getUri(){
		return this.uri;
	}
}
