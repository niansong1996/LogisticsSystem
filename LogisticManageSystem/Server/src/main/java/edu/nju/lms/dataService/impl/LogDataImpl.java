package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import edu.nju.lms.PO.OperationPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.LogDataService;
/**
 * @author oppalu
 * 2015/11/18
 *
 */
public class LogDataImpl implements LogDataService{
	
	private ArrayList<OperationPO> operationList =new ArrayList<OperationPO>();

	public ResultMessage addOperation(OperationPO operation) throws RemoteException {
		operationList.add(operation);
		return new ResultMessage(true,null);
	}

	public List<OperationPO> findOperation(Calendar begin, Calendar end) throws RemoteException {
		Iterator<OperationPO> it=operationList.iterator();
		ArrayList<OperationPO> result=new ArrayList<OperationPO>();
		while(it.hasNext()){
			OperationPO operation=it.next();
			if(begin.before(operation.getTime())&&end.after(operation.getTime())){
				result.add(operation);
			}
		}
		return result;
	}
}
