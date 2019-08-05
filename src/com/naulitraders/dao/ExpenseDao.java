package com.naulitraders.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.naulitraders.model.ExpenseInfo;

public class ExpenseDao {

	public int insertExpenseInfo(ExpenseInfo expenseInfo) {
		String sql = "insert into expenses(vehNum,dates,amount,remarks) values(?,?,?,?)";

		try {
			Connection con = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, expenseInfo.getTruckNumber());
			pst.setDate(2, Date.valueOf(expenseInfo.getExpenseDate()));
			pst.setDouble(3, expenseInfo.getAmount());
			pst.setString(4, expenseInfo.getRemarks());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1); // return auto generated key after insert, i.e. expenseId
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

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
	
	public List<ExpenseInfo> getExpenses(String vehNumber, LocalDate expenseStartDate, LocalDate expenseEndDate) {
		
		List<ExpenseInfo> listOfExpenses = new ArrayList<>();
		
		String sql = "SELECT dates, remarks, amount FROM expenses WHERE vehNum = ? AND dates >= ? AND dates <= ?";
		
		try {
			Connection conn = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, vehNumber);
			pst.setDate(2, Date.valueOf(expenseStartDate));
			pst.setDate(3, Date.valueOf(expenseEndDate));

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				ExpenseInfo expenseInfo = new ExpenseInfo();
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