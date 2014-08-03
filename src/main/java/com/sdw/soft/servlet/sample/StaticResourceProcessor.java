/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.servlet.sample;
/**
 * 
 * @author syd
 */
public class StaticResourceProcessor {

	public void process(Request request ,Response response){
		response.sendStaticResource();
	}
}
