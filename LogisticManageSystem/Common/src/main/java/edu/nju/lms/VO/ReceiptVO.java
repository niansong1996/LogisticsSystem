package edu.nju.lms.VO;

import java.util.ArrayList;
import java.util.Calendar;


public class ReceiptVO extends ListVO{
	private String receiptDate;
	//number of kuaidiyuan
	private String courierNum;
	private double amount;
	private ArrayList<String> expressNums;
	
	public ReceiptVO(String id,String receiptDate, double amount, String courierNum, ArrayList<String> expressNums) {
		super(id);
		this.receiptDate = receiptDate;
		this.amount = amount;
		this.courierNum = courierNum;
		this.expressNums = expressNums;
	}
	
	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getCourierNum() {
		return courierNum;
	}

	public void setCourierNum(String courierNum) {
		this.courierNum = courierNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ArrayList<String> getExpressNums() {
		return expressNums;
	}
	public void setExpressNums(ArrayList<String> expressNums) {
		this.expressNums = expressNums;
	}
}
