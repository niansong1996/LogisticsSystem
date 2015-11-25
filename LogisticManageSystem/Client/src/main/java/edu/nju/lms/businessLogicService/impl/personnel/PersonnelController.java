package edu.nju.lms.businessLogicService.impl.personnel;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogicService.PersonnelblService;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.PersonnelDataService;

/**
 *@author tj
 *@date 2015年11月16日
 */
public class PersonnelController implements PersonnelblService{
	PersonnelDataService personService;
	PersonnelblImpl personbl;

	String logID="";
	
	public PersonnelController(){
		try {
			personService=(PersonnelDataService)Naming.lookup("//127.0.0.1:1099/PersonnelDataService");
			personbl=new PersonnelblImpl(personService);
		}catch (Exception e) {
			System.out.println("网络未连接！");
			System.exit(0);
		}
	}
	public PersonnelController(String id){
		this.logID=id;
	}
	
	public ArrayList<PersonnelVO> findPersonInfo(String id) {
		 ArrayList<PersonnelVO> result=personbl.findPersonInfo(id);

		return result;
	}

	public ResultMessage deletePersonnel(String id) {
		ResultMessage result=personbl.deletePersonnel(id);

		return result;
	}

	public ResultMessage updatePersonnel(PersonnelVO Personnel) {
		ResultMessage result=personbl.updatePersonnel(Personnel);

		return result;
	}

	public ResultMessage addPersonnel(PersonnelVO Personnel) {
		ResultMessage result=personbl.addPersonnel(Personnel);

		return result;
	}
	public ResultMessage updatePerTimes(String id, double amount) {
		return personbl.updatePerTime(id, amount);
	}

}
