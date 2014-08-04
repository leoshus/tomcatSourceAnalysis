/**
 * @Date 2014年8月3日
 * @version 1.0.0
 * Copyright (c) 2014
 */


import java.io.IOException;
import java.io.PrintWriter;

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
		System.out.println("hello,Servlet Container...");
		PrintWriter out = res.getWriter();
		out.println("Hello,Servlet Container ... ... println()");
		out.print("Hello,Servlet Container ... ... print()");
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		
	}

}
