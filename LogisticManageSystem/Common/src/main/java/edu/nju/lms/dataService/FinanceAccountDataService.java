package edu.nju.lms.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.InitialInfoPO;
import edu.nju.lms.data.ResultMessage;

/**
 * 
 * @author oppa
 * 2015/10/25
 */
public interface FinanceAccountDataService extends Remote{
	/**
	 * initial the info of the company's initial financial
	 * @param InitialInfo
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addInitialInfo(InitialInfoPO InitialInfo) throws RemoteException;
	
	public ArrayList<InitialInfoPO> findInitialInfo() throws RemoteException;
	
	/**
	 * @param Account
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addAccount(AccountPO Account) throws RemoteException;
	
	/**
	 * @param id
	 * @return AccountPO
	 * @throws RemoteException
	 * @see AccountPO
	 */
	public AccountPO findAccount(String id) throws RemoteException;
	
	public ArrayList<AccountPO> showAllAccount() throws RemoteException;

	/**
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deleteAccount(String id) throws RemoteException;
	
	/**
	 * @param Account
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage updateAccount(AccountPO Account) throws RemoteException;
}
