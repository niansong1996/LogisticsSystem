package edu.nju.lms.VO;

/**
 * show salary startegy
 * @author Cui
 * 2015-10-24 22:44:03
 */
public class SalaryStrategyVO {
	private String type;
	private int basic;
	private int perTime;
	private int bonus;
	
	public SalaryStrategyVO(String type,  int basic, int perTime, int bonus) {
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
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	public int getPerTime() {
		return perTime;
	}
	public void setPerTime(int perTime) {
		this.perTime = perTime;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}
