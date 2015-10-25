package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;

import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.PersonnelDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class PersonnelDataImpl implements PersonnelDataService{

	public ResultMessage addPersonnel(PersonnelPO personnel) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public PersonnelPO findPersonnel(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return new PersonnelPO("du","000000000",PersonType.ADMINISTRATOR,63021);
	}

	public ResultMessage deletePersonnel(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ResultMessage updatePersonnel(PersonnelPO personnel) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

}
