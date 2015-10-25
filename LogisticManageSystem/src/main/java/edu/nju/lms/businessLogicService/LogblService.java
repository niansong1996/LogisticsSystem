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
	/**
	 * to find the operation record within the period of time
	 * @param begin
	 * @param end
	 * @return
	 */
	public ArrayList<OperationVO> getLogInfo(Calendar begin, Calendar end);

	public ResultMessage addLog(OperationVO op);
}
