package edu.nju.lms.VO;

/**
 * show initial information
 * @author Cui
 * 2015-10-24 23:25:16
 */
public class InitialInfoVO {
	
	private String[] departments;
	private String[] personnel;
	private String[] cars;
	private String[] warehouses;
	private String[] accounts;
	public InitialInfoVO(String[] departments, String[] personnel, String[] cars, String[] warehouses,
			String[] accounts) {
		super();
		this.departments = departments;
		this.personnel = personnel;
		this.cars = cars;
		this.warehouses = warehouses;
		this.accounts = accounts;
	}
	public String[] getDepartments() {
		return departments;
	}
	public void setDepartments(String[] departments) {
		this.departments = departments;
	}
	public String[] getPersonnel() {
		return personnel;
	}
	public void setPersonnel(String[] personnel) {
		this.personnel = personnel;
	}
	public String[] getCars() {
		return cars;
	}
	public void setCars(String[] cars) {
		this.cars = cars;
	}
	public String[] getWarehouses() {
		return warehouses;
	}
	public void setWarehouses(String[] warehouses) {
		this.warehouses = warehouses;
	}
	public String[] getAccounts() {
		return accounts;
	}
	public void setAccounts(String[] accounts) {
		this.accounts = accounts;
	}
	
	

}
