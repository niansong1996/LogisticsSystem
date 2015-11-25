package simpletest;

import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;

public class Demo1 {
	BusinessLogicFactory factory = new BusinessLogicFactory();
	public static void main(String[] args){
//		BusinessLogicFactory.createDepartmentController();
		DepartmentController controller;
		try {
			controller = BusinessLogicFactory.getDepartmentController();
			controller.findCity("025");
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
		
	}
}
