package edu.nju.lms.PO;

import java.util.ArrayList;

/**
 *@author tj
 *@date 2015��10��23��
 */
public class CityPO {
	private String id;
	private String name;
	/**
	 * restore the distance between other cities
	 */
	private ArrayList<Double> distance;
	/**
	 * the business halls' numbers that belongs to the city
	 */
	private ArrayList<String> businessNums;
	
	public CityPO(String id,String name, ArrayList<String> businessNums,ArrayList<Double> distance) {
		super();
		this.id = id;
		this.name = name;
		this.distance = distance;
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
