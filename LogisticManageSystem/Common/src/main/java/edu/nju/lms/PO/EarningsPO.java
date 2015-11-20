package edu.nju.lms.PO;

import java.util.Calendar;

public class EarningsPO extends ListPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2314846105977404899L;
	private double earnings;
	private double payment;
	private double profit;
	private Calendar date;
	private String id;
	public EarningsPO(String id,double earnings, double payment, Calendar date) {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	
	
	
}
