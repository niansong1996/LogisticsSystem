package edu.nju.lms.businessLogicService.impl.list;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.ListblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.ListDataService;

public class ListController implements ListblService{

	ListDataService listService;
	ListblImpl list;
	ListNumOccupancy listNum;
	LogController logController;

	public ListController(){
		try {
			logController=BusinessLogicFactory.getLogController();
			listService=(ListDataService) Naming.lookup("//127.0.0.1:1099/ListDataService");
			list=new ListblImpl(listService);
			listNum = new ListNumOccupancy(listService);
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		} catch(Exception e1){
			System.err.println("网络未连接");
	    	System.exit(0);
		}
	}

	public ArrayList<ListVO> getListInfo(ListType type) {
		ArrayList<ListVO> result=list.getListInfo(type);

		logController.addLog("查看类型为"+type.toString()+"的单据信息");

		return result;
	}

	public ResultMessage changeList(ListVO List,ListType type) {
		ResultMessage result=list.changeList(List,type);

		if(result.isSuccess()){
			logController.addLog("审批类型为"+type.toString()+"的单据信息");
		}

		return result;
	}

	public String applyListNum(ListType type){
		return this.listNum.generateListNum(type);
	}

	public ListVO getListInfo(String id) {
		return list.getListInfo(id);
	}

}
