package edu.nju.lms.VO;

/**
 * show account info
 * @author Cui
 * 2015-10-24 23:16:19
 */
public class AccountVO {
	private String id;
	private double amount;
	
	public AccountVO(String id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

}
