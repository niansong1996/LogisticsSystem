package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;

public class WarehouseCheckoutDataImpl implements WarehouseCheckoutDataService{
	
	public ResultMessage addCheckout(CheckoutPO checkin) throws RemoteException {
		if(findCheckout(checkin.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(checkin, checkin.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The checkin already exists!");
		}
	}

	public CheckoutPO findCheckout(String id) throws RemoteException {
		CheckoutPO checkin = null;
		ResultSet result = JDBC.ExecuteQuery("select * from checkinpo where id = "+id);
		try{
		if(!result.wasNull())
			checkin = (CheckoutPO)POGenerator.generateObject(result, CheckoutPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return checkin;
	}

	public ResultMessage deleteCheckout(String id) throws RemoteException {
		CheckoutPO checkin = findCheckout(id);
		if(!(checkin==null)){
			JDBC.ExecuteData("delete from checkinpo where id = "+id+";");
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the checkin!");
		}
	}

	public ResultMessage updateCheckout(CheckoutPO checkin) throws RemoteException {
		CheckoutPO tempCheckout = findCheckout(checkin.getId());
		if(!(tempCheckout==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(checkin, checkin.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the checkin!");
		}
	}

}
