package com.codepie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet(name = "ServletContext01", urlPatterns = {"/ServletContext01"},
		loadOnStartup = 5,
		initParams = {@WebInitParam(name = "username22", value = "zhiwen")})
public class ServletContext01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var context = getServletContext();
		
		// 获取所有的context param
		var keys = context.getInitParameterNames();
		while (keys.hasMoreElements()) {
			String s = keys.nextElement();
			System.out.println("context-param = " + s);
		}
		
		// getConfig1();
		// getConfig2();
		getConfig3();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	/**
	 * 根据绝对路径获取流对象
	 *
	 * @throws IOException
	 */
	private void getConfig1() throws IOException {
		var context = getServletContext();
		
		// 获取config.properties上的属性
		Properties properties = new Properties();
		InputStream is = new FileInputStream(context.getRealPath("configs/config.properties"));
		properties.load(is);
		
		String name = properties.getProperty("name");
		System.out.println(String.format("name = %s", name));
	}
	
	/**
	 * 根据相对路径直接获取流对象
	 *
	 * @throws IOException
	 */
	private void getConfig2() throws IOException {
		var context = getServletContext();
		
		// 获取config.properties上的属性
		Properties properties = new Properties();
		InputStream is = context.getResourceAsStream("configs/config.properties");
		properties.load(is);
		
		String name = properties.getProperty("name");
		System.out.println(String.format("name = %s", name));
	}
	
	/**
	 * 根据classLoader获取工程下的资源
	 *
	 * @throws IOException
	 */
	private void getConfig3() throws IOException {
		// 获取config.properties上的属性
		Properties properties = new Properties();
		
		// 这里的相对路径是相对
		InputStream is = this
				.getClass()
				.getClassLoader()
				.getResourceAsStream("../../configs/config.properties");
		properties.load(is);
		
		String name = properties.getProperty("name");
		System.out.println(String.format("name = %s", name));
		is.close();
	}
}
