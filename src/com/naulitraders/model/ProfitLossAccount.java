package com.naulitraders.model;

import java.util.ArrayList;
import java.util.List;

public class ProfitLossAccount {
	
	private List<TripInfo> trips;
	
	private List<ExpenseInfo> expenses;
	
	private double totalRevenue;
	
	private double totalExpenses;
	
	private double profitLoss;

	public List<TripInfo> getTrips() {
		return trips;
	}

	public void setTrips(List<TripInfo> trips) {
		this.trips = trips;
	}

	public List<ExpenseInfo> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<ExpenseInfo> expenses) {
		this.expenses = expenses;
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public double getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(double totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	public double getProfitLoss() {
		return profitLoss;
	}

	public void setProfitLoss(double profitLoss) {
		this.profitLoss = profitLoss;
	}

}
