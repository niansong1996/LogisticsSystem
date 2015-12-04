package edu.nju.lms.VO;

import edu.nju.lms.data.PaymentType;

public class RentVO extends PaymentVO{

	private int year;

	
	public RentVO(String id,String payTime,String accountNum,double amount, int year) {
		super(id,PaymentType.RENT,payTime,accountNum,amount);
		this.year=year;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

}
