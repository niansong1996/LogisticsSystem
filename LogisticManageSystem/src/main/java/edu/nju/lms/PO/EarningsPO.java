package edu.nju.lms.PO;

import java.util.Calendar;

public class EarningsPO {
	private double earnings;
	private double payment;
	private double profit;
	private Calendar date;
	
	public EarningsPO(double earnings, double payment, Calendar date) {
		super();
		this.earnings = earnings;
		this.payment = payment;
		this.profit = earnings-payment;
		this.date = date;
	}

	public void setEarnings(double earnings) {
		this.earnings = earnings;
		this.profit = earnings-payment;
	}

	public double getEarnings() {
		return earnings;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
		this.profit = earnings-payment;
	}

	public double getProfit() {
		return profit;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
	
	
}
