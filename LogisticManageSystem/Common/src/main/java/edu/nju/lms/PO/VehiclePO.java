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
	/**
	 * car's dai hao
	 */
	private String vehicleNum;
	/**
	 * plate number
	 */
	private String plateNum;
	/**
	 * fu yi time
	 */
	private int serviceYears;
	
	public VehiclePO(String vehicleNum, String plateNum, int serviceYears) {
		super();
		this.vehicleNum = vehicleNum;
		this.plateNum = plateNum;
		this.serviceYears = serviceYears;
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
	
	
}
