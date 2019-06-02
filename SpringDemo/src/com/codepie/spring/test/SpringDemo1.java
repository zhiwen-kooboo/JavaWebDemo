package com.codepie.spring.test;

import com.codepie.spring.user.UserService;
import com.codepie.spring.user.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {
	@Test
	/**
	 * 传统方式调用
	 */
	public void demo1() {
		UserService userService = new UserServiceImpl();
		userService.save();
	}
	
	@Test
	/**
	 * spring方式调用
	 */
	public void demo2() {
		// 创建spring工厂
		ApplicationContext context = new
				ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.save();
	}
}
