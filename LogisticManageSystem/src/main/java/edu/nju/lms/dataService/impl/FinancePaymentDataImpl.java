package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.nju.lms.PO.EarningsPO;
import edu.nju.lms.PO.PaymentPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinancePaymentDataService;

public class FinancePaymentDataImpl implements FinancePaymentDataService{

	public ResultMessage addPayment(PaymentPO payment) throws RemoteException {
		
		return new ResultMessage(true,"");
	}

	public List<PaymentPO> findPayment(Calendar date) throws RemoteException {
		
		List<PaymentPO> list=new ArrayList<PaymentPO>();
		return list;
	}

	public ResultMessage deletePayment(String id) throws RemoteException {
		
		return new ResultMessage(true,"");
	}

	public ResultMessage updatePayment(PaymentPO Payment)
			throws RemoteException {
		
		return new ResultMessage(false,"no such payment!");
	}

	public List<EarningsPO> findEarning(Calendar date) throws RemoteException {
		
		List<EarningsPO> list=new ArrayList<EarningsPO>();
		return list;
	}

}
