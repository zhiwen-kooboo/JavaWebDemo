package com.codepie.loginDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "CountServlet", urlPatterns = {"/CountServlet"},
		loadOnStartup = 5)
public class CountServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入countServlet");
		var count = (int) getServletContext().getAttribute("count");
		
		response.getWriter().write("当前网站登录总次数为" + count);
		
		var headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String s = headerNames.nextElement();
			response.getWriter().write(String.format("%s:%s", s, request.getHeader(s)));
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost(request, response);
		request.setCharacterEncoding("UTF-8");
		
		var name = request.getParameter("name");
		
		System.out.println("name:" + name);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("测试乱码");
	}
}
