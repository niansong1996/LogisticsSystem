package edu.nju.lms.PO;

import java.io.Serializable;
import java.util.ArrayList;

public class InitialInforPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8979310777332153793L;
	private ArrayList<String> departments;
	private ArrayList<String> personnel;
	/**
	 * the list restores the car's plate number
	 */
	private ArrayList<String> cars;
	private ArrayList<String> warehouses;
	private ArrayList<String> accounts;
	
	public InitialInforPO(ArrayList<String> departments, ArrayList<String> personnel, ArrayList<String> cars,
			ArrayList<String> warehouses, ArrayList<String> accounts) {
		super();
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
	
	
}
