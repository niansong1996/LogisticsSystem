package edu.nju.lms.businessLogicService.impl.department;

import java.util.ArrayList;

import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.DepartmentblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.utility.DataServiceFactory;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.DepartmentDataService;
/**
 * 
 * @author nians
 *
 */
public class DepartmentController implements DepartmentblService{
	DepartmentDataService departService;
	DepartmentblImpl department;

	LogController logController;

	public DepartmentController(){
		try {
			logController=BusinessLogicFactory.getLogController();
			departService=DataServiceFactory.getDepartmentDataService();
			department=new DepartmentblImpl();
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
	}
	public void reconnect(){
		try {
			logController=BusinessLogicFactory.getLogController();
			departService=DataServiceFactory.getDepartmentDataService();
			department=new DepartmentblImpl();
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
	}
	public DepartmentVO getDepartInfo(String id) {
		DepartmentVO result=department.getDepartInfo(id,departService); 
		logController.addLog("查看机构"+id+"的信息");
		return result;
	}

	public ResultMessage deleteDepartment(String id) {
		ResultMessage result=department.deleteDepartment(id,departService);

		if(result.isSuccess()){
			logController.addLog("删除机构"+id+"的信息");
		}

		return result;
	}

	public ResultMessage updateDepartment(DepartmentVO Department) {
		ResultMessage result=department.updateDepartment(Department,departService);

		if(result.isSuccess()){
			logController.addLog("更新机构"+Department.getDepartmentNum()+"的信息");
		}

		return result;
	}

	public ResultMessage addDepartment(DepartmentVO Department) {
		ResultMessage result=department.addDepartment(Department,departService);

		if(result.isSuccess()){
			logController.addLog("新增机构"+Department.getDepartmentNum()+"的信息");
		}

		return result;
	}

	public CityVO findCity(String id) {
		CityVO result=department.findCity(id,departService);

		logController.addLog("查看城市"+id+"的信息");

		return result;
	}

	public ResultMessage updateCity(CityVO city){
		ResultMessage result=department.updateCity(city,departService);

		if(result.isSuccess()){
			logController.addLog("更新城市"+city.getId()+"的信息");
		}

		return result;
	}

	public ResultMessage deleteCity(String id) {
		ResultMessage result=department.deleteCity(id,departService);

		if(result.isSuccess()){
			logController.addLog("删除城市"+id+"的信息");
		}

		return result;
	}

	public ArrayList<CityVO> showAllCities(){
		ArrayList<CityVO> result=department.showAllCities(departService);

		logController.addLog("查看所有城市的信息");

		return result;
	}

	public ArrayList<DepartmentVO> showAllDepartments() {
		ArrayList<DepartmentVO> result=department.showAllDepartments(departService);
		logController.addLog("查看所有机构的信息");
		return result;
	}

}
