package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.PersonnelPO;

public interface PersonnelService {
	
	public boolean addPersonnel(PersonnelPO personnel) throws RemoteException;
	public PersonnelPO findPersonnel(long id) throws RemoteException;
	public boolean deletePersonnel(long id) throws RemoteException;
	public Boolean updatePersonnel(PersonnelPO personnel) throws RemoteException;
}
