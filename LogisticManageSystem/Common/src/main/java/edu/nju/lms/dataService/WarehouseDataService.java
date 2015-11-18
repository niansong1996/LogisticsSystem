package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.WarehousePO;
import edu.nju.lms.data.ResultMessage;
/**
 * manage the info of the warehouse
 * @author oppa
 * 2015/10/25
 */
public interface WarehouseDataService {
	/**
	 * @param warehouse
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addWarehouse(WarehousePO warehouse) throws RemoteException;
	
	/**
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public WarehousePO findWarehouse(String id) throws RemoteException;
	
	/**
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deleteWarehouse(String id) throws RemoteException;
	
	/**
	 * @param warehouse
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage updateWarehouse(WarehousePO warehouse) throws RemoteException;
	
}

