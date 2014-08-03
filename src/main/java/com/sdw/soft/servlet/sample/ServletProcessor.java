/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.servlet.sample;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sdw.soft.socket.sample.SocketConstant;

/**
 * 
 * @author syd
 */
public class ServletProcessor {
	public void process(Request request,Response response){
		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf('/') + 1);
		URLClassLoader loader = null;
		try {
			//create a URLClassLoader
			URL[] urls = new URL[1];
			URLStreamHandler urlStreamHandler = null;
			String tmp = this.getClass().getName();
			File classPath = new File(System.getProperty("user.dir")+"com\\sdw\\soft\\servlet\\sample");
//			File classPath = new File(SocketConstant.WEB_ROOT);
			System.out.println(System.getProperty("user.dir")+File.separator+tmp.substring(0, tmp.lastIndexOf('.')).replace('.', '/'));
			//the form of repository is taken from the createClassLoader method in 
			//org.apache.catalina.loader.StandardClassLoader
			String repository = (new URL("file",null,classPath.getCanonicalPath() + File.separator)).toString();
			urls[0] = new URL(null,repository,urlStreamHandler);
			loader = new URLClassLoader(urls);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		Class myClass = null;
		try {
			myClass = loader.loadClass(servletName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Servlet servlet = null;
		try {
			servlet = (Servlet)myClass.newInstance();
			servlet.service((ServletRequest)request, (ServletResponse)response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(ServletProcessor.class.getName());
	}
}
