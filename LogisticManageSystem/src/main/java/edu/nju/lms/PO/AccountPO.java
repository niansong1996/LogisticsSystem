
public class AccountPO {
	private String name;
	private double amount;
	public AccountPO(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void addAmount(int add) {
		assert add>=0;
		amount += add;
	}
	public void minusAmount(int minus) {
		assert minus>=0;
		amount -= minus;
	}
}
