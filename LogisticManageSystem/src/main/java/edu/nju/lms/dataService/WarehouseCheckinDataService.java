package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.data.ResultMessage;

/**
 * manage the info of checkin list
 * @author oppa
 * 2015/10/25
 */
public interface WarehouseCheckinDataService {
	/**
	 * @param checkin
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addCheckin(CheckinPO checkin) throws RemoteException;
	
	/**
	 * @param id
	 * @return CheckinPO
	 * @throws RemoteException
	 * @see CheckinPO
	 */
	public CheckinPO findCheckin(long id) throws RemoteException;
	
	/**
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deleteCheckin(long id) throws RemoteException;
	
	/**
	 * @param checkin
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage updateCheckin(CheckinPO checkin) throws RemoteException;
	
}
