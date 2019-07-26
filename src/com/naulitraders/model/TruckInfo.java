package com.naulitraders.model;

public class TruckInfo {
	
	private String truckNumber;
	private String brand;
	private int model;
	private int capacity;
	private int tyres;
	private int year;
	
	public TruckInfo() {
		
	}
	
	public TruckInfo(String truckNumber, String brand, int model, int capacity, int tyres, int year) {
		super();
		this.truckNumber = truckNumber;
		this.brand = brand;
		this.model = model;
		this.capacity = capacity;
		this.tyres = tyres;
		this.year = year;
	}
	
	public String getTruckNumber() {
		return truckNumber;
	}
	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getModel() {
		return model;
	}
	public void setModel(int model) {
		this.model = model;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getTyres() {
		return tyres;
	}
	public void setTyres(int tyres) {
		this.tyres = tyres;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	

}
