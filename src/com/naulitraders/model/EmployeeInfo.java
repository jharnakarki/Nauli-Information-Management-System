package com.naulitraders.model;

public class EmployeeInfo {
	private String name;
	private String position;
	private String phoneNumber;
	private double salary;
	
	

	public EmployeeInfo(String name, String position, String phoneNumber, double salary) {
		super();
		this.name = name;
		this.position = position;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
