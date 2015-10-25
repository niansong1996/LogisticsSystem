package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.PO.Location;
import edu.nju.lms.PO.WarehousePO;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.WarehouseDataService;

public class WarehouseDataImpl implements WarehouseDataService{

	public ResultMessage addWarehouse(WarehousePO warehouse)
			throws RemoteException {
		
		return new ResultMessage(true,"");
	}

	public WarehousePO findWarehouse(String id) throws RemoteException {
		double cordon=20.0;
		Map<String,Location> expressNums=new HashMap<String,Location>();
		ArrayList<CheckinPO> checkInlists=new ArrayList<CheckinPO>();
		ArrayList<CheckoutPO> checkOutlists=new ArrayList<CheckoutPO>(); 
		ArrayList<Partition> partitionInfor=new ArrayList<Partition>();
		
		WarehousePO po=new WarehousePO(cordon,expressNums,checkInlists,checkOutlists,partitionInfor);
		return po;
	}

	public ResultMessage deleteWarehouse(String id) throws RemoteException {
		
		return new ResultMessage(true,"");
	}

	public ResultMessage updateWarehouse(WarehousePO warehouse)
			throws RemoteException {
		
		return new ResultMessage(true,"");
	}

}
