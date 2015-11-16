package edu.nju.lms.businessLogicService.impl.department;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogicService.DepartmentblService;
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
		DepartmentPO department = null;
		DepartmentVO vo = null;
		try {
			department = service.findDepartment(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(department!=null) {
			vo = new DepartmentVO(department.getType(), 
					department.getDepartmentNum(), department.getLocation().getName());
		}
		return vo;
	}

	public ResultMessage deleteDepartment(String id) {
		ResultMessage message = new ResultMessage(false, "网络未连接");
		try {
			message = service.deleteCity(id);
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
				departmentPO = new DepartmentPO(department.getType(), 
						department.getDepartmentNum(), city);
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
		return new ResultMessage(true,null);
	}

	public CityVO findCity(String id) {
		ArrayList<String> businessNums = new ArrayList<String>();
		businessNums.add("025457");
		return new CityVO(id,"XuZhou",businessNums,null);
	}

}
