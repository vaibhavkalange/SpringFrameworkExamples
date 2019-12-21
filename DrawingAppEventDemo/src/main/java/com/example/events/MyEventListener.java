package com.example.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author VAIBHAV
 *
 *	This class is used to handle all types of ApplicationEvent
 */
@Component
public class MyEventListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("Event Listener..!");
		System.out.println(event.toString());
	}

}
