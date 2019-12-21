package com.example.model;

import java.util.List;

public class User {
	private Integer id;
	private String name;
	private String email;
	private String address;
	private List<String> frameworks;
	private String country;
	private List<String> skills;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getFrameworks() {
		return frameworks;
	}
	public void setFrameworks(List<String> frameworks) {
		this.frameworks = frameworks;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	public boolean isNew(){
		return (this.id == null);
	}
	
}
