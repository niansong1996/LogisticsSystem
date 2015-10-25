package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceReceiptDataService;

public class FinanceReceiptDataImpl implements FinanceReceiptDataService{

	public ResultMessage addReceipt(ReceiptPO Receipt) throws RemoteException {
		
		return new ResultMessage(true,"");
	}

	public List<ReceiptPO> findReceipt(Calendar date) throws RemoteException {
		
		List<ReceiptPO> list=new ArrayList<ReceiptPO>();
		return list;
	}

	public ResultMessage deleteReceipt(String id) throws RemoteException {
		
		return new ResultMessage(true,"");
	}

	public ResultMessage updateReceipt(ReceiptPO Receipt)
			throws RemoteException {
		
		return new ResultMessage(true,"");
	}

}
