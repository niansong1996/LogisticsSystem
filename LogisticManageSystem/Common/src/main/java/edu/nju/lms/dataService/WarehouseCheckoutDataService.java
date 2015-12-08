package edu.nju.lms.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.data.ResultMessage;

/**
 * manage the info of checkout list
 * @author user
 *
 */
public interface WarehouseCheckoutDataService extends Remote{
	/**
	 * @param checkout
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addCheckout(CheckoutPO checkout) throws RemoteException;
	
	/**
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 * @see CheckoutPO
	 */
	public CheckoutPO findCheckout(String id) throws RemoteException;
	
	/**
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deleteCheckout(String id) throws RemoteException;
	
	/**
	 * @param checkout
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage updateCheckout(CheckoutPO checkout) throws RemoteException;
	
	public ArrayList<CheckoutPO> findCheckout(Calendar start,Calendar end,String warehouseNum) throws RemoteException;
}
