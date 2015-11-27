package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.WarehouseCheckinDataService;

public class WarehouseCheckinDataImpl implements WarehouseCheckinDataService{
	
	public ResultMessage addCheckin(CheckinPO checkin) throws RemoteException {
		if(findCheckin(checkin.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(checkin, checkin.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The checkin already exists!");
		}
	}

	public CheckinPO findCheckin(String id) throws RemoteException {
		CheckinPO checkin = null;
		ResultSet result = JDBC.ExecuteQuery("select * from checkinpo where id = "+id);
		try{
		if(!result.wasNull())
			checkin = (CheckinPO)POGenerator.generateObject(result, CheckinPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return checkin;
	}

	public ResultMessage deleteCheckin(String id) throws RemoteException {
		CheckinPO checkin = findCheckin(id);
		if(!(checkin==null)){
			JDBC.ExecuteData("delete from checkinpo where id = "+id+";");
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the checkin!");
		}
	}

	public ResultMessage updateCheckin(CheckinPO checkin) throws RemoteException {
		CheckinPO tempCheckin = findCheckin(checkin.getId());
		if(!(tempCheckin==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(checkin, checkin.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the checkin!");
		}
	}

}
