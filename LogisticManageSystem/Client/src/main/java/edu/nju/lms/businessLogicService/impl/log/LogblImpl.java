package edu.nju.lms.businessLogicService.impl.log;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogicService.LogblService;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class LogblImpl {

	public ArrayList<OperationVO> getLogInfo(Calendar begin, Calendar end) {
		ArrayList<OperationVO> log = new ArrayList<OperationVO>();
		log.add(new OperationVO("add check out list","2015/5/12","57635963"));
		return log;
	}

	public ResultMessage addLog(OperationVO op) {
		return new ResultMessage(true,null);
	}

}