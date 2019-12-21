package com.example.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.CircleDAOImpl;

public class Application {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring.xml");
		CircleDAOImpl dao = context.getBean("circleDAOImpl", CircleDAOImpl.class);
	//	System.out.println(dao.getCircleById(1).getName());
	//	System.out.println(dao.getCircleCount());
	//	System.out.println(dao.getCircleName(1));
		
		//System.out.println(dao.getCircle(1).getName());
		/*Circle circle = new Circle();
		circle.setId(3); circle.setName("Third Circle");
		dao.insertCircle(circle);*/
		System.out.println(dao.getAllCircle());
	}

}
