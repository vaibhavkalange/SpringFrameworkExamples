package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Circle {
	
	private String name;
	@Id
	private int id;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}