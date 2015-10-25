package edu.nju.lms.businessLogicService;

import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public interface DepartmentblService {
	
	public DepartmentVO getDepartInfo(String id);
	
	public ResultMessage deleteDepartment(String id);
	
	public ResultMessage updateDepartment(DepartmentVO Department);
	
	public ResultMessage addDepartment(DepartmentVO Department);
	
	public ResultMessage addCity(CityVO city);
	
	public CityVO findCity(String id);
	
	
}