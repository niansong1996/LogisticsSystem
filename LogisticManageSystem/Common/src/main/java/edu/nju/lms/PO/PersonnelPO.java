package edu.nju.lms.PO;

import java.io.Serializable;

import edu.nju.lms.data.PersonType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class PersonnelPO implements Serializable{

	private static final long serialVersionUID = 2931845580562512886L;
	private String id;
	private String name;
	private String departmentNum;
	private PersonType duty;
	private double salary;
	private double perTime;
	private double bonus;
	
	public PersonnelPO(String id,String name, String departmentNum, PersonType duty, 
			double salary, double perTime, double bonus) {
		this.id = id;
		this.name = name;
		this.departmentNum = departmentNum;
		this.duty = duty;
		this.salary = salary;
		this.perTime = perTime;
		this.bonus = bonus;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
