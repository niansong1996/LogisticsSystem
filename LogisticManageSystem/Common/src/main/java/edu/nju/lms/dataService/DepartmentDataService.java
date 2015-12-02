package edu.nju.lms.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.data.ResultMessage;

public interface DepartmentDataService extends Remote{
	
	public ResultMessage addDepartment(DepartmentPO Department) throws RemoteException;
	public DepartmentPO findDepartment(String id) throws RemoteException;
	public ResultMessage deleteDepartment(String id) throws RemoteException;
	public ResultMessage updateDepartment(DepartmentPO Department) throws RemoteException;
	public ArrayList<DepartmentPO> showAllDepartments() throws RemoteException;
	public ResultMessage addCity(CityPO City) throws RemoteException;
	public CityPO findCity(String id) throws RemoteException;
	public ResultMessage deleteCity(String id) throws RemoteException;
	public ResultMessage updateCity(CityPO City) throws RemoteException;
	public ArrayList<CityPO> showAllCities() throws RemoteException;;
}
