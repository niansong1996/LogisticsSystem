package edu.nju.lms.PO;

import java.util.Calendar;

import edu.nju.lms.data.CommonUtility;

public class EarningsPO{
	/**
	 * have been modified by sql
	 */
	private static final long serialVersionUID = -2314846105977404899L;
	private double earnings;
	private double payment;
	private double profit;
	private Calendar date;
	
	public EarningsPO(String earnings, String payment,String profit, String date) {
		this.earnings = Double.parseDouble(earnings);
		this.payment = Double.parseDouble(payment);
		this.profit = this.earnings-this.payment;
		this.date = CommonUtility.String2Cal(date);
	}
	
	public EarningsPO(double earnings, double payment,double profit, Calendar date) {
		this.earnings = earnings;
		this.payment = payment;
		this.profit = profit;
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

	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	
	
	
}
