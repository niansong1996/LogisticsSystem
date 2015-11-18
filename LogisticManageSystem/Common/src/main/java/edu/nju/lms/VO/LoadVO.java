package edu.nju.lms.VO;

import java.util.ArrayList;
import java.util.Calendar;

public class LoadVO extends ListVO{
	private String loadDate;
	//current businesshall
	private String businessHallNum;
	//qiyunbianhao
	private String motorNum;
	//destiny businesshall
	private String destiBusinessHall;
	//cheliangdaihao
	private String vehicleNum;
	private String driverNum;
	private ArrayList<String> commodityNums;
	
	private double freight;
	
	public LoadVO(String id, String loadDate, String businessHallNum,
			String motorNum, String destiBusinessHall,
			String vehicleNum, String driverNum, ArrayList<String> commodityNums,
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

	public String getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(String loadDate) {
		this.loadDate = loadDate;
	}

	public String getBusinessHallNum() {
		return businessHallNum;
	}

	public void setBusinessHallNum(String businessHallNum) {
		this.businessHallNum = businessHallNum;
	}

	public String getMotorNum() {
		return motorNum;
	}

	public void setMotorNum(String motorNum) {
		this.motorNum = motorNum;
	}

	public String getDestiBusinessHall() {
		return destiBusinessHall;
	}

	public void setDestiBusinessHall(String destiBusinessHall) {
		this.destiBusinessHall = destiBusinessHall;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getDriverNum() {
		return driverNum;
	}

	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}

	public ArrayList<String> getCommodityNums() {
		return commodityNums;
	}

	public void setCommodityNums(ArrayList<String> commodityNums) {
		this.commodityNums = commodityNums;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	
}
