package edu.nju.lms.VO;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class DriverVO {
	//司机编号
	private String driverNum;
	private String driverName;
	private String birth;
	private String idNum;
	private String phoneNum;
	//0表示男，1表示女
	private int sex;
	//行驶证期限
	private String drivingLimit;
	public DriverVO(String driverNum, String driverName, String birth, String idNum, String phoneNum, int sex,
			String drivingLimit) {
		super();
		this.driverNum = driverNum;
		this.driverName = driverName;
		this.birth = birth;
		this.idNum = idNum;
		this.phoneNum = phoneNum;
		this.sex = sex;
		this.drivingLimit = drivingLimit;
	}
	public String getDriverNum() {
		return driverNum;
	}
	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getDrivingLimit() {
		return drivingLimit;
	}
	public void setDrivingLimit(String drivingLimit) {
		this.drivingLimit = drivingLimit;
	}
}
