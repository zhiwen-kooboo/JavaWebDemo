package com.codepie.cookies_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FirstCookieServlet", urlPatterns = {"/FirstCookieServlet"},
		loadOnStartup = 5)
public class FirstCookieServlet extends HttpServlet {
	private static int _counter = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		_counter++;
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (var cookie : cookies) {
				response.getWriter().write(cookie.getName() + ":" + cookie.getValue() + "<br/>");
			}
		} else {
			response.getWriter().write("无cookie" + "<br/>");
		}
		
		var cookie = new Cookie("author" + _counter, "zhiwen" + _counter);
		// 设置过期时间，单位是秒(second).负值的话关闭浏览器就过期(不设置也一样)
		cookie.setMaxAge(60);
		// 用于指定请求了该域名，才会带上这个cookie
		cookie.setDomain(".xxx.com");
		// 只有访问了该域名下该Path才会带cookie
		cookie.setPath("/CookieDemo");
		response.addCookie(cookie);
		
		response.getWriter().write("doGet，写入了cooke!");
	}
}
