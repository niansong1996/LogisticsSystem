package edu.nju.lms.dataService;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import edu.nju.lms.PO.PaymentPO;
import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.data.ResultMessage;

public interface FinanceDataService {
	
	public ResultMessage addReceipt(ReceiptPO receipt) throws RemoteException;
	public List<ReceiptPO> findReceipt(Calendar date) throws RemoteException;
	public ResultMessage deleteReceipt(long id) throws RemoteException;
	public ResultMessage updateReceipt(ReceiptPO Receipt) throws RemoteException;
	
	public ResultMessage addPayment(PaymentPO payment) throws RemoteException;
	public List<PaymentPO> findPayment(Calendar date) throws RemoteException;
	public ResultMessage deletePayment(long id) throws RemoteException;
	public ResultMessage updatePayment(PaymentPO Payment) throws RemoteException;
}
