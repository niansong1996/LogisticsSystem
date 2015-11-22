package edu.nju.lms.businessLogicService.impl.list;

import java.util.ArrayList;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.VO.ListVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.ListDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class ListblImpl{
	
	private ListDataService service;
	
	public ListblImpl(ListDataService service){
		this.service=service;
	}

	public ArrayList<ListVO> getListInfo() {
		ArrayList<ListVO> result=null;
		ArrayList<ListPO> list=null;
		
		
		return result;
	}

	public ResultMessage changeList(ListVO List) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

}
