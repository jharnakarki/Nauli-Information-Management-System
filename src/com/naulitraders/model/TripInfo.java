package com.naulitraders.model;
import java.util.Date;
public class TripInfo {
	private  String truckNumber ;
	private  Date startDate;
	private Date endDate;
	private int startMileage ;
	private int endMileage ;
	private String origin ;
	private String mulDestination ;
	private int revenue ;
	private String driverName ;
	private String remarks;

	public TripInfo(String truckNumber,Date startDate,Date endDate,int startMileage , int endMileage,String origin 
			,String mulDestination,int revenue ,String driverName, String remarks) {
		super();
		this.truckNumber = truckNumber;
		this.startDate =startDate;
		this.endDate = endDate;
		this.startMileage = startMileage;
		this.endMileage =endMileage;
		this.origin = origin;
		this.mulDestination=mulDestination;
		this.revenue=revenue;
		this.driverName=driverName;
		this.remarks=remarks;
	}

	

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStartMileage() {
        return startMileage;
    }

    public void setStartMileage(int startMileage) {
        this.startMileage = startMileage;
    }

    public int getEndMileage() {
        return endMileage;
    }

    public void setEndMileage(int endMileage) {
        this.endMileage = endMileage;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMulDestination() {
        return mulDestination;
    }

    public void setMulDestination(String mulDestination) {
        this.mulDestination = mulDestination;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}