package edu.nju.lms.PO;

import java.io.Serializable;

public class InventoryPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7238013501176144206L;
	String warehouseId;
	String expressNum;
	String checkinTime;
	String destination;
	String location;
	public InventoryPO(String warehouseId,String expressNum, String checkinTime, String destination, String location) {
		this.warehouseId = warehouseId;
		this.expressNum = expressNum;
		this.checkinTime = checkinTime;
		this.destination = destination;
		this.location = location;
	}
	public String getExpressNum() {
		return expressNum;
	}
	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}
	public String getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	
}
