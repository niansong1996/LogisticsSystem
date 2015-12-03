package edu.nju.lms.businessLogicService.impl.personnel;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogicService.PersonnelblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.PersonnelDataService;

/**
 *@author tj
 *@date 2015年11月16日
 */
public class PersonnelController implements PersonnelblService{
	PersonnelDataService personService;
	PersonnelblImpl personbl;

	LogController logController;
	
	public PersonnelController(){
		try {
			logController=BusinessLogicFactory.getLogController();
			personService=(PersonnelDataService)Naming.lookup("//127.0.0.1:1099/PersonnelDataService");
			personbl=new PersonnelblImpl(personService);
		}catch (Exception e) {
			System.out.println("网络未连接");
	    	System.exit(0);
		}
	}
	
	public ArrayList<PersonnelVO> findPersonInfo(String id) {
		ArrayList<PersonnelVO> result=personbl.findPersonInfo(id);

		logController.addLog("查看员工"+id+"的信息");
		
		return result;
	}

	public ResultMessage deletePersonnel(String id) {
		ResultMessage result=personbl.deletePersonnel(id);

		if(result.isSuccess()){
			logController.addLog("删除员工"+id+"的信息");
		}
		
		return result;
	}

	public ResultMessage updatePersonnel(PersonnelVO Personnel) {
		ResultMessage result=personbl.updatePersonnel(Personnel);

		if(result.isSuccess()){
			logController.addLog("更新员工"+Personnel.getId()+"的信息");
		}
		
		return result;
	}

	public ResultMessage addPersonnel(PersonnelVO Personnel) {
		ResultMessage result=personbl.addPersonnel(Personnel);

		if(result.isSuccess()){
			logController.addLog("新增员工"+Personnel.getId()+"的信息");
		}
		
		return result;
	}
	public ResultMessage updatePerTimes(String id, double amount) {
		return personbl.updatePerTime(id, amount);
	}
	
	public ArrayList<PersonnelVO> showAllPersonnel() {
		ArrayList<PersonnelVO> result=personbl.showAllPersonnel();
		logController.addLog("查看所有员工的信息");
		return result;
	}

}
