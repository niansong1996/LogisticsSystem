package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.DataUtility;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;

public class WarehouseCheckoutDataImpl extends UnicastRemoteObject implements WarehouseCheckoutDataService{
	
	public WarehouseCheckoutDataImpl() throws RemoteException {
	}

	private static final long serialVersionUID = -7331521818518305879L;

	public ResultMessage addCheckout(CheckoutPO checkout) throws RemoteException {
		if(findCheckout(checkout.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(checkout, checkout.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The checkout already exists!");
		}
	}

	public CheckoutPO findCheckout(String id) throws RemoteException {
		CheckoutPO checkout = null;
		ResultSet result = JDBC.ExecuteQuery("select * from checkoutpo where id = "+id+";");
		try{
		if(!result.wasNull())
			checkout = (CheckoutPO)POGenerator.generateObject(result, CheckoutPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return checkout;
	}

	public ResultMessage deleteCheckout(String id) throws RemoteException {
		CheckoutPO checkout = findCheckout(id);
		if(!(checkout==null)){
			JDBC.ExecuteData("delete from checkoutpo where id = "+id+";");
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the checkout!");
		}
	}

	public ResultMessage updateCheckout(CheckoutPO checkout) throws RemoteException {
		CheckoutPO tempCheckout = findCheckout(checkout.getId());
		if(!(tempCheckout==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(checkout, checkout.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the checkout!");
		}
	}

	public ArrayList<CheckoutPO> findCheckout(Calendar start, Calendar end) throws RemoteException {
		ArrayList<CheckoutPO> checkoutList = new ArrayList<CheckoutPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from checkoutpo where checkoutDate between \""
				+ DataUtility.Cal2String(start)+" 00:00:00\" and \""+DataUtility.Cal2String(end)+" 23:59:59\";" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(checkoutList,result, CheckoutPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return checkoutList;
	}

	public ArrayList<CheckoutPO> findCheckout(Calendar start, Calendar end, String warehouseNum)
			throws RemoteException {
		ArrayList<CheckoutPO> checkoutList = new ArrayList<CheckoutPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from checkoutpo where checkoutDate between \""
				+ DataUtility.Cal2String(start)+" 00:00:00\" and \""+DataUtility.Cal2String(end)+" 23:59:59\""
						+ "and warehouseNum = "+warehouseNum+" ;" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(checkoutList,result, CheckoutPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return checkoutList;
	}

}
