package edu.nju.lms.VO;

import java.util.ArrayList;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class CityVO {
	private String id;
	private String name;
	//the business halls' numbers that belongs to the city
	private ArrayList<String> businessNums;
	/**
	 * restore the distance between other cities
	 */
	private ArrayList<Double> distance;
    
	public CityVO(String id, String name,
			ArrayList<String> businessNums, ArrayList<Double> distance) {
		this.id = id;
		this.name = name;
		this.businessNums = businessNums;
		this.distance = distance;
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

	public ArrayList<String> getBusinessNums() {
		return businessNums;
	}

	public void setBusinessNums(ArrayList<String> businessNums) {
		this.businessNums = businessNums;
	}

	public ArrayList<Double> getDistance() {
		return distance;
	}

	public void setDistance(ArrayList<Double> distance) {
		this.distance = distance;
	}
	
}
