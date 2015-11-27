package edu.nju.lms.businessLogicService.impl.list;

import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.VO.OperationVO;
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
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	String time="";
	LogController logController;
	String logID;
	
	public ListController(){
		try {
			listService=(ListDataService) Naming.lookup("//127.0.0.1:1099/ListDataService");
			list=new ListblImpl(listService);
		}catch (Exception e) {
			System.out.println("网络未连接");
			System.exit(0);
		}
	}
	public ListController(String id){
		this.logID=id;
	}
	
	public ArrayList<ListVO> getListInfo(ListType type) {
		ArrayList<ListVO> result=list.getListInfo(type);
		
		time=sdf.format(new Date());
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		OperationVO op=new OperationVO(time,logID,"查看类型为"+type.toString()+"的单据信息");
		logController.addLog(op);
		
		return result;
	}

	public ResultMessage changeList(ListVO List,ListType type) {
		ResultMessage result=list.changeList(List,type);
		
		if(result.isSuccess()){
			time=sdf.format(new Date());
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			OperationVO op=new OperationVO(time,logID,"审批类型为"+type.toString()+"的单据信息");
			logController.addLog(op);
		}
		
		return result;
	}
	
	public ListVO getListInfo(String id) {
		ListVO result=list.getListInfo(id);

		time=sdf.format(new Date());
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		OperationVO op=new OperationVO(time,logID,"查看"+id+"的单据信息");
		logController.addLog(op);
		
		return result;
	}
	public String getLogID() {
		return logID;
	}
	public void setLogID(String logID) {
		this.logID = logID;
	}
}
