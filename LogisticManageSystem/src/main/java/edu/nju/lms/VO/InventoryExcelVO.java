package edu.nju.lms.VO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import edu.nju.lms.PO.Location;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class InventoryExcelVO {
	
	
	private ArrayList<String> expressNums;
	
	private ArrayList<String> checkinTime;
	
	private ArrayList<String> destination;
	
	private ArrayList<String> id;

	
	
	public InventoryExcelVO(ArrayList<String> expressNums, ArrayList<String> checkinTime, ArrayList<String> destination,
			ArrayList<String> id) {
		super();
		this.expressNums = expressNums;
		this.checkinTime = checkinTime;
		this.destination = destination;
		this.id = id;
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

	public ArrayList<String> getId() {
		return id;
	}

	public void setId(ArrayList<String> id) {
		this.id = id;
	}
	
	
}
