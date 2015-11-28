package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.PO.ListPO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.ListDataService;

public class ListDataImpl implements ListDataService{

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

	public ResultMessage updateList(String id, ListState state, ListType type) throws RemoteException {
		String poName = type.toString().toLowerCase()+"po";
		ResultSet result = JDBC.ExecuteQuery("select * from "+poName+" where id = "+id+" ;");
		try {
			if(!result.wasNull()){
				JDBC.ExecuteData("update "+poName+" set state = "+state+" where id = "+id+" ;");
				return new ResultMessage(true,null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResultMessage(false,"The list doesn't exist!");
	}

}
