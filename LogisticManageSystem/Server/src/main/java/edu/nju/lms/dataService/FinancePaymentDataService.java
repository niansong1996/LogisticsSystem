package edu.nju.lms.dataService;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import edu.nju.lms.PO.EarningsPO;
import edu.nju.lms.PO.PaymentPO;
import edu.nju.lms.data.ResultMessage;

/**
 * the data of the payment
 * @author oppa
 * 2015/10/25
 */
public interface FinancePaymentDataService {
	/**
	 * @param payment
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addPayment(PaymentPO payment) throws RemoteException;
	
	/**
	 * 
	 * @param date
	 * @return a list of PaymentPO
	 * @throws RemoteException
	 */
	public List<PaymentPO> findPayment(Calendar date) throws RemoteException;
	
	/**
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deletePayment(String id) throws RemoteException;
	
	/**
	 * @param Payment
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage updatePayment(PaymentPO Payment) throws RemoteException;
	
	/**
	 * show the earnings
	 * @param date
	 * @return a list of EarningsPO
	 * @throws RemoteException
	 */
	public List<EarningsPO> findEarning(Calendar date) throws RemoteException;
	
}
