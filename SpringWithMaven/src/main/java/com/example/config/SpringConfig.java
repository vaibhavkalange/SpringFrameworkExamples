package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.DisplayBeanPostProcessor;
import com.example.HelloWorld;

@Configuration
@ComponentScan(basePackages=("com.example"))
public class SpringConfig {
	
	
	@Bean(initMethod="myInit", destroyMethod="myDestroy")
	public HelloWorld helloWorld(){
		return new HelloWorld("Say Hello");
	}
	
	@Bean
	public DisplayBeanPostProcessor displayBeanPostProcessor(){
		return new DisplayBeanPostProcessor();
	}

}
