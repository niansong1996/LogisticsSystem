package edu.nju.lms.PO;

import java.io.Serializable;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class VehiclePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5891429209039094359L;
	private String plateNum;
	private String vehicleNum;
	private int serviceYears;
	private String businessHallNum;
	
	public VehiclePO(String vehicleNum, String plateNum,String businessHallNum, int serviceYears) {
		super();
		this.vehicleNum = vehicleNum;
		this.plateNum = plateNum;
		this.serviceYears = serviceYears;
		this.businessHallNum=businessHallNum;
	}
	public String getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	public int getServiceYears() {
		return serviceYears;
	}
	public void setServiceYears(int serviceYears) {
		this.serviceYears = serviceYears;
	}
	public String getBusinessHallNum() {
		return businessHallNum;
	}
	public void setBusinessHallNum(String businessHallNum) {
		this.businessHallNum = businessHallNum;
	}
	
}
