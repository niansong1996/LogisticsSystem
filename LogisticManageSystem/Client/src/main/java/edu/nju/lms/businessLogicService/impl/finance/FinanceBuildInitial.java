package edu.nju.lms.businessLogicService.impl.finance;

import java.util.ArrayList;

import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;

public class FinanceBuildInitial {
	
	public FinanceBuildInitial(){
	}
	
	public ArrayList<String> getDepartments(DepartmentController departmentController){
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<DepartmentVO> temp=departmentController.showAllDepartments();
		if(temp!=null){
			for(DepartmentVO vo : temp){
				result.add(vo.getDepartmentNum());
			}
		}		
		return result;
	}
	
	public ArrayList<String> getPersonnel(PersonnelController personnelController){
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<PersonnelVO> temp=personnelController.showAllPersonnel();
		if(temp!=null){
			for(PersonnelVO vo : temp){
				result.add(vo.getId());
			}
		}
		return result;
	}
	
	public ArrayList<String> getCars(TransportController transportController){
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<VehicleVO> temp=transportController.showAllVehicle();
		if(temp!=null){
			for(VehicleVO vo : temp){
				result.add(vo.getVehicleNum());
			}
		}
		return result;
	}
	
	
	public ArrayList<String> getWarehouse(DepartmentController departmentController){
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
