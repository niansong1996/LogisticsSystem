package edu.nju.lms.businessLogicService.impl.list;

import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.businessLogicService.ListblService;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class ListblImpl implements ListblService{

	public ArrayList<ListVO> getListInfo() {
		// TODO Auto-generated method stub
		ArrayList<ListVO> lists = new ArrayList<ListVO>();
		lists.add(new ListVO("589631596"));
		return lists;
	}

	public ResultMessage changeList(ListVO List) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

}
