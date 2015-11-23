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
	
	@Override
	public boolean equals(Object o) {
		if(! (o instanceof AccountVO)) {
			return false;
		}
		AccountVO account = (AccountVO) o;
		if(!(id.equals(account.id)&&Math.abs(amount-account.amount)<=0.01)){
			return false;
		}
		return true;
	}
	
}
