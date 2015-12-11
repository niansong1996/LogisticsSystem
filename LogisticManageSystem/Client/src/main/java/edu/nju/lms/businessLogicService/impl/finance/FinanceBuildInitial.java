package edu.nju.lms.businessLogicService.impl.finance;

import java.util.ArrayList;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;

public class FinanceBuildInitial {
	private DepartmentController departmentController;
	private FinanceController financeController;
	private PersonnelController personnelController;
	private TransportController transportController;
	
	public FinanceBuildInitial(DepartmentController departmentController,PersonnelController personnelController,TransportController transportController){
		this.departmentController=departmentController;
		this.personnelController=personnelController;
		this.transportController=transportController;
		try {
			financeController=BusinessLogicFactory.getFinanceController();
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getDepartments(){
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<DepartmentVO> temp=departmentController.showAllDepartments();
		if(temp!=null){
			for(DepartmentVO vo : temp){
				result.add(vo.getDepartmentNum());
			}
		}		
		return result;
	}
	
	public ArrayList<String> getAccounts(){
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<AccountVO> temp=financeController.showAllAccount();
		if(temp!=null){
			for(AccountVO vo : temp){
				result.add(vo.getID());
			}
		}
		return result;
	}
	
	public ArrayList<String> getPersonnel(){
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<PersonnelVO> temp=personnelController.showAllPersonnel();
		if(temp!=null){
			for(PersonnelVO vo : temp){
				result.add(vo.getId());
			}
		}
		return result;
	}
	
	public ArrayList<String> getCars(){
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<VehicleVO> temp=transportController.showAllVehicle();
		if(temp!=null){
			for(VehicleVO vo : temp){
				result.add(vo.getVehicleNum());
			}
		}
		return result;
	}
	
	
	public ArrayList<String> getWarehouse(){
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<DepartmentVO> temp=departmentController.showAllDepartments();
		if(temp!=null){
			for(DepartmentVO vo : temp){
				if(vo.getType().toString().equals("TRANSITCENTER"))
					result.add(vo.getDepartmentNum());
			}
		}
		return result;
	}
}
