package com.naulitraders.model;

public class EmployeeInfo {
	private int empId;
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
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
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


	@Override
	public String toString() {
		return "EmployeeInfo [empId=" + empId + ", name=" + name + ", position=" + position + ", phoneNumber="
				+ phoneNumber + ", salary=" + salary + "]";
	}
	
	

}

