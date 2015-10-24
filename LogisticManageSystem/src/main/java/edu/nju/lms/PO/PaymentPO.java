package edu.nju.lms.PO;

import java.util.Calendar;

import edu.nju.lms.data.PaymentType;

public class PaymentPO extends ListPO {
	private PaymentType paymentType;
	private Calendar payTime;
	private AccountPO account;
	
	public PaymentPO(long id,PaymentType paymentType, Calendar payTime, AccountPO account) {
		super(id);
		this.paymentType = paymentType;
		this.payTime = payTime;
		this.account = account;
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

	public AccountPO getAccount() {
		return account;
	}

	public void setAccount(AccountPO account) {
		this.account = account;
	}
	
	
}
