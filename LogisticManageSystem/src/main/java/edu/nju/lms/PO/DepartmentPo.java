package edu.nju.lms.PO;

import edu.nju.lms.data.DepartmentType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class DepartmentPo {
	private DepartmentType type;
	private long departmentNum;
	private CityPO location;
	
	public DepartmentPo(DepartmentType type, long departmentNum, CityPO location) {
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
	public long getDepartmentNum() {
		return departmentNum;
	}
	public void setDepartmentNum(long departmentNum) {
		this.departmentNum = departmentNum;
	}
	public CityPO getLocation() {
		return location;
	}
	public void setLocation(CityPO location) {
		this.location = location;
	}
	
	
}
