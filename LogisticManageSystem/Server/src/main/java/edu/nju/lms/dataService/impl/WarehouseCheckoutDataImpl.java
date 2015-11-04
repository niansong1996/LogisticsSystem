package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.Location;
import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;

public class WarehouseCheckoutDataImpl implements WarehouseCheckoutDataService{
	
	private ArrayList<CheckoutPO> checkoutList = new ArrayList<CheckoutPO>();
	
	public ResultMessage addCheckout(CheckoutPO checkout) throws RemoteException {
		if(findCheckout(checkout.getId())==null){
			this.checkoutList.add(checkout);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The checkout list already exists!");
		}
	}

	public CheckoutPO findCheckout(String id) throws RemoteException {
		CheckoutPO result = null;
		Iterator<CheckoutPO> it = checkoutList.iterator();
		while(it.hasNext()){
			CheckoutPO next = it.next();
			if(next.getId()==id){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteCheckout(String id) throws RemoteException {
		CheckoutPO checkout = findCheckout(id);
		if(!(checkout==null)){
			checkoutList.remove(checkout);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the checkout list!");
		}
	}

	public ResultMessage updateCheckout(CheckoutPO checkout) throws RemoteException {
		CheckoutPO tempCheckout = findCheckout(checkout.getId());
		if(!(tempCheckout==null)){
			tempCheckout = checkout;
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the checkout list!");
		}
	}

}
