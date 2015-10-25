package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.data.ResultMessage;

public interface DepartmentService {
	
	public ResultMessage addDepartment(DepartmentPO Department) throws RemoteException;
	public DepartmentPO findDepartment(String id) throws RemoteException;
	public ResultMessage deleteDepartment(String id) throws RemoteException;
	public ResultMessage updateDepartment(DepartmentPO Department) throws RemoteException;
	public ResultMessage addCity(CityPO City) throws RemoteException;
	public CityPO findCity(String id) throws RemoteException;
	public ResultMessage deleteCity(String id) throws RemoteException;
	public ResultMessage updateCity(CityPO City) throws RemoteException;
}