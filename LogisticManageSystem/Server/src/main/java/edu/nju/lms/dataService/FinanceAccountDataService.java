package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.InitialInforPO;
import edu.nju.lms.data.ResultMessage;

/**
 * 
 * @author oppa
 * 2015/10/25
 */
public interface FinanceAccountDataService {
	/**
	 * initial the info of the company's initial financial
	 * @param InitialInfo
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addInitialInfo(InitialInforPO InitialInfo) throws RemoteException;
	
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
