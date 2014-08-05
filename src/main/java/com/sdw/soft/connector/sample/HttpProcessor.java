/**
 * @Date 2014年8月4日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.connector.sample;
/**
 * 
 * @author syd
 */
public class HttpProcessor {

	private HttpConnector httpConnector = null;
	private HttpRequest httpRequest; 
	public HttpProcessor(HttpConnector httpConnector){
		this.httpConnector = httpConnector;
	}
	
}
