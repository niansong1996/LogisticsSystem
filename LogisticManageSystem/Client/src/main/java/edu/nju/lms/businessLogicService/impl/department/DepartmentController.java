package edu.nju.lms.businessLogicService.impl.department;

import java.rmi.Naming;

import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogicService.DepartmentblService;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.DepartmentDataService;

public class DepartmentController implements DepartmentblService{
	DepartmentDataService departService;
	DepartmentblImpl department;
//	LogController logController;
//	
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//	String time="";
//	OperationVO op=null;
	private String logID;
	
	public DepartmentController(){
		try {
			departService=(DepartmentDataService) Naming.lookup("//127.0.0.1:1099/DepartmentDataService");
			department=new DepartmentblImpl(departService);
			//logController=new LogController();
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
//		if(result.getDepartmentNum()!=null){
//			time = sdf.format(new Date());
//			op=new OperationVO(time,logID,"查询机构"+id+"的信息");
//			logController.addLog(op);
//		}
		return result;
	}

	public ResultMessage deleteDepartment(String id) {
		ResultMessage result=department.deleteDepartment(id);
//		if(result.isSuccess()){
//			time=sdf.format(new Date());
//			op=new OperationVO(time,logID,"删除机构"+id+"的信息");
//			logController.addLog(op);
//		}
		return result;
	}

	public ResultMessage updateDepartment(DepartmentVO Department) {
		ResultMessage result=department.updateDepartment(Department);
//		if(result.isSuccess()){
//			time=sdf.format(new Date());
//			op=new OperationVO(time,logID,"更新机构"+Department.getDepartmentNum()+"的信息");
//			logController.addLog(op);
//		}
		return result;
	}

	public ResultMessage addDepartment(DepartmentVO Department) {
		ResultMessage result=department.addDepartment(Department);
//		if(result.isSuccess()){
//			time=sdf.format(new Date());
//			op=new OperationVO(time,logID,"增加机构"+Department.getDepartmentNum()+"的信息");
//			logController.addLog(op);
//		}
		return result;
	}

	public ResultMessage addCity(CityVO city) {
		ResultMessage result=department.addCity(city);
//		if(result.isSuccess()){
//			time=sdf.format(new Date());
//			op=new OperationVO(time,logID,"增加城市"+city.getId()+"的信息");
//			logController.addLog(op);
//		}
		return result;
	}

	public CityVO findCity(String id) {
		CityVO result=department.findCity(id);
//		if(result.getId()!=null){
//			time=sdf.format(new Date());
//			op=new OperationVO(time,logID,"查询城市"+id+"的信息");
//			logController.addLog(op);
//		}
		return result;
	}
}
