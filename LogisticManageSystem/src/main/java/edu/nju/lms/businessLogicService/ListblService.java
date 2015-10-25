package edu.nju.lms.businessLogicService;

import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public interface ListblService {
	//查找是否存在未被审批的单据，返回所有未被审批的单据的引用
	public ArrayList<ListVO>  getListInfo();
	//根据id查找List，并修改相应的数据
	public ResultMessage changeList(ListVO List);
	
}
