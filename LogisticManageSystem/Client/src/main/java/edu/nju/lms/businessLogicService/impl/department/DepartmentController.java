package edu.nju.lms.businessLogicService.impl.department;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogicService.DepartmentblService;
import edu.nju.lms.data.DepartmentType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.DepartmentDataService;

public class DepartmentController implements DepartmentblService{
	DepartmentDataService departService;
	DepartmentblImpl department;

	private String logID;
	
	public DepartmentController(){
		try {
			departService=(DepartmentDataService) Naming.lookup("//127.0.0.1:1099/DepartmentDataService");
			department=new DepartmentblImpl(departService);
		} catch (Exception e) {
			System.out.println("网络未连接！");
			System.exit(0);
		} 
	}
	public DepartmentController(String id){
		this.logID=id;
	}
	
	public DepartmentVO getDepartInfo(String id) {
		DepartmentVO result=department.getDepartInfo(id);

		return result;
	}

	public ResultMessage deleteDepartment(String id) {
		ResultMessage result=department.deleteDepartment(id);

		return result;
	}

	public ResultMessage updateDepartment(DepartmentVO Department) {
		ResultMessage result=department.updateDepartment(Department);

		return result;
	}

	public ResultMessage addDepartment(DepartmentVO Department) {
		ResultMessage result=department.addDepartment(Department);

		return result;
	}

	public ResultMessage addCity(CityVO city) {
		ResultMessage result=department.addCity(city);

		return result;
	}

	public CityVO findCity(String id) {
		CityVO result=department.findCity(id);

		return result;
	}
	
	public ResultMessage updateCity(CityVO city){
		ResultMessage result=department.updateCity(city);

		return result;
	}
}
