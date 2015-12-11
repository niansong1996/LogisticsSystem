package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.DepartmentDataService;
/**
 * 
 * @author nians
 *
 */
public class DepartmentDataImpl extends UnicastRemoteObject implements DepartmentDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8887872359871144508L;
	
	public DepartmentDataImpl() throws RemoteException{
		
	}

	public ResultMessage addDepartment(DepartmentPO department) throws RemoteException {
		if(findDepartment(department.getDepartmentNum())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(department, department.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The department already exists!");
		}
	}

	public DepartmentPO findDepartment(String id) throws RemoteException {
		DepartmentPO department = null;
		ResultSet result = JDBC.ExecuteQuery("select * from departmentpo where departmentNum = \""+id+"\";");
		try{
		if(!result.wasNull())
			department = (DepartmentPO)POGenerator.generateObject(result, DepartmentPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return department;	}

	public ResultMessage deleteDepartment(String id) throws RemoteException {
		DepartmentPO department = findDepartment(id);
		if(!(department==null)){
			JDBC.ExecuteData("delete from departmentpo where departmentNum = \""+id+"\";");
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the department!");
		}
	}

	public ResultMessage updateDepartment(DepartmentPO department) throws RemoteException {
		DepartmentPO tempDepartment = findDepartment(department.getDepartmentNum());
		if(!(tempDepartment==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(department, department.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the department!");
		}
	}

	public ResultMessage addCity(CityPO city) throws RemoteException {
		if(findCity(city.getId())==null){ 
			JDBC.ExecuteData(POGenerator.generateInsertOp(city, city.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The city already exists!");
		}

	}

	public CityPO findCity(String id) throws RemoteException {
		CityPO city = null;
		ResultSet result = JDBC.ExecuteQuery("select * from citypo where id = \""+id+"\";");
		try{
		if(!result.wasNull())
			city = (CityPO)POGenerator.generateObject(result, CityPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return city;
	}

	public ResultMessage deleteCity(String id) throws RemoteException {
		CityPO city = findCity(id);
		if(!(city==null)){
			JDBC.ExecuteData("delete from citypo where id = \""+id+"\";");
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the city!");
		}
	}

	public ResultMessage updateCity(CityPO city) throws RemoteException {
		CityPO tempCity = findCity(city.getId());
		if(!(tempCity==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(city, city.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the city!");
		}
	}

	public ArrayList<CityPO> showAllCities() throws RemoteException {
		ArrayList<CityPO> cityList = new ArrayList<CityPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from citypo;" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(cityList,result, CityPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return cityList;
	}

	public ArrayList<DepartmentPO> showAllDepartments() throws RemoteException {
		ArrayList<DepartmentPO> DepartmentList = new ArrayList<DepartmentPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from departmentpo;" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(DepartmentList,result, DepartmentPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return DepartmentList;
	}
}
