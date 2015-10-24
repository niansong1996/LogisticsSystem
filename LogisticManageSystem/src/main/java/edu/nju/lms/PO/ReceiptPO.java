package edu.nju.lms.PO;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ReceiptPO {
	private Calendar receiptDate;
	private double amount;
	private long courierNum;
	private ArrayList<Long> expressNums;
	
	public ReceiptPO(Calendar receiptDate, double amount, long courierNum, ArrayList<Long> expressNums) {
		super();
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

	public long getCourierNum() {
		return courierNum;
	}

	public void setCourierNum(long courierNum) {
		this.courierNum = courierNum;
	}

	public ArrayList<Long> getExpressNums() {
		return expressNums;
	}

	public void setExpressNums(ArrayList<Long> expressNums) {
		this.expressNums = expressNums;
	}
	
	
}
