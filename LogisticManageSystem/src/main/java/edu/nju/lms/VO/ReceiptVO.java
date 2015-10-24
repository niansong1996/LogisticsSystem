package edu.nju.lms.VO;

import java.util.ArrayList;
import java.util.Calendar;


public class ReceiptVO extends ListVO{
	private Calendar receiptDate;
	private long courierNum;
	private double amount;
	private ArrayList<Long> expressNums;
	
	public ReceiptVO(long id,Calendar receiptDate, double amount, long courierNum, ArrayList<Long> expressNums) {
		super(id);
		this.receiptDate = receiptDate;
		this.amount = amount;
		this.courierNum = courierNum;
		this.expressNums = expressNums;
	}
	
	public Calendar getDate() {
		return receiptDate;
	}
	public void setDate(Calendar date) {
		this.receiptDate = date;
	}

	public Calendar getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Calendar receiptDate) {
		this.receiptDate = receiptDate;
	}

	public long getCourierNum() {
		return courierNum;
	}

	public void setCourierNum(long courierNum) {
		this.courierNum = courierNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getMoney() {
		return amount;
	}
	public void setMoney(double money) {
		this.amount = money;
	}
	public ArrayList<Long> getExpressNums() {
		return expressNums;
	}
	public void setExpressNums(ArrayList<Long> expressNums) {
		this.expressNums = expressNums;
	}
	
	
}
