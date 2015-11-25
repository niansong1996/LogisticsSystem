package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.ListDataService;

public class ListDataImpl implements ListDataService{
	
	private ArrayList<ListPO> list=new ArrayList<ListPO>();
	
	public List<ListPO> findList(ListType type) throws RemoteException {
		ArrayList<ListPO> result=new ArrayList<ListPO>();
		return result;
	}

	public ResultMessage updateList(ListPO list) throws RemoteException {
		return new ResultMessage(true,"");
	}

	public ListPO findList(String id) throws RemoteException {
		ListPO result = null;
		Iterator<ListPO> it = list.iterator();
		while(it.hasNext()){
			ListPO next = it.next();
			if(next.getId().equals(id)){
				result = next;
				break;
			}
		}
		return result;
	}

}
