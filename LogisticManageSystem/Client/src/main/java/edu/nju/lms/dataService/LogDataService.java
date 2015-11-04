package edu.nju.lms.dataService;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import edu.nju.lms.PO.OperationPO;
import edu.nju.lms.data.ResultMessage;
/**
 * 
 * @author oppa
 *2015/10/25
 */
public interface LogDataService {
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
	public List<OperationPO> findOperation(Calendar begin, Calendar end) throws RemoteException;
}
