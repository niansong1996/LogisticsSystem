package edu.nju.lms.PO;

import java.util.ArrayList;

public class InitialInforPO {
	private ArrayList<DepartmentPO> departments;
	private ArrayList<PersonnelPO> personnel;
	/**
	 * the list restores the car's plate number
	 */
	private ArrayList<String> cars;
	private ArrayList<WarehousePO> warehouses;
	private ArrayList<AccountPO> accounts;
	
	public InitialInforPO(ArrayList<DepartmentPO> departments, ArrayList<PersonnelPO> personnel, ArrayList<String> cars,
			ArrayList<WarehousePO> warehouses, ArrayList<AccountPO> accounts) {
		super();
		this.departments = departments;
		this.personnel = personnel;
		this.cars = cars;
		this.warehouses = warehouses;
		this.accounts = accounts;
	}

	public ArrayList<DepartmentPO> getDepartments() {
		return departments;
	}

	public void setDepartments(ArrayList<DepartmentPO> departments) {
		this.departments = departments;
	}

	public ArrayList<PersonnelPO> getPersonnel() {
		return personnel;
	}

	public void setPersonnel(ArrayList<PersonnelPO> personnel) {
		this.personnel = personnel;
	}

	public ArrayList<String> getCars() {
		return cars;
	}

	public void setCars(ArrayList<String> cars) {
		this.cars = cars;
	}

	public ArrayList<WarehousePO> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(ArrayList<WarehousePO> warehouses) {
		this.warehouses = warehouses;
	}

	public ArrayList<AccountPO> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<AccountPO> accounts) {
		this.accounts = accounts;
	}
	
	
}
