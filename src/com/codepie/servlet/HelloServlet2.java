package com.codepie.servlet;

import javax.servlet.*;
import java.io.IOException;

public class HelloServlet2 implements Servlet {
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init在 02");
	}
	
	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		System.out.println("service");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}
	
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}
}
