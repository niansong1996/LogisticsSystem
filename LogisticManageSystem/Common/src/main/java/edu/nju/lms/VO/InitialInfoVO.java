package edu.nju.lms.VO;

import java.util.ArrayList;

/**
 * show initial information
 * @author Cui
 * 2015-10-24 23:25:16
 */
public class InitialInfoVO {
	
	private String date;
	private ArrayList<String> departments;
	private ArrayList<String> personnel;
	/**
	 * the list restores the car's plate number
	 */
	private ArrayList<String> cars;
	private ArrayList<String> warehouses;
	private ArrayList<String> accounts;
	
	public InitialInfoVO(String date,ArrayList<String> departments, ArrayList<String> personnel, ArrayList<String> cars,
			ArrayList<String> warehouses, ArrayList<String> accounts) {
		super();
		this.date=date;
		this.departments = departments;
		this.personnel = personnel;
		this.cars = cars;
		this.warehouses = warehouses;
		this.accounts = accounts;
	}

	public ArrayList<String> getDepartments() {
		return departments;
	}

	public void setDepartments(ArrayList<String> departments) {
		this.departments = departments;
	}

	public ArrayList<String> getPersonnel() {
		return personnel;
	}

	public void setPersonnel(ArrayList<String> personnel) {
		this.personnel = personnel;
	}

	public ArrayList<String> getCars() {
		return cars;
	}

	public void setCars(ArrayList<String> cars) {
		this.cars = cars;
	}

	public ArrayList<String> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(ArrayList<String> warehouses) {
		this.warehouses = warehouses;
	}

	public ArrayList<String> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<String> accounts) {
		this.accounts = accounts;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
