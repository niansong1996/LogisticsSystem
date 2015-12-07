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
		}
		for(ListPO po : list){
			if(po.getState().toString().equals("WAITING")){
				ListVO temp=new ListVO(po.getId());
				result.add(temp);
			}
		}
		return result;
	}

	public ResultMessage changeList(ListVO List,ListType type) {
		try {
			return service.updateList(List.getId(), List.getState(),type);
		} catch (RemoteException e) {
			return new ResultMessage(false,"网络未连接");
		}	
	}

	public ListVO getListInfo(String id){
		ListVO result=null;
		ListPO po=null;
		try {
			for(int i=0;i<10;i++){
				ListType type = ListType.values()[i];
				po = service.findList(type,id);
				if(po!=null) break;
			}
		} catch (RemoteException e) {
		}
		if(po!=null){
			result=new ListVO(po.getId());
		}
		return result;
	}

}
