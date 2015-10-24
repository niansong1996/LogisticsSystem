package edu.nju.lms.VO;

import java.util.ArrayList;
import java.util.Calendar;

public class LoadVO extends ListVO{
	private Calendar loadDate;
	private long businessHallNum;
	private long motorNum;
	
	private long destiBusinessHall;
	private long vehicleNum;
	private long driverNum;
	private ArrayList<Long> commodityNums;
	
	private double freight;
	
	public LoadVO(long id, Calendar loadDate, long businessHallNum,
			long motorNum, long destiBusinessHall,
			long vehicleNum, long driverNum, ArrayList<Long> commodityNums,
			double freight) {
		super(id);
		this.loadDate = loadDate;
		this.businessHallNum = businessHallNum;
		this.motorNum = motorNum;
		this.destiBusinessHall = destiBusinessHall;
		this.vehicleNum = vehicleNum;
		this.driverNum = driverNum;
		this.commodityNums = commodityNums;
		this.freight = freight;
	}

	public Calendar getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Calendar loadDate) {
		this.loadDate = loadDate;
	}

	public long getBusinessHallNum() {
		return businessHallNum;
	}

	public void setBusinessHallNum(long businessHallNum) {
		this.businessHallNum = businessHallNum;
	}

	public long getMotorNum() {
		return motorNum;
	}

	public void setMotorNum(long motorNum) {
		this.motorNum = motorNum;
	}

	public long getDestiBusinessHall() {
		return destiBusinessHall;
	}

	public void setDestiBusinessHall(long destiBusinessHall) {
		this.destiBusinessHall = destiBusinessHall;
	}

	public long getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(long vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public long getDriverNum() {
		return driverNum;
	}

	public void setDriverNum(long driverNum) {
		this.driverNum = driverNum;
	}

	public ArrayList<Long> getCommodityNums() {
		return commodityNums;
	}

	public void setCommodityNums(ArrayList<Long> commodityNums) {
		this.commodityNums = commodityNums;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	
}
