package edu.nju.lms.PO;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.data.PartitionType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class CheckoutPO extends ListPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6939485649504767770L;
	private ArrayList<String> expressNums;
	private Calendar checkoutDate;
	private CityPO destination;
	private PartitionType loadType;
	/**
	 * the number of arrival list
	 */
	private String arrivalNum;
	/**
	 * 汽运单编号
	 */
	private String motorNum;
	
	public CheckoutPO(String id,ArrayList<String> expressNums, Calendar checkoutDate, CityPO destination, PartitionType loadType,
			String arrivalNum, String motorNum) {
		super(id);
		this.expressNums = expressNums;
		this.checkoutDate = checkoutDate;
		this.destination = destination;
		this.loadType = loadType;
		this.arrivalNum = arrivalNum;
		this.motorNum = motorNum;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<String> getExpressNums() {
		return expressNums;
	}

	public void setExpressNums(ArrayList<String> expressNums) {
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
