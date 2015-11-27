package edu.nju.lms.businessLogicService.impl.department;

import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.DepartmentblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.DepartmentDataService;

public class DepartmentController implements DepartmentblService{
	DepartmentDataService departService;
	DepartmentblImpl department;
	
	LogController logController;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
	String time="";
	private String logID;
	
	public DepartmentController(){
		try {
			departService=(DepartmentDataService) Naming.lookup("//127.0.0.1:1099/DepartmentDataService");
			department=new DepartmentblImpl(departService);
		} catch (Exception e) {
			System.out.println("网络未连接！");
			System.exit(0);
		} 
	}
	public DepartmentController(String id){
		this.logID=id;
	}
	
	public DepartmentVO getDepartInfo(String id) {
		DepartmentVO result=department.getDepartInfo(id); 

		time=sdf.format(new Date());
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		OperationVO op=new OperationVO(time,logID,"查看机构"+id+"的信息");
		logController.addLog(op);
		
		return result;
	}

	public ResultMessage deleteDepartment(String id) {
		ResultMessage result=department.deleteDepartment(id);

		if(result.isSuccess()){
			time=sdf.format(new Date());
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			OperationVO op=new OperationVO(time,logID,"删除机构"+id+"的信息");
			logController.addLog(op);
		}
		
		return result;
	}

	public ResultMessage updateDepartment(DepartmentVO Department) {
		ResultMessage result=department.updateDepartment(Department);

		if(result.isSuccess()){
			time=sdf.format(new Date());
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			OperationVO op=new OperationVO(time,logID,"更新机构"+Department.getDepartmentNum()+"的信息");
			logController.addLog(op);
		}
		
		return result;
	}

	public ResultMessage addDepartment(DepartmentVO Department) {
		ResultMessage result=department.addDepartment(Department);

		if(result.isSuccess()){
			time=sdf.format(new Date());
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			OperationVO op=new OperationVO(time,logID,"新增机构"+Department.getDepartmentNum()+"的信息");
			logController.addLog(op);
		}
		
		return result;
	}

	public ResultMessage addCity(CityVO city) {
		ResultMessage result=department.addCity(city);

		if(result.isSuccess()){
			time=sdf.format(new Date());
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			OperationVO op=new OperationVO(time,logID,"新增城市"+city.getId()+"的信息");
			logController.addLog(op);
		}
		
		return result;
	}

	public CityVO findCity(String id) {
		CityVO result=department.findCity(id);

		time=sdf.format(new Date());
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		OperationVO op=new OperationVO(time,logID,"查看城市"+id+"的信息");
		logController.addLog(op);
		
		return result;
	}
	
	public ResultMessage updateCity(CityVO city){
		ResultMessage result=department.updateCity(city);

		if(result.isSuccess()){
			time=sdf.format(new Date());
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			OperationVO op=new OperationVO(time,logID,"更新城市"+city.getId()+"的信息");
			logController.addLog(op);
		}
		
		return result;
	}
	
	public ResultMessage deleteCity(String id) {
		ResultMessage result=department.deleteCity(id);
		
		if(result.isSuccess()){
			time=sdf.format(new Date());
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			OperationVO op=new OperationVO(time,logID,"删除城市"+id+"的信息");
			logController.addLog(op);
		}
		
		return result;
	}
	
	public ArrayList<CityVO> showAllCities(){
		ArrayList<CityVO> result=department.showAllCities();
		
		time=sdf.format(new Date());
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		OperationVO op=new OperationVO(time,logID,"查看所有城市的信息");
		logController.addLog(op);
		
		return result;
	}
	public String getLogID() {
		return logID;
	}
	public void setLogID(String logID) {
		this.logID = logID;
	}
	
}
