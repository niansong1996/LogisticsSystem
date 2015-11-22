package edu.nju.lms.VO;

import edu.nju.lms.data.PersonType;

/**
 * basic info of a person
 * @author Cui
 * 2015-10-24 23:03:41
 */
public class PersonnelVO {
	private String id;
	private String name;
	private String department;
	private PersonType duty;
	private double salary;
	private double perTime;
	private double bonus;
	public PersonnelVO(String id,String name, String departmentNum, PersonType duty, 
			double salary, double perTime, double bonus) {
		this.id = id;
		this.name = name;
		this.department = departmentNum;
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
		return department;
	}
	public void setDepartmentNum(String departmentNum) {
		this.department = departmentNum;
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
	
	@Override
	public boolean equals(Object o) {
		if(! (o instanceof AccountVO)) {
			return false;
		}
		PersonnelVO person = (PersonnelVO) o;
		if(!(id.equals(person.id)&&name.equals(person.name)&&department.equals(department)
				&&duty.equals(person.duty)&&Math.abs(salary-person.salary)<=0.01&&
				Math.abs(perTime-person.perTime)<=0.01&&Math.abs(bonus-person.bonus)<=0.01)){
			return false;
		}
		return true;
	}
	

}
