package edu.nju.lms.businessLogicService.impl;

import java.util.ArrayList;

import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogicService.DepartmentblService;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class DepartmentblImpl implements DepartmentblService {
	

	public DepartmentVO getDepartInfo(String id) {
		// TODO Auto-generated method stub
		return new DepartmentVO("transit center","0000100", "NanJing");
	}

	public ResultMessage deleteDepartment(String id) {
		// TODO Auto-generated method stub
		return new ResultMessage(false, "Wrong format");
	}

	public ResultMessage updateDepartment(DepartmentVO Department) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ResultMessage addDepartment(DepartmentVO Department) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ResultMessage addCity(CityVO city) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public CityVO findCity(String id) {
		// TODO Auto-generated method stub
		return new CityVO(id,"XuZhou","025",new ArrayList<String>());
	}

}
