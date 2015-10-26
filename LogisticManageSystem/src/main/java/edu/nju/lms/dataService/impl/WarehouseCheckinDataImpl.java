package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.WarehouseCheckinDataService;

public class WarehouseCheckinDataImpl implements WarehouseCheckinDataService{

private ArrayList<CheckinPO> checkinList = new ArrayList<CheckinPO>();
	
	public ResultMessage addCheckin(CheckinPO checkin) throws RemoteException {
		if(findCheckin(checkin.getId())==null){
			this.checkinList.add(checkin);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The checkin list already exists!");
		}
	}

	public CheckinPO findCheckin(String id) throws RemoteException {
		CheckinPO result = null;
		Iterator<CheckinPO> it = checkinList.iterator();
		while(it.hasNext()){
			CheckinPO next = it.next();
			if(next.getId()==id){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteCheckin(String id) throws RemoteException {
		CheckinPO checkin = findCheckin(id);
		if(!(checkin==null)){
			checkinList.remove(checkin);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the checkin list!");
		}
	}

	public ResultMessage updateCheckin(CheckinPO checkin) throws RemoteException {
		CheckinPO tempCheckin = findCheckin(checkin.getId());
		if(!(tempCheckin==null)){
			tempCheckin = checkin;
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the checkin list!");
		}
	}

}
