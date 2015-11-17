package edu.nju.lms.PO;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.data.PersonType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class UserPO {
	private String userName;
	private String password;
	private PersonType power;
	
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
	public boolean equals(Object o) {
		if(! (o instanceof AccountVO)) {
			return false;
		}
		UserPO user = (UserPO) o;
		if(!(userName.equals(user.userName)&&password.equals(user.password)&&power==user.power)){
			return false;
		}
		return true;
	}
	
}
