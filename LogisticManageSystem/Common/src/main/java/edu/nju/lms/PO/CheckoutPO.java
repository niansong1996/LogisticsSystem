package edu.nju.lms.PO;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.LoadType;

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
	private String destination;//demonstrated by the citypo's id
	private LoadType loadType;
	/**
	 * the number of arrival list
	 */
	private String arrivalNum;
	/**
	 * 汽运单编号
	 */
	private String motorNum;
	
	public CheckoutPO(String id,String state,String expressNums, String checkoutDate, String destination, String loadType,
			String arrivalNum, String motorNum) {
		super(id,ListState.valueOf(state));
		CommonUtility.String2Array(this.expressNums,expressNums);
		this.checkoutDate = CommonUtility.String2Cal(checkoutDate);
		this.destination = destination;
		this.loadType = LoadType.valueOf(loadType);
		this.arrivalNum = arrivalNum;
		this.motorNum = motorNum;
	}
	
	public CheckoutPO(String id,String state,ArrayList<String> expressNums, Calendar checkoutDate, String destination, LoadType loadType,
			String arrivalNum, String motorNum) {
		super(id,ListState.valueOf(state));
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

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
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
