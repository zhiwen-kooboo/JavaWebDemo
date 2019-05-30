package com.codepie.loginDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.Iterator;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"},
		loadOnStartup = 5,
		initParams = {@WebInitParam(name = "username22", value = "zhiwen")})
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入LoginServlet的doGet！");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var map = request.getParameterMap();
		for (var key : map.keySet()) {
			System.out.println(String.format("key=%s&value=%s", key, map.get(key)[0]));
		}
		
		PrintWriter pw = response.getWriter();
		
		if ("admin".equalsIgnoreCase(request.getParameter("username"))) {
			response.setStatus(302);
			response.setHeader("location", "login_success.html");
		} else {
			pw.write("<h1>login failed!</h1>");
		}
	}
}
