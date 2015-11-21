package edu.nju.lms.driver;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.PersonnelblService;
import edu.nju.lms.data.ResultMessage;

public class PersonnelblService_Driver {
	public void drive(PersonnelblService service){
		PersonnelVO personnel=service.findPersonInfo("1000000037");
		System.out.println(personnel.getDuty());
		ResultMessage result1=service.addPersonnel(service.findPersonInfo("1000000037"));
		System.out.println(result1.isSuccess());
		ResultMessage result2=service.deletePersonnel("1000000037");
		System.out.println(result2.isSuccess());
		ResultMessage result3=service.updatePersonnel(personnel);
		System.out.println(result3.isSuccess());
		ResultMessage result4=service.addPersonnel(personnel);
		System.out.println(result4.isSuccess());
	}
//	public static void main(String[] args){
//		String id = "9743686";
//		PersonnelblImpl personnelbl = new PersonnelblImpl();
//		PersonnelVO vo = new PersonnelVO("name","02566","department", "duty", 6000, 10, 500);
//		personnelbl.addPersonnel(vo);
//		personnelbl.deletePersonnel("");
//		personnelbl.findPersonInfo(id);
//		personnelbl.updatePersonnel(vo);
//	}
}
