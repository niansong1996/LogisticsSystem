package edu.nju.lms.businessLogicService.impl.finance;

import java.util.ArrayList;

import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;

public class FinanceBuildInitial {
	private DepartmentController department;
	private FinanceController finance;
	private PersonnelController personnel;
	private TransportController transport;
	private WarehouseController warehouse;
	
	public ArrayList<String> getDepartments(){
		try {
			department=BusinessLogicFactory.getDepartmentController();
		} catch (NoBusinessLogicException e) {
		}
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<DepartmentVO> temp=department.showAllDepartments();
		for(DepartmentVO vo : temp){
			result.add(vo.getDepartmentNum());
		}
		return result;
	}
	
	public ArrayList<String> getAccounts(){
		return null;
	}
	
	public ArrayList<String> getPersonnel(){
		return null;
	}
	
	public ArrayList<String> getCars(){
		return null;
	}
	
	
	public ArrayList<String> getWarehouse(){
		return null;
	}
}
