package edu.nju.lms.PO;

import java.util.Calendar;

import edu.nju.lms.data.PaymentType;

public class PaymentPO extends ListPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2852405640506195901L;
	private PaymentType paymentType;
	private Calendar payTime;
	private String account;
	private double amount;
	public PaymentPO(String id,PaymentType paymentType, Calendar payTime, String account,
			double amount) {
		super(id);
		this.paymentType = paymentType;
		this.payTime = payTime;
		this.account = account;
		this.amount = amount;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Calendar getPayTime() {
		return payTime;
	}

	public void setPayTime(Calendar payTime) {
		this.payTime = payTime;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
