package edu.nju.lms.businessLogicService.impl.personnel;

import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.PersonnelblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.PersonnelDataService;

/**
 *@author tj
 *@date 2015年11月16日
 */
public class PersonnelController implements PersonnelblService{
	PersonnelDataService personService;
	PersonnelblImpl personbl;

	LogController logController;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
	String time="";
	String logID="";
	
	public PersonnelController(){
		try {
			personService=(PersonnelDataService)Naming.lookup("//127.0.0.1:1099/PersonnelDataService");
			personbl=new PersonnelblImpl(personService);
		}catch (Exception e) {
			System.out.println("网络未连接！");
			System.exit(0);
		}
	}
	public PersonnelController(String id){
		this.logID=id;
	}
	
	public ArrayList<PersonnelVO> findPersonInfo(String id) {
		ArrayList<PersonnelVO> result=personbl.findPersonInfo(id);

		time=sdf.format(new Date());
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		OperationVO op=new OperationVO(time,logID,"查看员工"+id+"的信息");
		logController.addLog(op);
		
		return result;
	}

	public ResultMessage deletePersonnel(String id) {
		ResultMessage result=personbl.deletePersonnel(id);

		if(result.isSuccess()){
			time=sdf.format(new Date());
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			OperationVO op=new OperationVO(time,logID,"删除员工"+id+"的信息");
			logController.addLog(op);
		}
		
		return result;
	}

	public ResultMessage updatePersonnel(PersonnelVO Personnel) {
		ResultMessage result=personbl.updatePersonnel(Personnel);

		if(result.isSuccess()){
			time=sdf.format(new Date());
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			OperationVO op=new OperationVO(time,logID,"更新员工"+Personnel.getId()+"的信息");
			logController.addLog(op);
		}
		
		return result;
	}

	public ResultMessage addPersonnel(PersonnelVO Personnel) {
		ResultMessage result=personbl.addPersonnel(Personnel);

		if(result.isSuccess()){
			time=sdf.format(new Date());
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			OperationVO op=new OperationVO(time,logID,"新增员工"+Personnel.getId()+"的信息");
			logController.addLog(op);
		}
		
		return result;
	}
	public ResultMessage updatePerTimes(String id, double amount) {
		return personbl.updatePerTime(id, amount);
	}
	public String getLogID() {
		return logID;
	}
	public void setLogID(String logID) {
		this.logID = logID;
	}

}
