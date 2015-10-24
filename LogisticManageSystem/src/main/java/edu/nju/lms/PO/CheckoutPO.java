package edu.nju.lms.PO;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class CheckoutPO {
	private ArrayList<Long> expressNums;
	private Calendar checkoutDate;
	private CityPO destination;
	private PartitionType loadType;
	private long arrivalNum;
	private long motorNum;
	
	public CheckoutPO(ArrayList<Long> expressNums, Calendar checkoutDate, CityPO destination, PartitionType loadType,
			long arrivalNum, long motorNum) {
		super();
		this.expressNums = expressNums;
		this.checkoutDate = checkoutDate;
		this.destination = destination;
		this.loadType = loadType;
		this.arrivalNum = arrivalNum;
		this.motorNum = motorNum;
	}

	public ArrayList<Long> getExpressNums() {
		return expressNums;
	}

	public void setExpressNums(ArrayList<Long> expressNums) {
		this.expressNums = expressNums;
	}

	public Calendar getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Calendar checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public CityPO getDestination() {
		return destination;
	}

	public void setDestination(CityPO destination) {
		this.destination = destination;
	}

	public PartitionType getLoadType() {
		return loadType;
	}

	public void setLoadType(PartitionType loadType) {
		this.loadType = loadType;
	}

	public long getArrivalNum() {
		return arrivalNum;
	}

	public void setArrivalNum(long arrivalNum) {
		this.arrivalNum = arrivalNum;
	}

	public long getMotorNum() {
		return motorNum;
	}

	public void setMotorNum(long motorNum) {
		this.motorNum = motorNum;
	}
	
	
}