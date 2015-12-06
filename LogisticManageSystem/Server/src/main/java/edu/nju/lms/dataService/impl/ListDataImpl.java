package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.PO.NumOccupancyPO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.ListDataService;

public class ListDataImpl extends UnicastRemoteObject implements  ListDataService{

	private static final long serialVersionUID = 7297460025532046217L;

	public ListDataImpl() throws RemoteException {
	}

	public ArrayList<ListPO> findList(ListType type) throws RemoteException {
		ArrayList<ListPO> list=new ArrayList<ListPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from "+type.toString().toLowerCase()+"po ;");
		String classType = type.toString();
		classType = classType.charAt(0)+classType.substring(1).toLowerCase()+"PO";
		try{
			if(!result.wasNull())
				POGenerator.generateMultiObject(list,result, Class.forName("edu.nju.lms.PO."+classType).getName());
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
	
	public NumOccupancyPO getNumOccupancy(){
		NumOccupancyPO numOccupancyPO = null;
		ResultSet result = JDBC.ExecuteQuery("select * from numoccupancypo ;");
		try{
			if(!result.wasNull())
				numOccupancyPO = (NumOccupancyPO)POGenerator.generateObject(result,NumOccupancyPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return numOccupancyPO;
	}
	
	public ResultMessage updateNumOccupancy(NumOccupancyPO numOccupancy) throws RemoteException {
		NumOccupancyPO tempNumOccupancy = getNumOccupancy();
		if(!(tempNumOccupancy==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(numOccupancy, numOccupancy.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the numOccupancy!");
		}
	}

	public ArrayList<ListPO> findAllList() throws RemoteException {
		
		return null;
	}

	public ListPO findListInfo(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
