package com.codepie.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServletConfig extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var config = getServletConfig();
		var name = config.getServletName();
		System.out.println(String.format("servletName = %s", name));
		
		var initParam = config.getInitParameter("testParam");
		System.out.println(String.format("initParam = %s", initParam));
		
		var paramNames = config.getInitParameterNames();
		while (paramNames.hasMoreElements()) {
			String s = paramNames.nextElement();
			System.out.println(String.format("initParam key = %s", s));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
