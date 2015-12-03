package edu.nju.lms.VO;

public class RentVO extends ListVO{
	private double amount;
	private int year;
	private String accountNum;
	
	public RentVO(String id,double amount, int year,String accountNum) {
		super(id);
		this.amount = amount;
		this.year = year;
		this.accountNum=accountNum;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
		
}
