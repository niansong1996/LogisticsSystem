package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.PO.PaymentPO;
import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceReceiptDataService;

public class FinanceReceiptDataImpl implements FinanceReceiptDataService{
	private ArrayList<ReceiptPO> ReceiptList = new ArrayList<ReceiptPO>();
	
	public FinanceReceiptDataImpl(){
		
	}
	
	public ResultMessage addReceipt(ReceiptPO Receipt) throws RemoteException {
		if(findReceipt(Receipt.getId())==null){
			this.ReceiptList.add(Receipt);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The receipt already exists!");
		}
	}

	public List<ReceiptPO> findReceipt(Calendar date) throws RemoteException {
		ArrayList<ReceiptPO> result=null;
		Iterator<ReceiptPO> it = ReceiptList.iterator();
		while(it.hasNext()){
			ReceiptPO next = it.next();
			if(next.getReceiptDate()==date){
				result.add(next);
			}
		}
		return result;
	}
	
	public ReceiptPO findReceipt(String id) throws RemoteException{
		ReceiptPO result = null;
		Iterator<ReceiptPO> it = ReceiptList.iterator();
		while(it.hasNext()){
			ReceiptPO next = it.next();
			if(next.getId()==id){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteReceipt(String id) throws RemoteException {
		ReceiptPO Receipt = findReceipt(id);
		if(!(Receipt==null)){
			ReceiptList.remove(Receipt);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the receipt!");
		}
	}

	//TODO
	public ResultMessage updateReceipt(ReceiptPO Receipt)
			throws RemoteException {
		
		ReceiptPO tempReceipt = findReceipt(Receipt.getId());
		if(tempReceipt!=null){
			ReceiptList.remove(findReceipt(Receipt.getId()));
			ReceiptList.add(Receipt);
			tempReceipt = Receipt;
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the receipt!");
		}
	}

}
