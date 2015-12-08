package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.nju.lms.PO.EarningsPO;
import edu.nju.lms.PO.PaymentPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.DataUtility;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.FinancePaymentDataService;

public class FinancePaymentDataImpl extends UnicastRemoteObject implements FinancePaymentDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2572637723704446581L;
	public FinancePaymentDataImpl() throws RemoteException {
	}

	public ResultMessage addPayment(PaymentPO payment) throws RemoteException {
		if(findPayment(payment.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(payment, payment.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The payment already exists!");
		}
	}

	public List<PaymentPO> findPayment(Calendar date) throws RemoteException {
		ArrayList<PaymentPO> paymentList = new ArrayList<PaymentPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from paymentpo where payTime between \""
				+ DataUtility.Cal2String(date)+" 00:00:00\" and \""+DataUtility.Cal2String(date)+" 23:59:59\";" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(paymentList,result, PaymentPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return paymentList;
	}

	public PaymentPO findPayment(String id) throws RemoteException{
		PaymentPO payment = null;
		ResultSet result = JDBC.ExecuteQuery("select * from paymentpo where id = "+id+";");
		try{
		if(!result.wasNull())
			payment = (PaymentPO)POGenerator.generateObject(result, PaymentPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return payment;
	}
	
	public ResultMessage deletePayment(String id) throws RemoteException {
		PaymentPO payment = findPayment(id);
		if(!(payment==null)){
			JDBC.ExecuteData("delete from paymentpo where id = "+id+";");
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the payment!");
		}
	}

	public ResultMessage updatePayment(PaymentPO payment)
			throws RemoteException {
		PaymentPO tempPayment = findPayment(payment.getId());
		if(!(tempPayment==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(payment, payment.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the payment!");
		}
	}

	public List<EarningsPO> findEarnings(Calendar start,Calendar end) throws RemoteException {
		ArrayList<EarningsPO> earningsList=new ArrayList<EarningsPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from earningspo where payTime between \""
				+ DataUtility.Cal2String(start)+" 00:00:00\" and \""+DataUtility.Cal2String(end)+" 23:59:59\";" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(earningsList,result, EarningsPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return earningsList;
	}

	public ArrayList<PaymentPO> showAllPayment() throws RemoteException {
		ArrayList<PaymentPO> paymentList = new ArrayList<PaymentPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from paymentpo;" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(paymentList,result, PaymentPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return paymentList;
	}

	public ArrayList<PaymentPO> showAllPayment(Calendar start, Calendar end) throws RemoteException {
		ArrayList<PaymentPO> paymentList = new ArrayList<PaymentPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from paymentpo where payTime between \""
				+ DataUtility.Cal2String(start)+" 00:00:00\" and \""+DataUtility.Cal2String(end)+" 23:59:59\";" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(paymentList,result, PaymentPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return paymentList;
	}
	
}
