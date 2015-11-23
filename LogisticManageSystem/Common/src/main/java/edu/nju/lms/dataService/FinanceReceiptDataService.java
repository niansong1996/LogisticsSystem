package edu.nju.lms.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.data.ResultMessage;

/**
 * @author oppa
 * 2015/10/25
 */
public interface FinanceReceiptDataService extends Remote{
	
	public ResultMessage addReceipt(ReceiptPO Receipt) throws RemoteException;

	public ResultMessage deleteReceipt(String id) throws RemoteException;
	
	public ResultMessage updateReceipt(ReceiptPO Receipt) throws RemoteException;
	
	public ArrayList<ReceiptPO> findReceipt(Calendar date) throws RemoteException;
	
	public ArrayList<ReceiptPO> findReceipt(Calendar date,String department) throws RemoteException;
	
}
