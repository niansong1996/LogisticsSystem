package edu.nju.lms.businessLogicService.impl.log;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.OperationPO;
import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.LogDataService;

/**
 *@author oppalu
 *@date 2015/11/19
 */
public class LogblImpl {
	
	public LogblImpl(){
	}
	/**
	 * get the info of log in valid time
	 * @param begin
	 * @param end
	 * @return
	 */
	public ArrayList<OperationVO> getLogInfo(Calendar begin, Calendar end,LogDataService logData) {
		ArrayList<OperationVO> log = new ArrayList<OperationVO>();
		ArrayList<OperationPO> temp=null;
		try {
			temp=logData.findOperation(begin, end);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(temp!=null){
			for(OperationPO opPO: temp){
				OperationVO op=new OperationVO(opPO.getTiming(),opPO.getUsername(),opPO.getExplanation());
				log.add(op);
			}
		}
		return log;
	}

	/**
	 * add a new log info
	 * @param op
	 * @return
	 */
	public ResultMessage addLog(OperationVO op,LogDataService logData) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		OperationPO opPO=new OperationPO(op.getExplain(),op.getTime(),op.getUser());
		try {
			result=logData.addOperation(opPO);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}
}
