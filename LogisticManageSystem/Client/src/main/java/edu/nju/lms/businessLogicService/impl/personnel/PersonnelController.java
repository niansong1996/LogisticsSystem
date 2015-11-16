package edu.nju.lms.businessLogicService.impl.personnel;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.PersonnelblService;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年11月16日
 */
public class PersonnelController implements PersonnelblService{
	PersonnelblImpl personbl;
	public PersonnelVO findPersonInfo(String id) {
		return personbl.findPersonInfo(id);
	}

	public ResultMessage deletePersonnel(String id) {
		
		return personbl.deletePersonnel(id);
	}

	public ResultMessage updatePersonnel(PersonnelVO Personnel) {
		
		return personbl.updatePersonnel(Personnel);
	}

	public ResultMessage addPersonnel(PersonnelVO Personnel) {
		return personbl.addPersonnel(Personnel);
	}

}
