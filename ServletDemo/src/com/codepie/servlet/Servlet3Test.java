package com.codepie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet3Test", urlPatterns = {"/Servlet3Test"},
		loadOnStartup = 5,
		initParams = {@WebInitParam(name = "username", value = "zhiwen")})
public class Servlet3Test extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入servlet3");
		
		var context = getServletContext();
		System.out.println(String.format("Servlet3Test中的context hashcode = %s", context.hashCode()));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("servlet 3的初始化");
	}
}
