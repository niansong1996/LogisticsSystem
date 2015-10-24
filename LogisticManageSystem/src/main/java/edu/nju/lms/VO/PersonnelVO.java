package edu.nju.lms.VO;

/**
 * basic info of a person
 * @author Cui
 * 2015-10-24 23:03:41
 */
public class PersonnelVO {
	
	private String name;
	private String department;
	private String duty;
	private double salary;
	private double perTime;
	private double bonus;
	public PersonnelVO(String name, String departmentNum, String duty, 
			double salary, double perTime, double bonus) {
		this.name = name;
		this.department = departmentNum;
		this.duty = duty;
		this.salary = salary;
		this.perTime = perTime;
		this.bonus = bonus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentNum() {
		return department;
	}
	public void setDepartmentNum(String departmentNum) {
		this.department = departmentNum;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getPerTime() {
		return perTime;
	}
	public void setPerTime(double perTime) {
		this.perTime = perTime;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	

}
