package edu.nju.lms.VO;

/**
 * show salary startegy
 * @author Cui
 * 2015-10-24 22:44:03
 */
public class SalaryStrategyVO {
	private String type;
	private double basic;
	//我觉得这里应该是确定运一次给多少钱
	private double perTime;
	private double bonus;
	
	public SalaryStrategyVO(String type,  double basic, double perTime, double bonus) {
		super();
		this.type = type;
		this.basic = basic;
		this.perTime = perTime;
		this.bonus = bonus;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
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
