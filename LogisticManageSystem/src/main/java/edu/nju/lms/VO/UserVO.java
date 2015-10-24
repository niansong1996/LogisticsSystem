package edu.nju.lms.VO;

/**
 * show the info of a user
 * @author Cui
 * 2015-10-24 22:59:41
 */
public class UserVO {
	private String userName;
	private String password;
	private String power;
	
	public UserVO(String userName, String password, String power) {
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
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	

}
