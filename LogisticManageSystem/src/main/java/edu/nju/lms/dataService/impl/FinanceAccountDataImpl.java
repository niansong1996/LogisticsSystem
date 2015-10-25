package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.InitialInforPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;

public class FinanceAccountDataImpl implements FinanceAccountDataService{

	public ResultMessage addInitialInfo(InitialInforPO InitialInfo)
			throws RemoteException {
		
		ArrayList<InitialInforPO> list=new ArrayList<InitialInforPO>();
		list.add(InitialInfo);
		
		return new ResultMessage(true,"");
	}

	public ResultMessage addAccount(AccountPO Account) throws RemoteException {
		
		ArrayList<AccountPO> list=new ArrayList<AccountPO>();
		list.add(Account);
		
		return new ResultMessage(true,"");
	}

	public AccountPO findAccount(String id) throws RemoteException {
		
		AccountPO account=new AccountPO("bank of China",2000000.0);
		if(id.equals(account.getName())){
			return account;
		}else{
			return null;
		}
	}

	public ResultMessage deleteAccount(String id) throws RemoteException {
		
		AccountPO account=new AccountPO("bank of China",2000000.0);
		if(id.equals(account.getName())){
			return new ResultMessage(true,"");
		}else{
			return new ResultMessage(false,"no such account!");
		}
	}

	public ResultMessage updateAccount(AccountPO Account) throws RemoteException {
		
		AccountPO account=new AccountPO("bank of China",2000000.0);
		if(Account.getName().equals(account.getName())){
			account=Account;
			return new ResultMessage(true,"");
		}else{
			return new ResultMessage(false,"no such account!");
		}
	}

}
