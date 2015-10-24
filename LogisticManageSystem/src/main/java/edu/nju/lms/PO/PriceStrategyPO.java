
public class PriceStrategyPO {
	private double standard;
	private double express;
	private double economic;
	private final double rate1 = 18;
	private final double rate2 = 23;
	private final double rate3 = 25;
	public PriceStrategyPO(double sta) {
		standard = sta;
		economic = rate1/rate2 * sta;
		express = rate3/rate2 * sta;
	}
	public double getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public double getExpress() {
		return express;
	}
	public void setExpress(int express) {
		this.express = express;
	}
	public double getEconomic() {
		return economic;
	}
	public void setEconomic(int economic) {
		this.economic = economic;
	}
	

}
