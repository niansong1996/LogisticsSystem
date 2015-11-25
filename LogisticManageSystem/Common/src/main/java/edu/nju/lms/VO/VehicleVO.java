package edu.nju.lms.VO;

public class VehicleVO {
	/**
	 *plateNum is chepaihao,vehicleNum is cheliangdaihao 
	 */
	private String plateNum;
	private String vehicleNum;
	private int serviceYears;
	private String businessHallNum;
	
	public VehicleVO(String plateNum,String vehicleNum, String businessHallNum, int serviceYears) {
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
