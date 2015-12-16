package edu.nju.lms.businessLogicService.impl.personnel;

import java.util.ArrayList;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.PersonnelblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.utility.DataServiceFactory;
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
			personService=DataServiceFactory.getPersonnelDataService();
			personbl=new PersonnelblImpl();
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<PersonnelVO> findPersonInfo(String id) {
		ArrayList<PersonnelVO> result=personbl.findPersonInfo(personService,id);

		logController.addLog("查看员工"+id+"的信息");
		
		return result;
	}

	public ResultMessage deletePersonnel(String id) {
		ResultMessage result=personbl.deletePersonnel(personService,id);

		if(result.isSuccess()){
			logController.addLog("删除员工"+id+"的信息");
		}
		
		return result;
	}

	public ResultMessage updatePersonnel(PersonnelVO Personnel) {
		ResultMessage result=personbl.updatePersonnel(personService,Personnel);

		if(result.isSuccess()){
			logController.addLog("更新员工"+Personnel.getId()+"的信息");
		}
		
		return result;
	}

	public ResultMessage addPersonnel(PersonnelVO Personnel) {
		ResultMessage result=personbl.addPersonnel(personService,Personnel);

		if(result.isSuccess()){
			logController.addLog("新增员工"+Personnel.getId()+"的信息");
		}
		
		return result;
	}
	public ResultMessage updatePerTimes(String id, double amount) {
		return personbl.updatePerTime(personService,id, amount);
	}
	
	public ArrayList<PersonnelVO> showAllPersonnel() {
		ArrayList<PersonnelVO> result=personbl.showAllPersonnel(personService);
		logController.addLog("查看所有员工的信息");
		return result;
	}

	public static void main(String[] args) {
		PersonnelController p=BusinessLogicFactory.createPersonnelController();
		PersonnelVO p1=new PersonnelVO("1000000020", "abc", "", "总经理", 20000, 0, 0);
		PersonnelVO p2=new PersonnelVO("0101010001", "oppalu", "010101", "快递员", 4000, 30, 0);
		PersonnelVO p3=new PersonnelVO("0101017001", "nianzong", "010101", "营业厅业务员", 5000, 0, 0);
		PersonnelVO p4=new PersonnelVO("0250010001", "shushu", "025001", "中转中心仓库管理人员", 5000, 0, 0);
		ResultMessage result=p.addPersonnel(p1);
		System.out.println(result.isSuccess());
		result=p.addPersonnel(p2);
		System.out.println(result.isSuccess());
		result=p.addPersonnel(p3);
		System.out.println(result.isSuccess());
		result=p.addPersonnel(p4);
		System.out.println(result.isSuccess());
	}
}
