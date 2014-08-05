/**
 * @Date 2014年8月4日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.connector.sample;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.tomcat.util.res.StringManager;

import com.sdw.soft.socket.sample.SocketConstant;

/**
 * 
 * @author syd
 */
public class HttpProcessor {

	private HttpConnector httpConnector = null;
	private HttpRequest httpRequest; 
	private HttpRequestLine httpRequestLine = new HttpRequestLine();
	private HttpResponse httpResponse;
	
	protected String method = null;
	protected String queryString = null;
	
	protected StringManager stringManager = StringManager.getManager(SocketConstant.Package);
	
	public HttpProcessor(HttpConnector httpConnector){
		this.httpConnector = httpConnector;
	}
	
	
	public void process(Socket socket){
		SocketInputStream socketInputStream = null;
		OutputStream outputStream = null;
		
		try {
			socketInputStream = new SocketInputStream(socket.getInputStream(),2048);
			
			outputStream = socket.getOutputStream();
			httpRequest = new HttpRequest(socket.getInputStream());
			httpRequest.parseURI();
			
			httpResponse = new HttpResponse(outputStream);
			httpResponse.setHttpRequest(httpRequest);
			
			if(httpRequest.getRequestURI().startsWith("/servlet/")){
				ServletProcessor servletProcessor = new ServletProcessor();
				servletProcessor.process(httpRequest, httpResponse);
			}else{
				StaticResourceProcessor staticResourceProcessor = new StaticResourceProcessor();
				staticResourceProcessor.process(httpRequest, httpResponse);
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
