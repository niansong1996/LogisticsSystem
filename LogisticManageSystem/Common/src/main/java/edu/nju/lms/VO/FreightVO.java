package edu.nju.lms.VO;

/**
 * payment of freight
 * @author Cui
 * 2015-10-24 23:55:57
 */
public class FreightVO {
	private String time;
	private String accountName;
	private double amount;
	private String explain;
	public FreightVO(String time, String accountName, double amount, String explain) {
		this.time = time;
		this.accountName = accountName;
		this.amount = amount;
		this.explain = explain;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	

}
