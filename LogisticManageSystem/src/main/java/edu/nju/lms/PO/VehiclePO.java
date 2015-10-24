package edu.nju.lms.PO;
/**
 *@author tj
 *@date 2015年10月24日
 */
public class VehiclePO {
	//车辆代号
	private long vehicleNum;
	//车牌号
	private String plateNum;
	//服役时间
	private int serviceYears;
	
	public VehiclePO(long vehicleNum, String plateNum, int serviceYears) {
		super();
		this.vehicleNum = vehicleNum;
		this.plateNum = plateNum;
		this.serviceYears = serviceYears;
	}
	public long getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(long vehicleNum) {
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
