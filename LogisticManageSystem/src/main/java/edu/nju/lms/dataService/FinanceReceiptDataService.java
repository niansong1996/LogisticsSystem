package edu.nju.lms.dataService;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.data.ResultMessage;

/**
 * @author oppa
 * 2015/10/25
 */
public interface FinanceReceiptDataService {
	/**
	 * @param ReceiptPO
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addReceipt(ReceiptPO Receipt) throws RemoteException;
	
	/**
	 * @param date
	 * @return a list of ReceiptPO
	 * @throws RemoteException
	 * @see ReceiptPO
	 */
	public List<ReceiptPO> findReceipt(Calendar date) throws RemoteException;
	
	/**
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deleteReceipt(long id) throws RemoteException;
	
	/**
	 * @param ReceiptPO
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage updateReceipt(ReceiptPO Receipt) throws RemoteException;
}
