package edu.nju.lms.businessLogicService;

import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public interface ListblService {
	/**
	 *  to find if there exist list that has'nt checked
	 * @return
	 */
	public ArrayList<ListVO>  getListInfo(ListType type);
	
	/**
	 * use id to find List，and change the data
	 * @param List
	 * @return
	 */
	public ResultMessage changeList(ListVO List,ListType type);
	
}
