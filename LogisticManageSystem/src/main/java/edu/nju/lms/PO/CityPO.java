package po;

import java.util.ArrayList;

/**
 *@author tj
 *@date 2015年10月23日
 */
public class CityPO {
	private String name;
	//城市对应的中转中心编号
	private long cityNum;
	//the business halls' numbers that belongs to the city
	private ArrayList<Long> businessNums;
	
	public CityPO(String name, long cityNum, ArrayList<Long> businessNums) {
		super();
		this.name = name;
		this.cityNum = cityNum;
		this.businessNums = businessNums;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCityNum() {
		return cityNum;
	}

	public void setCityNum(long cityNum) {
		this.cityNum = cityNum;
	}

	public ArrayList<Long> getBusinessNums() {
		return businessNums;
	}

	public void setBusinessNums(ArrayList<Long> businessNums) {
		this.businessNums = businessNums;
	}
	
	
}
