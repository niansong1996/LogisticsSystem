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
	private String location;
	
	public DepartmentPO(String departmentNum,String type,String location) {
		super();
		this.type = DepartmentType.valueOf(type);
		this.departmentNum = departmentNum;
		this.location = location;
	}
	
	public DepartmentPO(DepartmentType type, String departmentNum, String location) {
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public boolean equals(Object object){
		DepartmentPO department = (DepartmentPO)object;
		if(this.departmentNum.equals(department.departmentNum))
			if(this.location.equals(department.location))
				if(this.type==department.type)
					return true;
		return false;
	}
	
}
