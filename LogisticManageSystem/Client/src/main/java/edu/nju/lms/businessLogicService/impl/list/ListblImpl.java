package edu.nju.lms.businessLogicService.impl.list;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.VO.ListVO;
import edu.nju.lms.data.ListType;
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

	public ArrayList<ListVO> getListInfo(ListType type) {
		ArrayList<ListVO> result=new ArrayList<ListVO>();
		ArrayList<ListPO> list=new ArrayList<ListPO>();
		
		try {
			list=service.findList(type);
		} catch (RemoteException e) {
			// TODO
		}
		for(ListPO po : list){
			if(po.getState().equals("WAITING")){
				ListVO temp=new ListVO(po.getId());
				result.add(temp);
			}
		}
		return result;
	}

	public ListVO getListInfo(String id){
		ListVO list=null;
		ListPO po=null;
		try {
			po=service.findList(id);
			list=new ListVO(po.getId());
		} catch (RemoteException e) {
			// TODO 
		}
		return list;
	}
	
	public ResultMessage changeList(ListVO List) {
		ResultMessage result=new ResultMessage(false,"");
		ListPO po=new ListPO(List.getId(),List.getState());
		result=service.updateList(po);
		
		return result;
	}

}
