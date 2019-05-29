package com.codepie.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContext01", urlPatterns = {"/ServletContext01"},
		loadOnStartup = 5,
		initParams = {@WebInitParam(name = "username22", value = "zhiwen")})
public class ServletContext01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var context = getServletContext();
		var keys = context.getInitParameterNames();
		while (keys.hasMoreElements()) {
			String s = keys.nextElement();
			System.out.println("context-param = " + s);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
