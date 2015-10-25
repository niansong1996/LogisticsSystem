package edu.nju.lms.VO;

import java.util.ArrayList;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class CityVO {
	private long id;
	private String name;
	//���ж�Ӧ����ת���ı��
	private long cityNum;
	//the business halls' numbers that belongs to the city
	private ArrayList<Long> businessNums;
	
	public CityVO(long id,String name, long cityNum, ArrayList<Long> businessNums) {
		super();
		this.id = id;
		this.name = name;
		this.cityNum = cityNum;
		this.businessNums = businessNums;
	}
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
