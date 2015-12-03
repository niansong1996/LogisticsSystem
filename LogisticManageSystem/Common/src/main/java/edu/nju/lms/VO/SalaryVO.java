package edu.nju.lms.VO;

/**
 * payment of salary
 * @author Cui
 * 2015-10-25 00:02:11
 */
public class SalaryVO extends ListVO{
	private String time;
	private double amount;
	private String accountNum;

	public SalaryVO(String id,String time, double amount,String accountNum) {
		super(id);
		this.time = time;
		this.amount = amount;
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
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

}
