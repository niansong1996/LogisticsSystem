package edu.nju.lms.PO;

import java.io.Serializable;

import edu.nju.lms.data.DepartmentType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class DepartmentPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6377542916069618722L;
	private String departmentNum;
	private DepartmentType type;
	private CityPO location;
	
	public DepartmentPO(DepartmentType type, String departmentNum, CityPO location) {
		super();
		this.type = type;
		this.departmentNum = departmentNum;
		this.location = location;
	}
	public DepartmentType getType() {
		return type;
	}
	public void setType(DepartmentType type) {
		this.type = type;
	}
	public String getDepartmentNum() {
		return departmentNum;
	}
	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}
	public CityPO getLocation() {
		return location;
	}
	public void setLocation(CityPO location) {
		this.location = location;
	}
	
	
}
