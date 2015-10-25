package edu.nju.lms.driver;

import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.businessLogicService.ListblService;
import edu.nju.lms.businessLogicService.impl.ListblImpl;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class ListblService_Driver {
	public void drive(ListblService listblService){
		ResultMessage result = listblService.changeList(new ListVO("0000000000"));
		if(result.isSuccess()){
			System.out.println("Update success\n");
		}else{
			System.out.println(result.getErrorMessage());
		}
		
		ArrayList<ListVO> listInfor = listblService.getListInfo();
		System.out.println(listInfor.get(0).getId());
	}
	public static void main5(String[] args) {
		ListblService_Driver d = new ListblService_Driver();
		ListblService listbl = new ListblImpl();
		d.drive(listbl);

	}

}
