package edu.nju.lms.VO;

public class VehicleVO {
	private String plateNum;
	private long vehicleNum;
	private int serviceYears;
	
	public VehicleVO(long vehicleNum, String plateNum, int serviceYears) {
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
