package edu.nju.lms.VO;

import edu.nju.lms.data.PaymentType;

public class PaymentVO extends ListVO{
	private PaymentType paymentType;
	private String account;
	private double amount;
	private String payTime;
	
	public PaymentVO(String id,PaymentType paymentType,String payTime,String account,double amount) {
		super(id);
		this.paymentType = paymentType;
		this.payTime=payTime;
		this.account = account;
		this.amount = amount;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
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

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	
}
