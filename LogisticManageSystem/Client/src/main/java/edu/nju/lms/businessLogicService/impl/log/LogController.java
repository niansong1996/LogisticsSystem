package edu.nju.lms.businessLogicService.impl.log;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogicService.LogblService;
import edu.nju.lms.data.CreateTime;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.LogDataService;

public class LogController implements LogblService{

	LogblImpl log;
	LogDataService logService;
	CreateTime getTime=new CreateTime();
	String logId;
	
	public LogController(){
		try {
			logService=(LogDataService) Naming.lookup("//127.0.0.1:1099/LogDataService");
			log=new LogblImpl(logService);
		} catch (Exception e) {
			System.out.println("网络未连接");
	    	System.exit(0);
		} 
	}
	
	public ArrayList<OperationVO> getLogInfo(Calendar begin, Calendar end) {
		return log.getLogInfo(begin, end);
	}

	public ResultMessage addLog(String explain) {
		OperationVO op=new OperationVO(logId,getTime.returnTime(),explain);
		return log.addLog(op);
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}
}
