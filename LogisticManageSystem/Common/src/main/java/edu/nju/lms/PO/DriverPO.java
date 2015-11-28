package edu.nju.lms.PO;
import java.io.Serializable;
import java.util.Calendar;

import edu.nju.lms.data.CommonUtility;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class DriverPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1501603914228742144L;
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
	private String businesshallNum;
	
	public DriverPO(String driverNum, String driverName, String birth, String idNum, String phoneNum, String sex,
			String drivingLimit,String businesshallNum) {
		super();
		this.driverNum = driverNum;
		this.driverName = driverName;
		this.birth = CommonUtility.String2Cal(birth);
		this.idNum = idNum;
		this.phoneNum = phoneNum;
		this.sex = Integer.parseInt(sex);
		this.drivingLimit = CommonUtility.String2Cal(drivingLimit);
		this.businesshallNum=businesshallNum;
	}
	
	public DriverPO(String driverNum, String driverName, Calendar birth, String idNum, String phoneNum, int sex,
			Calendar drivingLimit,String businesshallNum) {
		super();
		this.driverNum = driverNum;
		this.driverName = driverName;
		this.birth = birth;
		this.idNum = idNum;
		this.phoneNum = phoneNum;
		this.sex = sex;
		this.drivingLimit = drivingLimit;
		this.businesshallNum=businesshallNum;
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
	public String getBusinesshallNum() {
		return businesshallNum;
	}
	public void setBusinesshallNum(String businesshallNum) {
		this.businesshallNum = businesshallNum;
	}
	@Override
	public boolean equals(Object object){
		DriverPO driver = (DriverPO)object;
		if(this.businesshallNum.equals(driver.businesshallNum))
			if(CommonUtility.Calequals(this.birth, driver.birth))
				if(this.driverName.equals(driver.driverName))
					if(this.driverNum.equals(driver.driverNum))
						if(CommonUtility.Calequals(this.drivingLimit, driver.drivingLimit))
							if(this.idNum.equals(driver.idNum))
								if(this.phoneNum.equals(driver.phoneNum))
									if(this.sex==driver.sex)
										return true;
		return false;
	}
	
}
