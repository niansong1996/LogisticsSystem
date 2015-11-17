package edu.nju.lms.VO;

import edu.nju.lms.data.PersonType;

/**
 * show the info of a user
 * @author Cui
 * 2015-10-24 22:59:41
 */
public class UserVO {
	private String userName;
	private String password;
	private PersonType power;
	
	public UserVO(String userName, String password, PersonType power) {
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
		UserVO user = (UserVO) o;
		if(!(userName.equals(user.userName)&&password.equals(user.password)&&
				power==user.power)){
			return false;
		}
		return true;
	}

}
