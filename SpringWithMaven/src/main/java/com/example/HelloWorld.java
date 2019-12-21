package com.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld implements InitializingBean, DisposableBean {
	
	private String message;
	
	public HelloWorld(String message){
		this.message = message;
	}
	
	public void hello(){
		System.out.println(message);
	}
	
	public void myInit(){
		System.out.println("My Init is called from HelloWorld....!");
	}
	
	public void myDestroy(){
		System.out.println("My Destroy is called from HelloWorld.. !");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean Destroy is called from HelloWorld....!");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean Init is called from HelloWorld....!");
	}

}
