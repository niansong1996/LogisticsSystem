package edu.nju.lms.businessLogicService.impl;

import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.PersonnelblService;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class PersonnelblImpl implements PersonnelblService {

	public PersonnelVO findPersonInfo(String id) {
		// TODO Auto-generated method stub
		return new PersonnelVO("du","000000000","manager",54120,0,5000);
	}

	public ResultMessage deletePersonnel(String id) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ResultMessage updatePersonnel(PersonnelVO Personnel) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ResultMessage addPersonnel(PersonnelVO Personnel) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

}
