package com.naulitraders.model;

public class EmployeeInfo {
	String name;
	int age;
	String address;
	int contact;
	String position;
	double salary;

	public EmployeeInfo(String name, int age, String address, int contact, String position, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.contact = contact;
		this.position = position;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
