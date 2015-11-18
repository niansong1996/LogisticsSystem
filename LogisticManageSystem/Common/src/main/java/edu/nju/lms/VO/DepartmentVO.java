package edu.nju.lms.VO;

import edu.nju.lms.data.DepartmentType;

/**
 * show department info
 * @author Cui
 * 2015-10-24 23:09:35
 */
public class DepartmentVO {
	
	/**
	 * type: business or transcicenter
	 */
	private DepartmentType type;
	/**
	 * id
	 */
	private String departmentNum;
	/**
	 * id of city
	 */
	private String location;
	
	public DepartmentVO(DepartmentType type, String departmentNum, String location) {
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
