package edu.nju.lms.dataService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.PO.NumOccupancyPO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ListType;
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
	public ArrayList<ListPO> findList(ListType type) throws RemoteException;
	
	/**
	 * @param id
	 * @param state
	 * @return ResultMessage
	 * @throws RemoteException
	 * @see ListState ResultMessage
	 */
	public ResultMessage updateList(String id,ListState state,ListType type) throws RemoteException;
	
	/**
	 * use to store the occupancy of the used num of the lists
	 * @author nians
	 * 
	 */
	public NumOccupancyPO getNumOccupancy() throws RemoteException;
	
	public ResultMessage updateNumOccupancy(NumOccupancyPO numOccupancyPO) throws RemoteException;
	
}
