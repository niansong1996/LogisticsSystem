package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.UserDataService;

public class UserDataImpl implements UserDataService{
	private ArrayList<UserPO> userList = new ArrayList<UserPO>();

	public ResultMessage addUser(UserPO user) throws RemoteException {
		if(findUser(user.getUserName())==null){
			this.userList.add(user);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The user already exists!");
		}
	}

	public UserPO findUser(String id) throws RemoteException {
		UserPO result = null;
		Iterator<UserPO> it = userList.iterator();
		while(it.hasNext()){
			UserPO next = it.next();
			if(next.getUserName().equals(id)){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteUser(String id) throws RemoteException {
		UserPO user = findUser(id);
		if(!(user==null)){
			userList.remove(user);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the user!");
		}
	}

	public ResultMessage updateUser(UserPO user) throws RemoteException {
		UserPO tempUser = findUser(user.getUserName());
		if(!(tempUser==null)){
			deleteUser(tempUser.getUserName());
			addUser(user);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the user!");
		}
	}

	public ArrayList<UserPO> getAllUser() throws RemoteException {
		ArrayList<UserPO> result = new ArrayList<UserPO>();
		Iterator<UserPO> it1 = userList.iterator();
		while(it1.hasNext()){
			result.add(it1.next());
		}
		return result;
	}

}
