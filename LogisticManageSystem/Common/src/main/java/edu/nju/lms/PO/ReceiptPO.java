package edu.nju.lms.PO;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListState;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ReceiptPO extends ListPO {
	/**
	 * have been modified for sql
	 */
	private static final long serialVersionUID = 6546369664824813665L;
	private Calendar receiptDate;
	private double amount;
	private String courierNum;
	private ArrayList<String> expressNums;
	
	
	public ReceiptPO(String id,String state,String receiptDate, String amount, String courierNum, String expressNums) {
		super(id,ListState.valueOf(state));
		this.expressNums = new ArrayList<String>();
		this.receiptDate = CommonUtility.String2Cal(receiptDate);
		this.amount = Double.parseDouble(amount);
		this.courierNum = courierNum;
		CommonUtility.String2Array(this.expressNums, expressNums);
	}
	public ReceiptPO(String id,ListState state,Calendar receiptDate, double amount, String courierNum, ArrayList<String> expressNums) {
		super(id,state);
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
			if(CommonUtility.Calequals(this.receiptDate, receipt.receiptDate))
				if(this.courierNum.equals(receipt.courierNum))
					if(this.amount==receipt.amount)
//						if(this.expressNums.toString().equals(receipt.expressNums.toString()))
						return true;
		return false;
	}
	
}
