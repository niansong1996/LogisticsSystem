package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.DepartmentDataService;

public class DepartmentDataImpl implements DepartmentDataService{
	
	private ArrayList<DepartmentPO> departmentList = new ArrayList<DepartmentPO>();
	private ArrayList<CityPO> cityList = new ArrayList<CityPO>(); 
	
	public DepartmentDataImpl(){
		
	}

	public ResultMessage addDepartment(DepartmentPO department) throws RemoteException {
		if(findDepartment(department.getDepartmentNum())==null){
			this.departmentList.add(department);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The department already exists!");
		}
	}

	public DepartmentPO findDepartment(String id) throws RemoteException {
		DepartmentPO result = null;
		Iterator<DepartmentPO> it = departmentList.iterator();
		while(it.hasNext()){
			DepartmentPO next = it.next();
			if(next.getDepartmentNum()==id){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteDepartment(String id) throws RemoteException {
		DepartmentPO department = findDepartment(id);
		if(!(department==null)){
			departmentList.remove(department);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the department!");
		}
	}

	public ResultMessage updateDepartment(DepartmentPO department) throws RemoteException {
		DepartmentPO tempDepartment = findDepartment(department.getDepartmentNum());
		if(tempDepartment!=null){
			departmentList.remove(findDepartment(department.getDepartmentNum()));
			departmentList.add(department);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the department!");
		}
	}

	public ResultMessage addCity(CityPO city) throws RemoteException {
		if((findCity(city.getId())==null)){
			this.cityList.add(city);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The city already exists!");
		}
	}

	public CityPO findCity(String id) throws RemoteException {
		CityPO result = null;
		Iterator<CityPO> it = cityList.iterator();
		while(it.hasNext()){
			CityPO next = it.next();
			if(next.getId()==id){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteCity(String id) throws RemoteException {
		CityPO city = findCity(id);
		if(!(city==null)){
			cityList.remove(city);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the city!");
		}
	}

	public ResultMessage updateCity(CityPO city) throws RemoteException {
		CityPO tempCity = findCity(city.getId());
		if(!(tempCity==null)){
			tempCity = city;
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the city!");
		}
	}
}
