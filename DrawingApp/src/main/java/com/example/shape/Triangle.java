package com.example.shape;

public class Triangle implements Shape {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
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
		System.out.println("Drawing Triangle...!");
		System.out.println("Point A : {"+pointA.getPointX()+","+pointA.getPointY()+"}");
		System.out.println("Point B : {"+pointB.getPointX()+","+pointB.getPointY()+"}");
		System.out.println("Point C : {"+pointC.getPointX()+","+pointC.getPointY()+"}");
	}

}
