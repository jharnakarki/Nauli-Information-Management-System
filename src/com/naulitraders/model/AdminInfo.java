package com.naulitraders.model;

public class AdminInfo {
	private int adminId;
	private String username;
	private String password;
	
	public AdminInfo() {
		
	}
	

	public AdminInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	
	}
	
	public int adminId() {
		return adminId;
	}
	
	public void setadminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}

