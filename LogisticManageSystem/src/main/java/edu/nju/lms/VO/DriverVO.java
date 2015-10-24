package edu.nju.lms.VO;

import java.util.Calendar;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class DriverVO {
	private long driverNum;
	private String driverName;
	private Calendar birth;
	private long idNum;
	private long phoneNum;
	//0表示男，1表示女
	private int sex;
	//行驶证期限
	private Calendar drivingLimit;
	public DriverVO(long driverNum, String driverName, Calendar birth, long idNum, long phoneNum, int sex,
			Calendar drivingLimit) {
		super();
		this.driverNum = driverNum;
		this.driverName = driverName;
		this.birth = birth;
		this.idNum = idNum;
		this.phoneNum = phoneNum;
		this.sex = sex;
		this.drivingLimit = drivingLimit;
	}
	public long getDriverNum() {
		return driverNum;
	}
	public void setDriverNum(long driverNum) {
		this.driverNum = driverNum;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Calendar getBirth() {
		return birth;
	}
	public void setBirth(Calendar birth) {
		this.birth = birth;
	}
	public long getIdNum() {
		return idNum;
	}
	public void setIdNum(long idNum) {
		this.idNum = idNum;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Calendar getDrivingLimit() {
		return drivingLimit;
	}
	public void setDrivingLimit(Calendar drivingLimit) {
		this.drivingLimit = drivingLimit;
	}
}
