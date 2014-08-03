/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.servlet.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

/**
 * 
 * @author syd
 */
public class Request implements ServletRequest{

	private InputStream inputStream;
	private String uri;
	
	public Request(InputStream inputStream){
		this.inputStream = inputStream;
	}
	
	public void parse(){
		int i = 0;
		try {
			StringBuffer sb = new StringBuffer(2048);
			byte[] buffer = new byte[2048];
			i = inputStream.read(buffer);
			
			for(int n = 0;n < i;n++){
				sb.append((char)buffer[n]);
			}
			System.out.println("--------请求信息-----------");
			System.out.println(sb.toString());
			uri = parseUri(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
			i=-1;
		}
	}
	
	private String parseUri(String content){
		int index_first = content.indexOf(' ');
		int index_second = content.indexOf(' ', index_first + 1);
		if(index_second > index_first){
			return content.substring(index_first + 1, index_second);
		}
		
		return null;
	}
	public String getUri(){
		return uri;
	}
	@Override
	public Object getAttribute(String name) {
		return null;
	}

	@Override
	public Enumeration getAttributeNames() {
		return null;
	}

	@Override
	public String getCharacterEncoding() {
		return null;
	}

	@Override
	public void setCharacterEncoding(String env)
			throws UnsupportedEncodingException {
		
	}

	@Override
	public int getContentLength() {
		return 0;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return null;
	}

	@Override
	public String getParameter(String name) {
		return null;
	}

	@Override
	public Enumeration getParameterNames() {
		return null;
	}

	@Override
	public String[] getParameterValues(String name) {
		return null;
	}

	@Override
	public Map getParameterMap() {
		return null;
	}

	@Override
	public String getProtocol() {
		return null;
	}

	@Override
	public String getScheme() {
		return null;
	}

	@Override
	public String getServerName() {
		return null;
	}

	@Override
	public int getServerPort() {
		return 0;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return null;
	}

	@Override
	public String getRemoteAddr() {
		return null;
	}

	@Override
	public String getRemoteHost() {
		return null;
	}

	@Override
	public void setAttribute(String name, Object o) {
		
	}

	@Override
	public void removeAttribute(String name) {
		
	}

	@Override
	public Locale getLocale() {
		return null;
	}

	@Override
	public Enumeration getLocales() {
		return null;
	}

	@Override
	public boolean isSecure() {
		return false;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		return null;
	}

	@Override
	public String getRealPath(String path) {
		return null;
	}

	@Override
	public int getRemotePort() {
		return 0;
	}

	@Override
	public String getLocalName() {
		return null;
	}

	@Override
	public String getLocalAddr() {
		return null;
	}

	@Override
	public int getLocalPort() {
		return 0;
	}

}
