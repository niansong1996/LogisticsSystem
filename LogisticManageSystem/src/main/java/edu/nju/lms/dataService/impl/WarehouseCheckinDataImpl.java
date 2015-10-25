package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.PO.Location;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.WarehouseCheckinDataService;

public class WarehouseCheckinDataImpl implements WarehouseCheckinDataService{

	public ResultMessage addCheckin(CheckinPO checkin) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public CheckinPO findCheckin(String id) throws RemoteException {
		// TODO Auto-generated method stub
		String expressNum = "739459474";
		Map m1 = new HashMap();
		m1.put(expressNum, new Location(PartitionType.CAR, 5, 10));
		Map m2 = new HashMap();
		m2.put("739459474","Nanjing");
		Calendar c = Calendar.getInstance();
		return new CheckinPO(expressNum, m1, c, m2);
	}

	public ResultMessage deleteCheckin(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ResultMessage updateCheckin(CheckinPO checkin) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

}
