package edu.nju.lms.PO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *@author tj
 *@date 2015��10��23��
 */
public class CityPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5052194559400755176L;
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

	public CityPO(String id,String name, String businessNums,String distance) {
		this.distance = new ArrayList<Double>();
		this.businessNums = new ArrayList<String>();
		this.id = id;
		this.name = name;
		String distanceTmp = distance.replace("[", "").replace("]", "");
		String businessNumsTmp = businessNums.replace("[", "").replace("]", "");
		if(!distanceTmp.equals("")){
			String distanceTmpArray[] = distanceTmp.split(", ");
			for(String tmp : distanceTmpArray) this.distance.add(Double.parseDouble(tmp));
		}
		if(!businessNumsTmp.equals("")){
		String businessNumsTmpArray[] = businessNumsTmp.split(", ");
		for(String tmp : businessNumsTmpArray) this.businessNums.add(tmp);
		}
	}

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
