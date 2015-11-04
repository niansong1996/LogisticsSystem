package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import edu.nju.lms.PO.EarningsPO;
import edu.nju.lms.PO.PaymentPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinancePaymentDataService;

public class FinancePaymentDataImpl implements FinancePaymentDataService{
	private ArrayList<PaymentPO> paymentList=new ArrayList<PaymentPO>();
	private ArrayList<EarningsPO> earningList=new ArrayList<EarningsPO>();
	
	public ResultMessage addPayment(PaymentPO payment) throws RemoteException {
		if(findPayment(payment.getId())==null){
			this.paymentList.add(payment);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The payment already exists!");
		}
		
	}

	public List<PaymentPO> findPayment(Calendar date) throws RemoteException {
		ArrayList<PaymentPO> result=null;
		Iterator<PaymentPO> it = paymentList.iterator();
		while(it.hasNext()){
			PaymentPO next = it.next();
			if(next.getPayTime()==date){
				result.add(next);
			}
		}
		return result;
	}

	public PaymentPO findPayment(String id) throws RemoteException{
		PaymentPO result = null;
		Iterator<PaymentPO> it = paymentList.iterator();
		while(it.hasNext()){
			PaymentPO next = it.next();
			if(next.getId()==id){
				result = next;
				break;
			}
		}
		return result;
	}
	
	public ResultMessage deletePayment(String id) throws RemoteException {
		PaymentPO Payment = findPayment(id);
		if(!(Payment==null)){
			paymentList.remove(Payment);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the payment!");
		}
	}

	//TODO
	public ResultMessage updatePayment(PaymentPO Payment)
			throws RemoteException {
		PaymentPO tempPayment = findPayment(Payment.getId());
		if(!tempPayment.equals(null)){
			paymentList.remove(findPayment(Payment.getId()));
			paymentList.add(Payment);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the payment!");
		}
	}

	public List<EarningsPO> findEarning(Calendar date) throws RemoteException {
		ArrayList<EarningsPO> result=null;
		Iterator<EarningsPO> it = earningList.iterator();
		while(it.hasNext()){
			EarningsPO next = it.next();
			if(next.getDate()==date){
				result.add(next);
			}
		}
		return result;
	}

}
