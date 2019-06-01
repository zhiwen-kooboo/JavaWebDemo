package com.codepie.cookies_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "FirstSessionServlet", urlPatterns = {"/FirstSessionServlet"},
		loadOnStartup = 5)
public class FirstSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		// 获得会话ID
		var sessionId = session.getId();
		
		session.setAttribute("reader", "zhiwenLin");
		var reader = session.getAttribute("reader");
		response.getWriter().write("reader=" + reader + "<br/>");
		session.removeAttribute("reader");
		
		response.getWriter().write("会话ID：" + sessionId + "<br/>");
	}
}
