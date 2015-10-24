package edu.nju.lms.PO;
/**
 *@author tj
 *@date 2015年10月24日
 */
public class PersonnelPO {
	private String name;
	private Long departmentNum;
	private PersonnelPO duty;
	private double salary;
	
	public PersonnelPO(String name, Long departmentNum, PersonnelPO duty, double salary) {
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

	public Long getDepartmentNum() {
		return departmentNum;
	}

	public void setDepartmentNum(Long departmentNum) {
		this.departmentNum = departmentNum;
	}

	public PersonnelPO getDuty() {
		return duty;
	}

	public void setDuty(PersonnelPO duty) {
		this.duty = duty;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
