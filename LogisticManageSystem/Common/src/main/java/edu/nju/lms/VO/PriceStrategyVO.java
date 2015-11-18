package edu.nju.lms.VO;

/**
 * 
 * show price strategy
 * @author Cui
 * 2015-10-24 22:50:29
 *
 */
public class PriceStrategyVO {
	private double standard;
	private double express;
	private double economic;
	
	public PriceStrategyVO(double standard, double express, double economic) {
		this.standard = standard;
		this.express = express;
		this.economic = economic;
	}
	public double getStandard() {
		return standard;
	}
	public void setStandard(double standard) {
		this.standard = standard;
	}
	public double getExpress() {
		return express;
	}
	public void setExpress(double express) {
		this.express = express;
	}
	public double getEconomic() {
		return economic;
	}
	public void setEconomic(double economic) {
		this.economic = economic;
	}
	

}
