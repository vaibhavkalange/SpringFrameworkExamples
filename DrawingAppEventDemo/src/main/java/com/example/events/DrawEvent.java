package com.example.events;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7661298443642018645L;

	public DrawEvent(Object source) {
		super(source);
	}

	@Override
	public String toString() {
		return "DrawEvent Occured...!";
	}
	
	

}
