package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTestApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		//AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		HelloWorld helloWorld = context.getBean(HelloWorld.class, "helloWorld");

		helloWorld.hello();

	}

}
