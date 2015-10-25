package edu.nju.lms.VO;

import java.util.ArrayList;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class CityVO {
	private String id;
	private String name;
	//���ж�Ӧ����ת���ı��
	private String cityNum;
	//the business halls' numbers that belongs to the city
	private ArrayList<String> businessNums;
	
	public CityVO(String id,String name, String cityNum, ArrayList<String> businessNums) {
		this.id = id;
		this.name = name;
		this.cityNum = cityNum;
		this.businessNums = businessNums;
	}
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public ArrayList<String> getBusinessNums() {
		return businessNums;
	}

	public void setBusinessNums(ArrayList<String> businessNums) {
		this.businessNums = businessNums;
	}
	
}
