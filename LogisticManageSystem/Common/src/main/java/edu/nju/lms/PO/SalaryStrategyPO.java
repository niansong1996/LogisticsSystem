package edu.nju.lms.PO;

import java.io.Serializable;

import edu.nju.lms.data.PersonType;

public class SalaryStrategyPO implements Serializable{
	/**
	 * have been modified for sql
	 */
	private static final long serialVersionUID = 3617529261196612698L;
	private PersonType type;
	private double basic;
	private double perTime;
	private double bonus;
	
	public SalaryStrategyPO(String type, String basic, 
			String pertime,String bonus) {
		this.type = PersonType.valueOf(type);
		this.basic = Double.parseDouble(basic);
		this.perTime = Double.parseDouble(pertime);
		this.bonus = Double.parseDouble(bonus);
	}
	
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
	
	@Override
	public boolean equals(Object object){
		SalaryStrategyPO salaryStrategy = (SalaryStrategyPO)object;
		if(salaryStrategy.type==this.type)
			if(salaryStrategy.basic==this.basic)
				if(salaryStrategy.perTime==this.perTime)
					if(salaryStrategy.bonus==this.bonus)
						return true;
		return false;
	}
	
}
