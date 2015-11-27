package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.ListDataService;

public class ListDataImpl implements ListDataService{
	
	private ArrayList<ListPO> list=new ArrayList<ListPO>();
	
	public ArrayList<ListPO> findList(ListType type) throws RemoteException {
		ArrayList<ListPO> list=new ArrayList<ListPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from "+type.toString().toLowerCase()+"po ;");
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(list,result, ListPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return list;
	}

	public ResultMessage updateList(ListPO list) throws RemoteException {
		ListPO tempList = findList(list.getId());
		if(!(tempList==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(list, list.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
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
