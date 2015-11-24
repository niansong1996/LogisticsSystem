package edu.nju.lms.dataService.impl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.PO.InitialInforPO;
import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.PO.UserPO;
import edu.nju.lms.PO.WarehousePO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.FinanceAccountDataService;

public class FinanceAccountDataImpl extends UnicastRemoteObject implements FinanceAccountDataService, Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2168651171849205562L;

	public FinanceAccountDataImpl() throws RemoteException{
		
	}
	
	//TODO
	public ResultMessage addInitialInfo(InitialInforPO InitialInfo) throws RemoteException {
		return null;
		
	}

	public ResultMessage addAccount(AccountPO account) throws RemoteException {

		if(findAccount(account.getName())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(account, account.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The account already exists!");
		}

	}

	public AccountPO findAccount(String id) throws RemoteException {
		AccountPO account = null;
		ResultSet result = JDBC.ExecuteQuery("select * from accountpo where name = "+id);
		try{
		if(!result.wasNull())
			account = (AccountPO)POGenerator.generateObject(result, AccountPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return account;
	}

	public ResultMessage deleteAccount(String id) throws RemoteException {
		AccountPO account = findAccount(id);
		if(!(account==null)){
			JDBC.ExecuteData("delete from accountpo where name = "+id+";");
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the account!");
		}
	}

	public ResultMessage updateAccount(AccountPO account) throws RemoteException {
		AccountPO tempAccount = findAccount(account.getName());
		if(!(tempAccount==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(account, account.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the account!");
		}
	}

}
