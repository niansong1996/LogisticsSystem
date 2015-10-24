package edu.nju.lms.PO;

import edu.nju.lms.data.PersonType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class UserPO {
	private long userName;
	private String password;
	private PersonType power;
	
	public UserPO(long userName, String password, PersonType power) {
		super();
		this.userName = userName;
		this.password = password;
		this.power = power;
	}
	public long getUserName() {
		return userName;
	}
	public void setUserName(long userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PersonType getPower() {
		return power;
	}
	public void setPower(PersonType power) {
		this.power = power;
	}
	
	
}
