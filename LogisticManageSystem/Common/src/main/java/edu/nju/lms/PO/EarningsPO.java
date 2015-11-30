package edu.nju.lms.PO;

import java.util.Calendar;

import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListState;

public class EarningsPO extends ListPO {
	/**
	 * have been modified by sql
	 */
	private static final long serialVersionUID = -2314846105977404899L;
	private double earnings;
	private double payment;
	private double profit;
	private Calendar date;
	private String id;
	
	public EarningsPO(String id,String state,String earnings, String payment, String date) {
		super(id,ListState.valueOf(state));
		this.earnings = Double.parseDouble(earnings);
		this.payment = Double.parseDouble(payment);
		this.profit = this.earnings-this.payment;
		this.date = CommonUtility.String2Cal(date);
	}
	
	public EarningsPO(String id,String state,double earnings, double payment, Calendar date) {
		super(id,ListState.valueOf(state));
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
