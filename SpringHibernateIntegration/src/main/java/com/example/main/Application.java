package com.example.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.HibernateDaoIml;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		HibernateDaoIml dao = context.getBean("hibernateDaoIml", HibernateDaoIml.class);
		System.out.println(dao.getCircleCount());
	}

}
