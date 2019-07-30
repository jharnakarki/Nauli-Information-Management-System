package com.naulitraders.model;

public class EmployeeInfo {
	private String name;
	private String position;
	private Long phoneNumber;
	private double salary;
	
	public EmployeeInfo() {
		
	}
	

	public EmployeeInfo(String name, String position, Long phoneNumber, double salary) {
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
