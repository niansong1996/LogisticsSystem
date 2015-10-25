package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.data.DepartmentType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.DepartmentDataService;

public class DepartmentDataImpl implements DepartmentDataService{

	public ResultMessage addDepartment(DepartmentPO Department) throws RemoteException {
		
		List<DepartmentPO> department=new ArrayList<DepartmentPO>();
		department.add(Department);
		
		return new ResultMessage(true,"");
	}

	public DepartmentPO findDepartment(String id) throws RemoteException {
		
		ArrayList<String> businessNums=new ArrayList<String>();
		businessNums.add("0101010101");
		ArrayList<Double> distance=new ArrayList<Double>();
		distance.add(100.0);
		CityPO city=new CityPO("025","Nanjing",businessNums,distance);
		DepartmentPO department=new DepartmentPO(DepartmentType.BUSINESSHALL,"0250000",city);
		
		if(id.equals("0250000")){
			return department;
		}else{
			return null;
		}
	}

	public ResultMessage deleteDepartment(String id) throws RemoteException {
		
		ArrayList<String> businessNums=new ArrayList<String>();
		businessNums.add("0101010101");
		ArrayList<Double> distance=new ArrayList<Double>();
		distance.add(100.0);
		CityPO city=new CityPO("025","Nanjing",businessNums,distance);
		DepartmentPO department=new DepartmentPO(DepartmentType.BUSINESSHALL,"0250000",city);
		ArrayList<DepartmentPO> po=new ArrayList<DepartmentPO>();
		po.add(department);
		
		if(id.length()!=7){
			return new ResultMessage(false,"Wrong format!");
		}else{
			if(id.equals("0250000")){
				po.remove(0);
				return new ResultMessage(true,"");
			}else{
				return new ResultMessage(false,"no such department!");
			}
		}
	}

	public ResultMessage updateDepartment(DepartmentPO Department) throws RemoteException {
		
		ArrayList<String> businessNums=new ArrayList<String>();
		businessNums.add("0101010101");
		ArrayList<Double> distance=new ArrayList<Double>();
		distance.add(100.0);
		CityPO city=new CityPO("025","Nanjing",businessNums,distance);
		DepartmentPO department=new DepartmentPO(DepartmentType.BUSINESSHALL,"0250000",city);
		ArrayList<DepartmentPO> po=new ArrayList<DepartmentPO>();
		po.add(department);

		if(Department.getDepartmentNum().equals("0250000")){
			po.remove(0);
			po.add(Department);
			return new ResultMessage(true,"");
		}else{
			return new ResultMessage(false,"no such department!");
		}
	}

	public ResultMessage addCity(CityPO City) throws RemoteException {
		
		List<CityPO> city=new ArrayList<CityPO>();
		city.add(City);
		return new ResultMessage(true,"");
	}

	public CityPO findCity(String id) throws RemoteException {
		
		ArrayList<String> businessNums=new ArrayList<String>();
		businessNums.add("0101010101");
		ArrayList<Double> distance=new ArrayList<Double>();
		distance.add(100.0);
		CityPO city=new CityPO("025","Nanjing",businessNums,distance);
		
		if(id.equals("025")){
			return city;
		}else{
			return null;
		}
	}

	public ResultMessage deleteCity(String id) throws RemoteException {
		
		ArrayList<String> businessNums=new ArrayList<String>();
		businessNums.add("0101010101");
		ArrayList<Double> distance=new ArrayList<Double>();
		distance.add(100.0);
		CityPO city=new CityPO("025","Nanjing",businessNums,distance);
		ArrayList<CityPO> po=new ArrayList<CityPO>();
		po.add(city);
		
		if(id.length()!=3){
			return new ResultMessage(false,"Wrong format!");
		}else{
			if(id.equals("025")){
				po.remove(0);
				return new ResultMessage(true,"");
			}else{
				return new ResultMessage(false,"no such city!");
			}
		}
	}

	public ResultMessage updateCity(CityPO City) throws RemoteException {
		
		ArrayList<String> businessNums=new ArrayList<String>();
		businessNums.add("0101010101");
		ArrayList<Double> distance=new ArrayList<Double>();
		distance.add(100.0);
		CityPO city=new CityPO("025","Nanjing",businessNums,distance);
		ArrayList<CityPO> po=new ArrayList<CityPO>();
		po.add(city);

		if(City.getId().equals("025")){
			po.remove(0);
			po.add(City);
			return new ResultMessage(true,"");
		}else{
			return new ResultMessage(false,"no such city!");
		}
	}

}
