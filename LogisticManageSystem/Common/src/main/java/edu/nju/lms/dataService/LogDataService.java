package edu.nju.lms.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.OperationPO;
import edu.nju.lms.data.ResultMessage;
/**
 * 
 * @author oppa
 *2015/10/25
 */
public interface LogDataService extends Remote{
	/**
	 * @param operation
	 * @return ResultMessage
	 * @throws RemoteException
	 * @see OperationPO ResultMessage
	 */
	public ResultMessage addOperation(OperationPO operation) throws RemoteException;
	
	/**
	 * @param begin
	 * @param end
	 * @return a list of OperationPO
	 * @throws RemoteException
	 * @see OperationPO
	 */
	public ArrayList<OperationPO> findOperation(Calendar begin, Calendar end) throws RemoteException;
}
