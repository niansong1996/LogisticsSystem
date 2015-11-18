package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.ListDataService;
/**
 * @author oppalu
 * 2015/11/18
 *
 */
public class ListDataImpl implements ListDataService{
	
	private ArrayList<ListPO> list=new ArrayList<ListPO>();
	
	public List<ListPO> findList(Calendar begin, Calendar end) throws RemoteException {
		Iterator<ListPO> it=list.iterator();
		ArrayList<ListPO> result=new ArrayList<ListPO>();
		while(it.hasNext()){
			ListPO l=it.next();
			//TODO
			//has problems
		}
		return result;
	}

	public ResultMessage updateList(String id, ListState state) throws RemoteException {
		ListPO tempList=findList(id);
		if(!(tempList==null)){
			tempList.setState(state);
			return new ResultMessage(true,null);
		}else{
			return new ResultMessage(false,"Could not find the list!");
		}
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
