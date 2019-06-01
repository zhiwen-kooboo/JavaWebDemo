package com.codepie.downloads;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "DownloadServlet", urlPatterns = {"/DownloadServlet"},
		loadOnStartup = 5)
public class DownloadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取文件名
		String fileName = request.getParameter("fileName");
		
		// 获取流
		InputStream is = getServletContext().getResourceAsStream("test/" + fileName);
		
		// 设置成下载格式(默认是直接在浏览器打开)
		// response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		OutputStream os = response.getOutputStream();
		
		// 输出
		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		
		os.close();
		is.close();
	}
}
