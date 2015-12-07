package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.OperationPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.DataUtility;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.LogDataService;
/**
 * @author nians	
 * @date 2015/12/01
 *
 */
public class LogDataImpl extends UnicastRemoteObject implements LogDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1746434963927589723L;

	public LogDataImpl() throws RemoteException {
	}

	/**
	 * add a log info
	 * write it into the sql file
	 */
	public ResultMessage addOperation(OperationPO operation) throws RemoteException {
			JDBC.ExecuteData(POGenerator.generateInsertOp(operation, operation.getClass().getName()));
			return new ResultMessage(true,"success");
	}

	/**
	 * find the info of log in valid time
	 */
	public ArrayList<OperationPO> findOperation(Calendar begin, Calendar end) throws RemoteException {
		ArrayList<OperationPO> operationList = new ArrayList<OperationPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from operationpo where timing between \""
				+ DataUtility.Cal2String(begin)+" 00:00:00\" and \""+DataUtility.Cal2String(end)+" 23:59:59\";" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(operationList,result, OperationPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return operationList;
	}
}
