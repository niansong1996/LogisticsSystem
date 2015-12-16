package edu.nju.lms.businessLogicService.impl.log;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogicService.LogblService;
import edu.nju.lms.businessLogicService.impl.utility.DataServiceFactory;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.LogDataService;

public class LogController implements LogblService{

	LogblImpl log;
	LogDataService logService;
	String logId;
	
	public LogController(){
		logService=DataServiceFactory.getLogDataService();
		log=new LogblImpl();

	}
	
	public ArrayList<OperationVO> getLogInfo(Calendar begin, Calendar end) {
		return log.getLogInfo(logService,begin, end);
	}

	public ResultMessage addLog(String explain) {
		OperationVO op=new OperationVO(CommonUtility.getTime(),logId,explain);
		return log.addLog(logService,op);
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}
}
