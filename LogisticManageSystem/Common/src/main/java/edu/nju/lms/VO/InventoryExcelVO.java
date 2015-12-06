package edu.nju.lms.VO;

import java.util.ArrayList;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class InventoryExcelVO {
	
	
	private ArrayList<String> expressNums;
	
	private ArrayList<String> checkinTime;
	
	private ArrayList<String> destination;
	
	private ArrayList<String> location;

	
	
	public InventoryExcelVO(ArrayList<String> expressNums, ArrayList<String> checkinTime, ArrayList<String> destination,
			ArrayList<String> location) {
		super();
		this.expressNums = expressNums;
		this.checkinTime = checkinTime;
		this.destination = destination;
		this.location = location;
	}

	public ArrayList<String> getExpressNums() {
		return expressNums;
	}

	public void setExpressNums(ArrayList<String> expressNums) {
		this.expressNums = expressNums;
	}

	public ArrayList<String> getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(ArrayList<String> checkinTime) {
		this.checkinTime = checkinTime;
	}

	public ArrayList<String> getDestination() {
		return destination;
	}

	public void setDestination(ArrayList<String> destination) {
		this.destination = destination;
	}

	public ArrayList<String> getLocation() {
		return location;
	}

	public void setLocation(ArrayList<String> location) {
		this.location = location;
	}
	
	
}
