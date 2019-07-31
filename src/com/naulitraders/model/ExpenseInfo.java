package com.naulitraders.model;

import java.time.LocalDate;

public class ExpenseInfo {
	private String truckNumber;
	private LocalDate expenseDate;
	private double amount;
	private String remarks;

	public ExpenseInfo() {

	}

	public ExpenseInfo(String truckNumber, LocalDate expenseDate, double amount, String remarks) {
		super();
		this.truckNumber = truckNumber;
		this.expenseDate = expenseDate;
		this.amount = amount;
		this.remarks = remarks;
	}

	public String getTruckNumber() {
		return truckNumber;
	}

	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}

	public LocalDate getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}

