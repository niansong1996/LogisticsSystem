package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.data.ResultMessage;

/**
 * manage the info of checkout list
 * @author user
 *
 */
public interface WarehouseCheckoutDataService {
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
	public CheckoutPO findCheckout(long id) throws RemoteException;
	
	/**
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deleteCheckout(long id) throws RemoteException;
	
	/**
	 * @param checkout
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage updateCheckout(CheckoutPO checkout) throws RemoteException;
}
