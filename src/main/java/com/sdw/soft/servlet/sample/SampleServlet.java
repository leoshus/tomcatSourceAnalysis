/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.servlet.sample;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author syd
 */
public class SampleServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.getOutputStream().write("Hello,Servlet Container ...".getBytes());
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		
	}

}
