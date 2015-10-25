package edu.nju.lms.businessLogicService;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public interface LogblService {
	//查找该时间段内的操作记录
	public ArrayList<OperationVO> getLogInfo(Calendar begin, Calendar end);

	public ResultMessage addLog(OperationVO op);
}
