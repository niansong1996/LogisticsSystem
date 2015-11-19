package edu.nju.lms.businessLogicService.impl.log;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.OperationPO;
import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.LogDataService;

/**
 *@author oppalu
 *@date 2015/11/19
 */
public class LogblImpl {
	
	private LogDataService logData=null;
	
	public LogblImpl(LogDataService logService){
		this.setLogData(logService);
	}
	/**
	 * get the info of log in valid time
	 * @param begin
	 * @param end
	 * @return
	 */
	public ArrayList<OperationVO> getLogInfo(Calendar begin, Calendar end) {
		ArrayList<OperationVO> log = new ArrayList<OperationVO>();
		ArrayList<OperationPO> temp=null;
		try {
			temp=logData.findOperation(begin, end);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for(OperationPO opPO: temp){
			OperationVO op=new OperationVO(opPO.getTime(),opPO.getUser(),opPO.getExplain());
			log.add(op);
		}
		return log;
	}

	/**
	 * add a new log info
	 * @param op
	 * @return
	 */
	public ResultMessage addLog(OperationVO op) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		OperationPO opPO=new OperationPO(op.getTime(),op.getUser(),op.getExplain());
		try {
			result=logData.addOperation(opPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public LogDataService getLogData() {
		return logData;
	}

	public void setLogData(LogDataService logData) {
		this.logData = logData;
	}
}
