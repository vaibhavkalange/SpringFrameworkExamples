package com.example.shape;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.example.events.DrawEvent;

@Component
public class Triangle implements Shape, ApplicationEventPublisherAware {

	@Autowired
	@Qualifier(value="pointA")
	private Point pointA;
	@Autowired
	private Point pointB;
	@Autowired
	private Point pointC;
	
	private ApplicationEventPublisher publisher;
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	@Override
	public void draw() {
		DrawEvent event = new DrawEvent(this);
		publisher.publishEvent(event);
		System.out.println("Drawing Triangle...!");
		System.out.println("Point A : {"+pointA.getPointX()+","+pointA.getPointY()+"}");
		System.out.println("Point B : {"+pointB.getPointX()+","+pointB.getPointY()+"}");
		System.out.println("Point C : {"+pointC.getPointX()+","+pointC.getPointY()+"}");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

}
