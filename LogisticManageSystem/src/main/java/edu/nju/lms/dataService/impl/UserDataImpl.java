package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;

import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.UserDataService;

public class UserDataImpl implements UserDataService{

	public ResultMessage addUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		
		return new ResultMessage(true,null);
	}

	public UserPO findUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return new UserPO("GaoLu", "123456", PersonType.COURIER);
	}

	public ResultMessage deleteUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ResultMessage updateUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

}
