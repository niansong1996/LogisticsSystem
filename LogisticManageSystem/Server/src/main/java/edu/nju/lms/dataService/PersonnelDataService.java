package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.data.ResultMessage;

public interface PersonnelDataService {
	
	public ResultMessage addPersonnel(PersonnelPO personnel) throws RemoteException;
	public PersonnelPO findPersonnel(String id) throws RemoteException;
	public ResultMessage deletePersonnel(String id) throws RemoteException;
	public ResultMessage updatePersonnel(PersonnelPO personnel) throws RemoteException;
}
