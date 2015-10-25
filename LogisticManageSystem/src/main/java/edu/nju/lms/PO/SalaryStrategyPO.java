package edu.nju.lms.PO;

import edu.nju.lms.data.PersonType;

public class SalaryStrategyPO {
	private PersonType type;
	private double basic;
	private int perTime;
	private double bonus;
	
	public SalaryStrategyPO(PersonType type, double basic, 
			int pertime,double bonus) {
		this.type = type;
		this.basic = basic;
		this.perTime = pertime;
		this.bonus = bonus;
	}

	public PersonType getType() {
		return type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public int getPerTime() {
		return perTime;
	}

	public void setPerTime(int perTime) {
		this.perTime = perTime;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	
}
