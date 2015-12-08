package edu.nju.lms.VO;
/**
 *@author tj
 *@date 2015年12月8日
 */
public class WarehouseInfoVO {
	private int checkinNum;
	private int checkoutNum;
	private int totalNum;
	
	public WarehouseInfoVO(int checkinNum, int checkoutNum, int totalNum) {
		super();
		this.checkinNum = checkinNum;
		this.checkoutNum = checkoutNum;
		this.totalNum = totalNum;
	}
	public int getCheckinNum() {
		return checkinNum;
	}
	public void setCheckinNum(int checkinNum) {
		this.checkinNum = checkinNum;
	}
	public int getCheckoutNum() {
		return checkoutNum;
	}
	public void setCheckoutNum(int checkoutNum) {
		this.checkoutNum = checkoutNum;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
	
}
