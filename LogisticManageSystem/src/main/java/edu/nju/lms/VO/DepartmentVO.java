package edu.nju.lms.VO;

/**
 * show department info
 * @author Cui
 * 2015-10-24 23:09:35
 */
public class DepartmentVO {
	
	/**
	 * type: business or transcicenter
	 */
	private String type;
	/**
	 * id
	 */
	private String departmentNum;
	/**
	 * name of city
	 */
	private String location;
	
	public DepartmentVO(String type, String departmentNum, String location) {
		this.type = type;
		this.departmentNum = departmentNum;
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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
