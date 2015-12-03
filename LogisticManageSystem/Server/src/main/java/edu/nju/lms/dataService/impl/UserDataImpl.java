package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.UserDataService;

public class UserDataImpl extends UnicastRemoteObject implements UserDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3487505568096355509L;


	public UserDataImpl()throws RemoteException{

	}
	public ResultMessage addUser(UserPO user) throws RemoteException {

		if(findUser(user.getUserName())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(user, user.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The user already exists!");
		}
	}

	public UserPO findUser(String id) throws RemoteException {
		UserPO user = null;
		ResultSet result = JDBC.ExecuteQuery("select * from userpo where userName = "+id);
		try{
		if(!result.wasNull())
			user = (UserPO)POGenerator.generateObject(result, UserPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return user;
	}

	public ResultMessage deleteUser(String id) throws RemoteException {
		UserPO user = findUser(id);
		if(!(user==null)){
			JDBC.ExecuteData("delete from userpo where userName = "+id+";");
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the user!");
		}
	}

	public ResultMessage updateUser(UserPO user) throws RemoteException {
		UserPO tempUser = findUser(user.getUserName());
		if(!(tempUser==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(user, user.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the user!");
		}
	}

	public ArrayList<UserPO> getAllUser() throws RemoteException {
		ArrayList<UserPO> userList = new ArrayList<UserPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from userpo;");
		try{
		if(!result.wasNull()){
			POGenerator.generateMultiObject(userList,result, UserPO.class.getName());
		}
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return userList;
	}

}
