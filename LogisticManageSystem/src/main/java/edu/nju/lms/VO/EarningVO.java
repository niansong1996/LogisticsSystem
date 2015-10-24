package edu.nju.lms.VO;
/**
 * show earning
 * @author Cui
 * 2015-10-24 23:44:45
 */
public class EarningVO {

	private double earnings;
	private double payment;
	private double profit;
	private String date;
	private long id;
	public EarningVO(double earnings, double payment,
			double profit, String date, long id) {
		this.earnings = earnings;
		this.payment = payment;
		this.profit = profit;
		this.date = date;
		this.id = id;
	}
	public double getEarnings() {
		return earnings;
	}
	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
