package com.example.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.shape.Shape;
import com.example.shape.Triangle;

public class DrawingApp {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Shape shape = context.getBean("triangle", Triangle.class);
		shape.draw();
	}

}
