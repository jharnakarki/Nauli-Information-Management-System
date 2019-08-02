package com.naulitraders.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.naulitraders.model.ExpenseInfo;
import com.naulitraders.model.TripInfo;

public class ExpenseDao {

	public void insertExpenseInfo(ExpenseInfo expenseInfo) {
		String sql = "insert into expenses(vehNum,dates,amount,remarks) values(?,?,?,?)";

		try {
			Connection con = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, expenseInfo.getTruckNumber());
			pst.setDate(2, Date.valueOf(expenseInfo.getExpenseDate()));
			pst.setDouble(3, expenseInfo.getAmount());
			pst.setString(4, expenseInfo.getRemarks());

			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateExpense(ExpenseInfo expenseInfo) {
		String sql = "UPDATE expenses SET  dates=?,amount=?,remarks=? WHERE expenseId = ?";

		try {
			Connection conn = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(expenseInfo.getExpenseDate()));
			pst.setDouble(2, expenseInfo.getAmount());
			pst.setString(3, expenseInfo.getRemarks());
			pst.setInt(4, expenseInfo.getExpenseId());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ExpenseInfo getExpense(int expenseId) {
		ExpenseInfo expenseInfo = null;

		String sql = "SELECT expenseId, vehNum,dates,amount,remarks FROM expenses WHERE expenseId = ?";

		try {
			Connection conn = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, expenseId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				expenseInfo = new ExpenseInfo();

				expenseInfo.setExpenseId(rs.getInt("expenseId"));
				expenseInfo.setTruckNumber(rs.getString("vehNum"));
				expenseInfo.setExpenseDate(rs.getDate("dates").toLocalDate());
				expenseInfo.setAmount(rs.getDouble("amount"));
				expenseInfo.setRemarks(rs.getString("remarks"));
				// it should be only one result, so break out of loop
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return expenseInfo;
	}
	// to get list of trip
		public List<ExpenseInfo> getExpenseList() {

			List<ExpenseInfo> listOfExpenses = new ArrayList<>();

			String sql = "SELECT expenseId,vehNum,dates,amount,remarks FROM expenses";

			Statement statement;

			try {
				Connection conn = DBConnection.getConnectionToDatabase();

				statement = conn.createStatement();

				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					ExpenseInfo expenseInfo = new ExpenseInfo();
					expenseInfo.setExpenseId(rs.getInt("expenseId"));
					expenseInfo.setTruckNumber(rs.getString("vehNum"));
					expenseInfo.setExpenseDate(rs.getDate("dates").toLocalDate());
					expenseInfo.setAmount(rs.getDouble("amount"));
					expenseInfo.setRemarks(rs.getString("remarks"));

					listOfExpenses.add(expenseInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listOfExpenses;
		}
}