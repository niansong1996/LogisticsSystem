package edu.nju.lms.businessLogic;

import edu.nju.lms.businessLogicService.impl.department.DepartmentController;

public class BusinessLogicFactory {
	private static DepartmentController departmentController;
	public static DepartmentController createDepartmentController(){
		departmentController = new DepartmentController();
		return departmentController;
	}
	public static DepartmentController getDepartmentController() throws NoBusinessLogicException{
		if(departmentController!=null) return departmentController;
		else throw new NoBusinessLogicException();
	}
}
