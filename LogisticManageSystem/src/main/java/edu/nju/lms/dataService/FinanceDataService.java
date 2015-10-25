package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.InitialInforPO;
import edu.nju.lms.data.ResultMessage;

public interface FinanceDataService {
	
	public ResultMessage addInitialInfo(InitialInforPO InitialInfo) throws RemoteException;
	
	public ResultMessage addAccount(AccountPO Account) throws RemoteException;
	
	public AccountPO findAccount(String id) throws RemoteException;
	
	public ResultMessage deleteAccount(String id) throws RemoteException;
	
	public ResultMessage updateAccount(AccountPO Account) throws RemoteException;
}
