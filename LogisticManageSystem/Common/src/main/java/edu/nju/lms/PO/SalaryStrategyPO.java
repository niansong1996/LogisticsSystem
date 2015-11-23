package edu.nju.lms.PO;

import java.io.Serializable;

import edu.nju.lms.data.PersonType;

public class SalaryStrategyPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3617529261196612698L;
	private PersonType type;
	private double basic;
	private double perTime;
	private double bonus;
	
	public SalaryStrategyPO(PersonType type, double basic, 
			double pertime,double bonus) {
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
