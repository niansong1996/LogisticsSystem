package edu.nju.lms.businessLogicService.impl.personnel;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.PersonnelDataService;

/**
 *@author oppalu
 *@date 2015/11/20
 */
public class PersonnelblImpl  {
	private PersonnelDataService service=null;
	
	public PersonnelblImpl(PersonnelDataService service){
		this.service=service;
	}
	
	public PersonnelVO findPersonInfo(String id) {
		return null;
	}

	public ResultMessage deletePersonnel(String id) {
		return new ResultMessage(true,"");
	}

	public ResultMessage updatePersonnel(PersonnelVO Personnel) {
		return new ResultMessage(true,"");
	}

	public ResultMessage addPersonnel(PersonnelVO Personnel) {
		ResultMessage result=new ResultMessage(false,"");
		
		return result;
	}

}
