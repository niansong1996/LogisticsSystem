package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;

public interface DepartmentService {
	
	public boolean addDepartment(DepartmentPO Department) throws RemoteException;
	public DepartmentPO findDepartment(long id) throws RemoteException;
	public boolean deleteDepartment(long id) throws RemoteException;
	public boolean updateDepartment(DepartmentPO Department) throws RemoteException;
	public boolean addCity(CityPO City) throws RemoteException;
	public CityPO findCity(long id) throws RemoteException;
	public boolean deleteCity(long id) throws RemoteException;
	public boolean updateCity(CityPO City) throws RemoteException;
}
