package edu.nju.lms.businessLogicService.impl.department;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.DepartmentDataService;

/**
 *@author nians
 *@date 2015年12月09日
 */
public class DepartmentblImpl{

	public DepartmentblImpl() {
	}
	
	public DepartmentVO getDepartInfo(String id,DepartmentDataService service) {
		DepartmentPO departmentPO = null;
		try {
			departmentPO = service.findDepartment(id);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(departmentPO!=null) {
			return new DepartmentVO(departmentPO.getType(), departmentPO.getDepartmentNum(), departmentPO.getLocation());
		}else return null;
	}

	public ResultMessage deleteDepartment(String id,DepartmentDataService service) {
		ResultMessage message = idCheck(id);
		if(!message.isSuccess()){
			return message;
		}
		try {
			message=service.deleteDepartment(id);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return message;
	}

	public ResultMessage updateDepartment(DepartmentVO department,DepartmentDataService service) {
		ResultMessage message = idCheck(department.getDepartmentNum());
		if(!message.isSuccess()){
			return message;
		}
		CityPO city = null;
		DepartmentPO departmentPO = null;
		try {
			city = service.findCity(department.getLocation());
			if(city == null) {
				return new ResultMessage(false, "未找到城市");
			} else {
				departmentPO = new DepartmentPO(department.getType(), department.getDepartmentNum(), city.getId());
				message = service.updateDepartment(departmentPO);
			}
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return message;
	}

	public ResultMessage addDepartment(DepartmentVO department,DepartmentDataService service) {
		ResultMessage result=idCheck(department.getDepartmentNum());
		if(!result.isSuccess()){
			return result;
		}
		CityPO city = null;
		DepartmentPO departmentPO = null;
		try {
			city = service.findCity(department.getLocation());
			if(city == null) {
				return new ResultMessage(false, "未找到城市");
			} else {
				departmentPO = new DepartmentPO(department.getType(), 
						department.getDepartmentNum(), city.getId());
				result = service.addDepartment(departmentPO);
				//when add a businesshall,update the city info
				if(department.getType().toString().equals("BUSINESSHALL")){
					CityVO temp=new CityVO(city.getId(),city.getName(),city.getBusinessNums(),city.getDistance());
					temp.getBusinessNums().add(department.getDepartmentNum());
					updateCity(temp,service);
				}
			}
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public ArrayList<DepartmentVO> showAllDepartments(DepartmentDataService service) {
		ArrayList<DepartmentVO> result=new ArrayList<DepartmentVO>();
		ArrayList<DepartmentPO> po=null;
		try {
			po=service.showAllDepartments();
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			for(DepartmentPO department : po){
				DepartmentVO vo=new DepartmentVO(department.getType(),department.getDepartmentNum(),department.getLocation());
				result.add(vo);
			}
		}
		return result;
	}
	
	public ResultMessage addCity(CityVO city,DepartmentDataService service) {
		ResultMessage result=cityIdCheck(city.getId());
		if(!result.isSuccess()){
			return result;
		}
		CityPO cityPO=new CityPO(city.getId(),city.getName(),city.getBusinessNums(),city.getDistance());
		try {
			result=service.addCity(cityPO);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public CityVO findCity(String id,DepartmentDataService service) {
		CityPO cityPO=null;
		CityVO city=null;
		try {
			cityPO=service.findCity(id);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(cityPO!=null){
			city=new CityVO(cityPO.getId(),cityPO.getName(),cityPO.getBusinessNums(),cityPO.getDistance());
		}
		return city;
	}
	public ResultMessage deleteCity(String id,DepartmentDataService service){
		ResultMessage result=cityIdCheck(id);
		if(!result.isSuccess()){
			return result;
		}
		try {
			result=service.deleteCity(id);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}
	
	public ResultMessage updateCity(CityVO city,DepartmentDataService service){
		ResultMessage result=cityIdCheck(city.getId());
		if(!result.isSuccess()){
			return result;
		}
		CityPO cityPO=new CityPO(city.getId(),city.getName(),city.getBusinessNums(),city.getDistance());
		try {
			result=service.updateCity(cityPO);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}
	
	public ArrayList<CityVO> showAllCities(DepartmentDataService service){
		ArrayList<CityVO> result=new ArrayList<CityVO>();
		ArrayList<CityPO> po=null;
		try {
			po=service.showAllCities();
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			for(CityPO city : po){
				CityVO vo=new CityVO(city.getId(),city.getName(),city.getBusinessNums(),city.getDistance());
				result.add(vo);
			}
		}
		return result;
	}
	
	public ResultMessage idCheck(String id){
		ResultMessage result=new ResultMessage(true,"");
		if(id.length()!=6){
			result.setSuccess(false);
			result.setErrorMessage("输入机构的位数不正确！");
		}
		return result;
	}
	
	public ResultMessage cityIdCheck(String id){
		ResultMessage result=new ResultMessage(true,"");
		if(id.length()!=3){
			result.setSuccess(false);
			result.setErrorMessage("输入城市编号的位数不正确！");
		}
		return result;
	}
}
