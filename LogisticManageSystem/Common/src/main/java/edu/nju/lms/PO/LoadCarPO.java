package edu.nju.lms.PO;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListState;

public class LoadcarPO extends ListPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2214418940416103203L;
	private Calendar loadDate;
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
	
	public LoadcarPO(String id, String state,String loadDate, String businessHallNum,
			String motorNum, String destiBusinessHall,
			String vehicleNum, String driverNum, String commodityNums,
			String freight) {
		super(id,ListState.valueOf(state));
		this.commodityNums = new ArrayList<String>();
		this.loadDate = CommonUtility.String2Cal(loadDate);
		this.businessHallNum = businessHallNum;
		this.motorNum = motorNum;
		this.destiBusinessHall = destiBusinessHall;
		this.vehicleNum = vehicleNum;
		this.driverNum = driverNum;
		CommonUtility.String2Array(this.commodityNums, commodityNums);
		this.freight = Double.parseDouble(freight);
	}
	
	public LoadcarPO(String id, String state,Calendar loadDate, String businessHallNum,
			String motorNum, String destiBusinessHall,
			String vehicleNum, String driverNum, ArrayList<String> commodityNums,
			double freight) {
		super(id,ListState.valueOf(state));
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
