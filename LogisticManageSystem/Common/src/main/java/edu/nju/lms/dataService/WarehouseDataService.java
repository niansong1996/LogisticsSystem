package edu.nju.lms.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.InventoryPO;
import edu.nju.lms.PO.WarehousePO;
import edu.nju.lms.data.ResultMessage;
/**
 * manage the info of the warehouse
 * @author oppa
 * 2015/10/25
 */
public interface WarehouseDataService extends Remote{
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
	
	public ArrayList<WarehousePO> showAllWarehouse() throws RemoteException;
	
	/**
	 * @param inventorypo
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addInventory(InventoryPO warehouse) throws RemoteException;
	
	/**
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public InventoryPO findInventory(String expressNum,String warehouseId) throws RemoteException;
	
	public ArrayList<InventoryPO> findInventory(Calendar start,Calendar end,String warehouseId) throws RemoteException;
	
	public ArrayList<InventoryPO> findInventory(String warehouseId) throws RemoteException;
	
	/**
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deleteInventory(String expressNum,String warehouseId) throws RemoteException;
	
	/**
	 * @param inventorypo
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage updateInventory(InventoryPO warehouse) throws RemoteException;
}

