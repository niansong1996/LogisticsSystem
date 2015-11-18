package edu.nju.lms.PO;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ReceiptPO extends ListPO {
	private Calendar receiptDate;
	private double amount;
	private String courierNum;
	private ArrayList<String> expressNums;
	
	public ReceiptPO(String id,Calendar receiptDate, double amount, String courierNum, ArrayList<String> expressNums) {
		super(id);
		this.receiptDate = receiptDate;
		this.amount = amount;
		this.courierNum = courierNum;
		this.expressNums = expressNums;
	}

	public Calendar getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Calendar receiptDate) {
		this.receiptDate = receiptDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCourierNum() {
		return courierNum;
	}

	public void setCourierNum(String courierNum) {
		this.courierNum = courierNum;
	}

	public ArrayList<String> getExpressNums() {
		return expressNums;
	}

	public void setExpressNums(ArrayList<String> expressNums) {
		this.expressNums = expressNums;
	}
	
	
}
