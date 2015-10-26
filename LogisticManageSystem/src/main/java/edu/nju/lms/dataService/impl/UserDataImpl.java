package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.UserDataService;

public class UserDataImpl implements UserDataService{
	ArrayList<UserPO> userList = new ArrayList<UserPO>();

	public UserDataImpl(){
		//TODO Read Serialized-files
	}

	public ResultMessage addUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		if(findUser(user.getUserName()).equals(null)){
			this.userList.add(user);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The user already exists!");
		}
	}

	public UserPO findUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO result = null;
		Iterator<UserPO> it = userList.iterator();
		while(it.hasNext()){
			UserPO next = it.next();
			if(next.getUserName()==id){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO user = findUser(id);
		if(!user.equals(null)){
			userList.remove(user);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the user!");
		}
	}

	public ResultMessage updateUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO tempUser = findUser(user.getUserName());
		if(!tempUser.equals(null)){
			tempUser = user;
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the user!");
		}
	}

}
