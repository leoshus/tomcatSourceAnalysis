/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.socket.sample;

import java.io.File;

/**
 * 
 * @author syd
 */
public class SocketConstant {

	public static final String BIND_ADDR = "127.0.0.1";
	public static final int BIND_PORT = 8899;

	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "\\src\\main\\webapp";
	
	public static final String Package = "com.sdw.soft.connector.sample";
	public SocketConstant() {
		super();
	}

	public static void main(String[] args){
		System.out.println(WEB_ROOT);
	}
}