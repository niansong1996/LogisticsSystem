package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.Location;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;

public class WarehouseCheckoutDataImpl implements WarehouseCheckoutDataService{

	public ResultMessage addCheckout(CheckoutPO checkout) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public CheckoutPO findCheckout(String id) throws RemoteException {
		// TODO Auto-generated method stub
		String expressNum = "739459474";
		Map m1 = new HashMap();
		m1.put(expressNum, new Location(PartitionType.CAR, 5, 10));
		ArrayList<String> list = new ArrayList();
		list.add(expressNum);
		Calendar c = Calendar.getInstance();
		ArrayList<String> businessNums=new ArrayList<String>();
		businessNums.add("0101010101");
		ArrayList<Double> distance=new ArrayList<Double>();
		distance.add(100.0);
		CityPO city=new CityPO("025","Nanjing",businessNums,distance);
		return new CheckoutPO(id,list,c,city,PartitionType.AIRPLANE,"3765948367","2163547389");
	}

	public ResultMessage deleteCheckout(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ResultMessage updateCheckout(CheckoutPO checkout) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

}
