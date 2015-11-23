package edu.nju.lms.PO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
	public PaymentPO(String id,String paymentType, String payTime, String account,
			String amount) {
		super(id);
		this.paymentType = PaymentType.valueOf(paymentType);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.payTime = Calendar.getInstance();
		try {
			this.payTime.setTime(sdf.parse(payTime));
		} catch (ParseException e) {System.out.println("parse failed!!!");}
		this.account = account;
		this.amount = Double.parseDouble(amount);
	}
	
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
	
	@Override
	public boolean equals(Object object){
		PaymentPO payment = (PaymentPO)object;
		if(this.paymentType==payment.paymentType)
			if(this.payTime.getTime().getYear()==payment.payTime.getTime().getYear())
				if(this.payTime.getTime().getMonth()==payment.payTime.getTime().getMonth())
					if(this.payTime.getTime().getDay()==payment.payTime.getTime().getDay())
				if(this.account.equals(payment.account))
					if(this.amount==payment.amount)
						return true;
		return false;
	}
	
}
