package edu.nju.lms.PO;
import java.util.Calendar;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class DriverPO {
	private String driverNum;
	private String driverName;
	private Calendar birth;
	/**
	 * identification card number of the driver
	 */
	private String idNum;
	private String phoneNum;
	/**
	 * 0: male ; 1: female
	 */
	private int sex;
	//行驶证期限
	private Calendar drivingLimit;
	public DriverPO(String driverNum, String driverName, Calendar birth, String idNum, String phoneNum, int sex,
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
	public Calendar getBirth() {
		return birth;
	}
	public void setBirth(Calendar birth) {
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
	public Calendar getDrivingLimit() {
		return drivingLimit;
	}
	public void setDrivingLimit(Calendar drivingLimit) {
		this.drivingLimit = drivingLimit;
	}
	
	
}
