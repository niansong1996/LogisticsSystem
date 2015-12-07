package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.DataUtility;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.FinanceReceiptDataService;

public class FinanceReceiptDataImpl extends UnicastRemoteObject implements FinanceReceiptDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6783659224778825793L;
	
	public FinanceReceiptDataImpl() throws RemoteException{
		
	}
	
	public ResultMessage addReceipt(ReceiptPO receipt) throws RemoteException {
		if(findReceipt(receipt.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(receipt, receipt.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The receipt already exists!");
		}
	}

	public ArrayList<ReceiptPO> findReceipt(Calendar date) throws RemoteException {
		ArrayList<ReceiptPO> receiptList = new ArrayList<ReceiptPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from receiptpo where receiptDate between \""
				+ DataUtility.Cal2String(date)+" 00:00:00\" and \""+DataUtility.Cal2String(date)+" 23:59:59\";" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(receiptList,result, ReceiptPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return receiptList;
	}
	
	public ReceiptPO findReceipt(String id) throws RemoteException{
		ReceiptPO receipt = null;
		ResultSet result = JDBC.ExecuteQuery("select * from receiptpo where id = "+id);
		try{
		if(!result.wasNull())
			receipt = (ReceiptPO)POGenerator.generateObject(result, ReceiptPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return receipt;
	}

	public ResultMessage deleteReceipt(String id) throws RemoteException {
		ReceiptPO receipt = findReceipt(id);
		if(!(receipt==null)){
			JDBC.ExecuteData("delete from receiptpo where id = "+id+";");
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the receipt!");
		}
	}

	public ResultMessage updateReceipt(ReceiptPO receipt)
			throws RemoteException {
		ReceiptPO tempReceipt = findReceipt(receipt.getId());
		if(!(tempReceipt==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(receipt, receipt.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the receipt!");
		}
	}

	public ArrayList<ReceiptPO> findReceipt(Calendar date, String department)
			throws RemoteException {
		ArrayList<ReceiptPO> receiptList = new ArrayList<ReceiptPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from receiptpo where receiptDate between \""
				+ DataUtility.Cal2String(date)+" 00:00:00\" and \""+DataUtility.Cal2String(date)+" 23:59:59\""+
				" and courierNum like "+department+" ;" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(receiptList,result, ReceiptPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return receiptList;
	}

	public ArrayList<ReceiptPO> findReceipt(Calendar start, Calendar end) throws RemoteException {
		ArrayList<ReceiptPO> receiptList = new ArrayList<ReceiptPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from receiptpo where receiptDate between \""
				+ DataUtility.Cal2String(start)+" 00:00:00\" and \""+DataUtility.Cal2String(end)+" 23:59:59\";" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(receiptList,result, ReceiptPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return receiptList;
	}

}
