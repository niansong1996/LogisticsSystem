package edu.nju.lms.VO;

/**
 * show account info
 * @author Cui
 * 2015-10-24 23:16:19
 */
public class AccountVO {
	private String name;
	private double amount;
	
	public AccountVO(String name, double amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

}
