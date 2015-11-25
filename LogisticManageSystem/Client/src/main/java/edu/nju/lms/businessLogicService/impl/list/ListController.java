package edu.nju.lms.businessLogicService.impl.list;

import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogicService.ListblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.ListDataService;

public class ListController implements ListblService{
	
	ListDataService listService;
	ListblImpl list;
	LogController logController;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	String time="";
	OperationVO op=null;
	String logID;
	
	public ListController(){
		try {
			listService=(ListDataService) Naming.lookup("//127.0.0.1:1099/ListDataService");
			list=new ListblImpl(listService);
			//logController=new LogController();
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
//		time=sdf.format(new Date());
//		op=new OperationVO(time,logID,"查看单据信息");
//		logController.addLog(op);
				
		return result;
	}

	public ResultMessage changeList(ListVO List) {
		ResultMessage result=list.changeList(List);
//		if(result.isSuccess()){
//			time=sdf.format(new Date());
//			op=new OperationVO(time,logID,"更新单据信息");
//			logController.addLog(op);
//		}
		
		return result;
	}
	
	public ListVO getListInfo(String id) {
		ListVO result=list.getListInfo(id);
//		time=sdf.format(new Date());
//		op=new OperationVO(time,logID,"查看单据信息");
//		logController.addLog(op);
		return result;
	}

}
