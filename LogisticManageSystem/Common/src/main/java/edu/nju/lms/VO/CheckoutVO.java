package edu.nju.lms.VO;

import java.util.ArrayList;

import edu.nju.lms.data.LoadType;

public class CheckoutVO extends ListVO{
	private ArrayList<String> expressNums;
	private String checkoutDate;
	private ArrayList<String> destination;
	private LoadType loadType;
	/**
	 * arrival list id
	 */
	private String arrivalNum;
	/**
	 * qi yun bian hao 
	 */
	private String motorNum;
	public CheckoutVO(String id, ArrayList<String> expressNums, String checkoutDate, ArrayList<String> destination,
			LoadType loadType, String arrivalNum, String motorNum) {
		super(id);
		this.expressNums = expressNums;
		this.checkoutDate = checkoutDate;
		this.destination = destination;
		this.loadType = loadType;
		this.arrivalNum = arrivalNum;
		this.motorNum = motorNum;
	}
	
	public CheckoutVO(String id, ArrayList<String> expressNums, ArrayList<String> destination,
			LoadType loadType, String arrivalNum, String motorNum) {
		super(id);
		this.expressNums = expressNums;
		this.destination = destination;
		this.loadType = loadType;
		this.arrivalNum = arrivalNum;
		this.motorNum = motorNum;
	}
	
	public ArrayList<String> getExpressNums() {
		return expressNums;
	}
	public void setExpressNums(ArrayList<String> expressNums) {
		this.expressNums = expressNums;
	}
	public String getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public ArrayList<String> getDestination() {
		return destination;
	}
	public void setDestination(ArrayList<String> destination) {
		this.destination = destination;
	}
	public LoadType getLoadType() {
		return loadType;
	}
	public void setLoadType(LoadType loadType) {
		this.loadType = loadType;
	}
	public String getArrivalNum() {
		return arrivalNum;
	}
	public void setArrivalNum(String arrivalNum) {
		this.arrivalNum = arrivalNum;
	}
	public String getMotorNum() {
		return motorNum;
	}
	public void setMotorNum(String motorNum) {
		this.motorNum = motorNum;
	}
	
	
	
	

}
