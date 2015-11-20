package edu.nju.lms.businessLogicService.impl.department;

import java.rmi.RemoteException;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DepartmentVO;
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
			e.printStackTrace();
		}
		if(departmentPO!=null) {
			result=new DepartmentVO(departmentPO.getType(), departmentPO.getDepartmentNum(), departmentPO.getLocation().getId());
		}
		return result;
	}

	public ResultMessage deleteDepartment(String id) {
		ResultMessage message = new ResultMessage(false, "网络未连接");
		try {
			message=service.deleteDepartment(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return message;
	}

	public ResultMessage updateDepartment(DepartmentVO department) {
		ResultMessage message = new ResultMessage(false, "网络未连接");
		CityPO city = null;
		DepartmentPO departmentPO = null;
		try {
			city = service.findCity(department.getLocation());
			if(city == null) {
				return new ResultMessage(false, "未找到城市");
			} else {
				departmentPO = new DepartmentPO(department.getType(), department.getDepartmentNum(), city);
				message = service.updateDepartment(departmentPO);
			}
		} catch (RemoteException e) {}
		return message;
	}

	public ResultMessage addDepartment(DepartmentVO department) {
		ResultMessage message = new ResultMessage(false, "网络未连接");
		CityPO city = null;
		DepartmentPO departmentPO = null;
		try {
			city = service.findCity(department.getLocation());
			if(city == null) {
				return new ResultMessage(false, "未找到城市");
			} else {
				departmentPO = new DepartmentPO(department.getType(), 
						department.getDepartmentNum(), city);
				message = service.addDepartment(departmentPO);
			}
		} catch (RemoteException e) {}
		return message;
	}

	public ResultMessage addCity(CityVO city) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		CityPO cityPO=new CityPO(city.getId(),city.getName(),city.getBusinessNums(),city.getDistance());
		try {
			result=service.addCity(cityPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public CityVO findCity(String id) {
		CityPO cityPO=null;
		CityVO city=new CityVO("","",null,null);
		try {
			cityPO=service.findCity(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(cityPO.getId()!=null){
			city=new CityVO(cityPO.getId(),cityPO.getName(),cityPO.getBusinessNums(),cityPO.getDistance());
		}
		return city;
	}

}
