package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.nju.lms.PO.OperationPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.LogDataService;

public class LogDataImpl implements LogDataService{

	public ResultMessage addOperation(OperationPO operation)
			throws RemoteException {
		
		ArrayList<OperationPO> op =new ArrayList<OperationPO>();
		op.add(operation);
		return new ResultMessage(true,"");
	}

	public List<OperationPO> findOperation(Calendar begin, Calendar end)
			throws RemoteException {
		
		Calendar c=Calendar.getInstance();
		c.set(2015, 10, 20);;
		List<OperationPO> list=new ArrayList<OperationPO>();
		OperationPO op1=new OperationPO("add a user",c ,"oppa");
		
		if(begin.before(c)&&end.after(c)){
			return list;
		}else{
			return null;
		}
	}

}
