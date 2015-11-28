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
	
	public VehiclePO(String plateNum,String vehicleNum, String serviceYears, String businessHallNum) {
		super();
		this.vehicleNum = vehicleNum;
		this.plateNum = plateNum;
		this.serviceYears = Integer.parseInt(serviceYears);
		this.businessHallNum=businessHallNum;
	}
	
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
	@Override
	public boolean equals(Object object){
		VehiclePO vehicle = (VehiclePO)object;
		if(this.businessHallNum.equals(vehicle.businessHallNum))
			if(this.plateNum.equals(vehicle.plateNum))
				if(this.serviceYears==vehicle.serviceYears)
					if(this.vehicleNum.equals(vehicle.vehicleNum))
						return true;
		return false;
	}
}
