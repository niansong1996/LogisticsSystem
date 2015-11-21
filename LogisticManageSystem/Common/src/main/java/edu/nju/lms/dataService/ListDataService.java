package edu.nju.lms.dataService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ResultMessage;
/**
 * 
 * @author oppalu
 *2015/10/25
 */

public interface ListDataService extends Remote{
	/**
	 * @param begin
	 * @param end
	 * @return a list of ListPO
	 * @throws RemoteException
	 * @see ListPO
	 */
	public List<ListPO> findList(Calendar begin,Calendar end) throws RemoteException;
	
	/**
	 * @param id
	 * @return a listpo
	 * @throws RemoteException
	 */
	public ListPO findList(String id) throws RemoteException;
	
	/**
	 * @param id
	 * @param state
	 * @return ResultMessage
	 * @throws RemoteException
	 * @see ListState ResultMessage
	 */
	public ResultMessage updateList(String id,ListState state) throws RemoteException;
}
