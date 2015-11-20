package edu.nju.lms.PO;

import java.io.Serializable;

import edu.nju.lms.data.PersonType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class PersonnelPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2931845580562512886L;
	private String name;
	private String departmentNum;
	private PersonType duty;
	private double salary;
	
	public PersonnelPO(String name, String departmentNum, PersonType duty, double salary) {
		super();
		this.name = name;
		this.departmentNum = departmentNum;
		this.duty = duty;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentNum() {
		return departmentNum;
	}

	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}

	public PersonType getDuty() {
		return duty;
	}

	public void setDuty(PersonType duty) {
		this.duty = duty;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
