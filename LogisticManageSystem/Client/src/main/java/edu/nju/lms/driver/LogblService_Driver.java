package edu.nju.lms.driver;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogicService.LogblService;
import edu.nju.lms.businessLogicService.impl.log.LogblImpl;
import edu.nju.lms.data.ResultMessage;

public class LogblService_Driver {

	public void drive(LogblService logblService) {
		ResultMessage result=logblService.addLog(null);
		if(result==new ResultMessage(true,"")){
			System.out.println("add successfully!");
		}else{
			System.out.println(result.getErrorMessage());
		}
	
		ArrayList<OperationVO> list=logblService.getLogInfo(null,null);
		System.out.print(list);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogblService logblService=new LogblImpl();
		LogblService_Driver driver=new LogblService_Driver();
		driver.drive(logblService);
	}

}
