package com.naulitraders.model;
import java.io.InputStream;
import java.util.Date;
public class ExpenseInfo {
	private String truckNumber;
	private Double amount;
	private String remarks;
	private Date expDate;
	private InputStream inputStream ;
	
	public ExpenseInfo(String truckNumber, Double amount, String remarks , Date expDate, InputStream inputStream) {
		super();
		this.truckNumber = truckNumber;
		this.amount = amount;
		this.remarks = remarks;
		this.expDate = expDate;
		this.inputStream = inputStream;
		
	}

	    public String getTruckNumber() {
	        return truckNumber;
	    }

	    public void setTruckNumber(String truckNumber) {
	        this.truckNumber = truckNumber;
	    }

	    public Double getAmount() {
	        return amount;
	    }

	    public void setAmount(Double amount) {
	        this.amount = amount;
	    }

	    public String getRemarks() {
	        return remarks;
	    }

	    public void setRemark(String remarks) {
	        this.remarks = remarks;
	    }

	    public Date getExpDate() {
	        return expDate;
	    }

	    public void setExpdate(Date expDate) {
	        this.expDate = expDate;
	    }

	    public InputStream getInputStream() {
	        return inputStream;
	    }

	    public void setInputStream(InputStream inputStream) {
	        this.inputStream = inputStream;
	    }
	    
	}



