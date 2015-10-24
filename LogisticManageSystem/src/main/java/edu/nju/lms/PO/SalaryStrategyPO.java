
public class SalaryStrategyPO {
	private PersonType type;
	private int basic;
	private int perTime;
	private int bonus;
	
	public SalaryStrategyPO(PersonType type, int basic, 
			int pertime,int bonus) {
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
