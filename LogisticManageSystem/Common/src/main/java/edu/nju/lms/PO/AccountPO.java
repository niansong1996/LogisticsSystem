package edu.nju.lms.PO;

import java.io.Serializable;

public class AccountPO implements Serializable{
	/**
	 * have been modified by sql
	 */
	private static final long serialVersionUID = -2920275357062710781L;
	private String name;//unique identifier
	private double amount;
	public AccountPO(String name, String amount) {
		this.name = name;
		this.amount = Double.parseDouble(amount);
	}
	public AccountPO(String name, double amount) {
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
	@Override
	public boolean equals(Object object){
		if(this.name.equals(((AccountPO)object).getName())&&
				this.amount==((AccountPO)object).getAmount())
				{
			return true;
		}
		else{
			return false;
		}
	}
}
