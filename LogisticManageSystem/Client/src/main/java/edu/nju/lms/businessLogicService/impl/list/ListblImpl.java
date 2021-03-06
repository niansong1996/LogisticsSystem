package edu.nju.lms.businessLogicService.impl.list;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.VO.ListVO;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.ListDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class ListblImpl{

	public ListblImpl(){
	}

	public ArrayList<ListVO> getListInfo(ListDataService service,ListType type) {
		ArrayList<ListVO> result=new ArrayList<ListVO>();
		ArrayList<ListPO> list=new ArrayList<ListPO>();
		try {
			list=service.findList(type);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(list!=null){
			for(ListPO po : list){
				if(po.getState().toString().equals("WAITING")){
					ListVO temp=new ListVO(po.getId());
					temp.setType(type);
					result.add(temp);
				}
			}
		}
		return result;
	}

	public ResultMessage changeList(ListDataService service,ListVO List,ListType type) {
		try {
			return service.updateList(List.getId(), List.getState(),type);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}	
	}

	public ListVO getListInfo(ListDataService service,String id){
		ListVO result=null;
		ListType type=null;
		ListPO po=null;
		try {
			for(int i=0;i<10;i++){
				type = ListType.values()[i];
				po = service.findList(type,id);
				if(po!=null) break;
			}
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			result=new ListVO(po.getId());
			result.setType(type);
		}
		return result;
	}

}
