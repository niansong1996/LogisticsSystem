package edu.nju.lms.driver;

import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogicService.DepartmentblService;
import edu.nju.lms.businessLogicService.impl.DepartmentblImpl;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.DepartmentDataService;

public class DepartmentblService_Driver {
	public void drive(DepartmentblService service) {
		DepartmentVO department = service.getDepartInfo("0001000");
		System.out.println(department.getType());
		ResultMessage result1 = service.addCity(service.findCity("0001000"));
		System.out.println(result1.isSuccess());
		ResultMessage result2 = service.deleteDepartment("0000000");
		System.out.println(result2.isSuccess());
		ResultMessage result3 = service.updateDepartment(department);
		System.out.println(result3.isSuccess());
		ResultMessage result4 = service.addDepartment(department);
		System.out.println(result4.isSuccess());
	}
	
	public static void main(String[] args) {
//		DepartmentDataService service = new DepartmentDataImpl();
//		DepartmentblService departmentService = new DepartmentblImpl(service);
//		DepartmentblService_Driver driver = new DepartmentblService_Driver();
//		driver.drive(departmentService);
	}

}
