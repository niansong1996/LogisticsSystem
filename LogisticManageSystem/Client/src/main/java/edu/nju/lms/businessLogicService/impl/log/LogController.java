package edu.nju.lms.businessLogicService.impl.log;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogicService.LogblService;
import edu.nju.lms.data.ResultMessage;

public class LogController implements LogblService{

	LogblImpl log;
	
	public ArrayList<OperationVO> getLogInfo(Calendar begin, Calendar end) {
		return log.getLogInfo(begin, end);
	}

	public ResultMessage addLog(OperationVO op) {
		return log.addLog(op);
	}

}
