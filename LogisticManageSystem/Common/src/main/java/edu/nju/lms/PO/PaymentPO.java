package edu.nju.lms.PO;

import java.util.Calendar;

import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.PaymentType;

public class PaymentPO extends ListPO {
	/**
	 * have been modified for sql
	 */
	private static final long serialVersionUID = 2852405640506195901L;
	private PaymentType paymentType;
	private Calendar payTime;
	private String account;
	private double amount;
	
	public PaymentPO(String id,String state,String paymentType, String payTime, String account,
			String amount) {
		super(id,ListState.valueOf(state));
		this.paymentType = PaymentType.valueOf(paymentType);
		this.payTime= CommonUtility.String2Cal(payTime);
		this.account = account;
		this.amount = Double.parseDouble(amount);
	}
	
	public PaymentPO(String id,ListState state,PaymentType paymentType, Calendar payTime, String account,
			double amount) {
		super(id,state);
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
			if(CommonUtility.Calequals(this.payTime, payment.payTime))
				if(this.account.equals(payment.account))
					if(this.amount==payment.amount)
						return true;
		return false;
	}
	
}
