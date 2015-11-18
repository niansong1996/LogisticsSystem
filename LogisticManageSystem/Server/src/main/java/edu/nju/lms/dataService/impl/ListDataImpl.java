package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.ListDataService;

public class ListDataImpl implements ListDataService{
	public List<ListPO> findList(Calendar begin, Calendar end) throws RemoteException {
		
		List<ListPO> list=new ArrayList<ListPO>();
		return list;
	}

	public ResultMessage updateList(String id, ListState state) throws RemoteException {
		
		return new ResultMessage(true,"");
	}

}
