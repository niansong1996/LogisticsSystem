package edu.nju.lms.businessLogicService.impl.department;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.data.DepartmentType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.DepartmentDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class DepartmentblImpl{
	DepartmentDataService service = null;

	public DepartmentblImpl(DepartmentDataService service) {
		this.service = service;
	}
	
	public DepartmentVO getDepartInfo(String id) {
		DepartmentPO departmentPO = null;
		DepartmentVO result=new DepartmentVO(null,"","");
		try {
			departmentPO = service.findDepartment(id);
		} catch (RemoteException e) {
			//TODO
		}
		if(departmentPO!=null) {
			result=new DepartmentVO(departmentPO.getType(), departmentPO.getDepartmentNum(), departmentPO.getLocation());
		}
		return result;
	}

	public ResultMessage deleteDepartment(String id) {
		ResultMessage message = idCheck(id);
		if(!message.isSuccess()){
			return message;
		}
		message = new ResultMessage(false, "网络未连接");
		try {
			message=service.deleteDepartment(id);
		} catch (RemoteException e) {
			//TODO
		}
		return message;
	}

	public ResultMessage updateDepartment(DepartmentVO department) {
		ResultMessage message = idCheck(department.getDepartmentNum(),department.getType());
		if(!message.isSuccess()){
			return message;
		}
		message = new ResultMessage(false, "网络未连接");
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
			//TODO
		}
		return message;
	}

	public ResultMessage addDepartment(DepartmentVO department) {
		ResultMessage result=idCheck(department.getDepartmentNum(),department.getType());
		if(!result.isSuccess()){
			return result;
		}
		result = new ResultMessage(false, "网络未连接");
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
				if(department.getType().equals("BUSINESSHALL")){
					CityVO temp=new CityVO(city.getId(),city.getName(),city.getBusinessNums(),city.getDistance());
					temp.getBusinessNums().add(department.getDepartmentNum());
					updateCity(temp);
				}
			}
		} catch (RemoteException e) {
			//TODO
		}
		return result;
	}

	public ResultMessage addCity(CityVO city) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		CityPO cityPO=new CityPO(city.getId(),city.getName(),city.getBusinessNums(),city.getDistance());
		try {
			result=service.addCity(cityPO);
		} catch (RemoteException e) {
			//TODO
		}
		return result;
	}

	public CityVO findCity(String id) {
		CityPO cityPO=null;
		CityVO city=new CityVO("","",null,null);
		try {
			cityPO=service.findCity(id);
		} catch (RemoteException e) {
			//TODO
		}
		if(cityPO!=null){
			city=new CityVO(cityPO.getId(),cityPO.getName(),cityPO.getBusinessNums(),cityPO.getDistance());
		}
		return city;
	}

	public ResultMessage updateCity(CityVO city){
		ResultMessage result=new ResultMessage(false,"网络未连接");
		CityPO cityPO=new CityPO(city.getId(),city.getName(),city.getBusinessNums(),city.getDistance());
		try {
			result=service.updateCity(cityPO);
		} catch (RemoteException e) {
			//TODO
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
	public ResultMessage idCheck(String id,DepartmentType type){
		ResultMessage result=new ResultMessage(true,"");
		if(id.length()!=6){
			result.setSuccess(false);
			result.setErrorMessage("输入机构的位数不正确！");
			return result;
		}
		if(id.charAt(3)=='0'&&!(type.equals("TRANSITCENTER"))){
			result.setSuccess(false);
			result.setErrorMessage("输入机构编号与类型不符！");
		}
		if(id.charAt(3)=='1'&&!(type.equals("BUSINESSHALL"))){
			result.setSuccess(false);
			result.setErrorMessage("输入机构编号与类型不符！");
		}
		return result;
	}
}
