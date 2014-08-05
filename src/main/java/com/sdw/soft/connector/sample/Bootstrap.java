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
public class Bootstrap {

	public static void main(String[] args){
		HttpConnector httpConnector = new HttpConnector();
		httpConnector.start();
		System.out.println("Http Server starting ... ...");
	}
}
