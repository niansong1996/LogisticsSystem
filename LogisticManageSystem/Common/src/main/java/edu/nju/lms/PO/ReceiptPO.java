package edu.nju.lms.PO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.data.PaymentType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ReceiptPO extends ListPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6546369664824813665L;
	private Calendar receiptDate;
	private double amount;
	private String courierNum;
	private ArrayList<String> expressNums;
	
	
	public ReceiptPO(String id,String receiptDate, String amount, String courierNum, String expressNums) {
		super(id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.receiptDate = Calendar.getInstance();
		try {
			this.receiptDate.setTime(sdf.parse(receiptDate));
		} catch (ParseException e) {System.out.println("parse failed!!!");}
		this.amount = Double.parseDouble(amount);
		this.courierNum = courierNum;
		String expressNumsTmp = expressNums.replace("[", "").replace("]", "");
		if(!expressNumsTmp.equals("")){
		String expressNumsTmpArray[] = expressNumsTmp.split(", ");
		for(String tmp : expressNumsTmpArray) this.expressNums.add(tmp);
		}
	}
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
	@Override 
	public boolean equals(Object object){
		ReceiptPO receipt = (ReceiptPO)object;
			if(this.receiptDate.getTime().getYear()==receipt.receiptDate.getTime().getYear())
				if(this.receiptDate.getTime().getMonth()==receipt.receiptDate.getTime().getMonth())
					if(this.receiptDate.getTime().getDay()==receipt.receiptDate.getTime().getDay())
				if(this.courierNum.equals(receipt.courierNum))
					if(this.amount==receipt.amount)
//						if(this.expressNums.toString().equals(receipt.expressNums.toString()))
						return true;
		return false;
	}
	
}
