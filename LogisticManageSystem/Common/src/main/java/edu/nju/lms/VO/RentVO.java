package edu.nju.lms.VO;

public class RentVO {
	private double amount;
	private int year;
	
	public RentVO(double amount, int year) {
		super();
		this.amount = amount;
		this.year = year;
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
	
	
}
