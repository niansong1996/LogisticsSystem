package edu.nju.lms.businessLogicService.impl.finance;

import java.util.ArrayList;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.VO.WarehouseVO;
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
		try {
			finance=BusinessLogicFactory.getFinanceController();
		} catch (NoBusinessLogicException e) {
		}
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<AccountVO> temp=finance.showAllAccount();
		for(AccountVO vo : temp){
			result.add(vo.getID());
		}
		return result;
	}
	
	public ArrayList<String> getPersonnel(){
		try {
			personnel=BusinessLogicFactory.getPersonnelController();
		} catch (NoBusinessLogicException e) {
		}
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<PersonnelVO> temp=personnel.showAllPersonnel();
		for(PersonnelVO vo : temp){
			result.add(vo.getId());
		}
		return result;
	}
	
	public ArrayList<String> getCars(){
		try {
			transport=BusinessLogicFactory.getTransportController();
		} catch (NoBusinessLogicException e) {
		}
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<VehicleVO> temp=transport.showAllVehicle();
		for(VehicleVO vo : temp){
			result.add(vo.getVehicleNum());
		}
		return result;
	}
	
	
	public ArrayList<String> getWarehouse(){
		try {
			warehouse=BusinessLogicFactory.getWarehouseController();
		} catch (NoBusinessLogicException e) {
		}
		ArrayList<String> result=new ArrayList<String>();
//		ArrayList<WarehouseVO> temp=warehouse.showAllWarehouse();
//		for(WarehouseVO vo : temp){
//			result.add(vo.getId());
//		}
		return result;
	}
}
