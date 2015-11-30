package edu.nju.lms.PO;

import java.io.Serializable;

import edu.nju.lms.data.PersonType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class UserPO implements Serializable{
	/**
	 * have been modified for sql
	 */
	private static final long serialVersionUID = 7803240290729659545L;
	private String userName;
	private String password;
	private PersonType power;
	
	public UserPO(String userName, String password, String power) {
		super();
		this.userName = userName;
		this.password = password;
		this.power = PersonType.valueOf(power);
	}
	public UserPO(String userName, String password, PersonType power) {
		super();
		this.userName = userName;
		this.password = password;
		this.power = power;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
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
	@Override
	public boolean equals(Object object){
		//TODO not consider the comparation of PersonType
		if(this.userName.equals(((UserPO)object).getUserName())&&
				this.password.equals(((UserPO)object).getPassword())
				){
			return true;
		}
		else{
			return false;
		}
			
	}
	
}
