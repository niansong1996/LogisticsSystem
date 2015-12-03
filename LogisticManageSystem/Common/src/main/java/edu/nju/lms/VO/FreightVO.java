package edu.nju.lms.VO;

/**
 * payment of freight
 * @author Cui
 * 2015-10-24 23:55:57
 */
public class FreightVO extends ListVO{
	private String time;
	private double amount;
	private String accountNum;
	private String explain;
	public FreightVO(String id,String time, double amount, String explain,String accountNum) {
		super(id);
		this.time = time;
		this.amount = amount;
		this.explain = explain;
		this.accountNum=accountNum;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

}
