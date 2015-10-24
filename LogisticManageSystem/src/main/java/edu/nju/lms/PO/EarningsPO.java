package edu.nju.lms.PO;

import java.util.Calendar;

public class EarningsPO extends ListPO{
	private double earnings;
	private double payment;
	private double profit;
	private Calendar date;
	private long id;
	public EarningsPO(long id,double earnings, double payment, Calendar date) {
		super(id);
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	
	
	
}
