package edu.nju.lms.businessLogicService.impl.list;

import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.ListblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.utility.DataServiceFactory;
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
			listService= DataServiceFactory.getListDataService();
			list=new ListblImpl();
			listNum = new ListNumOccupancy(listService);
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ListVO> getListInfo(ListType type) {
		ArrayList<ListVO> result=list.getListInfo(listService,type);

		logController.addLog("查看类型为"+type.toString()+"的单据信息");

		return result;
	}

	public ResultMessage changeList(ListVO List,ListType type) {
		ResultMessage result=list.changeList(listService,List,type);

		if(result.isSuccess()){
			logController.addLog("审批类型为"+type.toString()+"的单据信息");
		}

		return result;
	}

	public String applyListNum(ListType type){
		return this.listNum.generateListNum(type);
	}
	
	public void saveListNum(){
		this.listNum.saveNumOccupancy();
	}
	
	public ListVO getListInfo(String id) {
		return list.getListInfo(listService,id);
	}
//	public static void main(String[] args){
//		ListController listController = BusinessLogicFactory.createListController();
//		ListVO list = listController.getListInfo("8736473827");
//		System.out.println(list.getId()+" "+list.getState());
//	}
}
