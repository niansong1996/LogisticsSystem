package edu.nju.lms.businessLogicService.impl.personnel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.PersonnelDataService;

/**
 *@author oppalu
 *@date 2015/11/20
 */
public class PersonnelblImpl  {
	private PersonnelDataService service=null;
	
	public PersonnelblImpl(PersonnelDataService service){
		this.service=service;
	}
	/**
	 * can use both the person's id and his departmentNum to find his info
	 * @param id
	 * @return
	 */
	public ArrayList<PersonnelVO> findPersonInfo(String id) {
		ArrayList<PersonnelVO> result=new ArrayList<PersonnelVO>();
		if(id.length()==10){
			try {
				PersonnelPO personPO=service.findPersonnel(id);
				PersonnelVO person=new PersonnelVO(personPO.getId(),personPO.getName(),personPO.getDepartmentNum(),
						personPO.getDuty(),personPO.getSalary(),personPO.getPerTime(),personPO.getBonus());
				result.add(person);
			} catch (RemoteException e) {
				// TODO
			}
		}else if(id.length()==6){
			//TODO
		}
		
		return result;
	}

	public ResultMessage deletePersonnel(String id) {
		ResultMessage result=idCheck(id);
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		try {
			result=service.deletePersonnel(id);
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public ResultMessage updatePersonnel(PersonnelVO Personnel) {
		ResultMessage result=idCheck(Personnel.getId());
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		PersonnelPO personPO=null;
		personPO=new PersonnelPO(Personnel.getId(),Personnel.getName(),Personnel.getDepartmentNum(),
				Personnel.getDuty(),Personnel.getSalary(),Personnel.getPerTime(),Personnel.getBonus());
		try {
			result=service.updatePersonnel(personPO);
		} catch (RemoteException e) {
			// TODO 
		}
		return result;
	}

	public ResultMessage addPersonnel(PersonnelVO Personnel) {
		ResultMessage result=idCheck(Personnel.getId());
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		PersonnelPO personnelPO=new PersonnelPO(Personnel.getId(),Personnel.getName(),
				Personnel.getDepartmentNum(),Personnel.getDuty(),Personnel.getSalary(),
				Personnel.getPerTime(),Personnel.getBonus());
		try {
			result=service.addPersonnel(personnelPO);
		} catch (RemoteException e) {
		}
		return result;
	}

	public ResultMessage idCheck(String id){
		ResultMessage result=new ResultMessage(true,"");
		if(id.length()!=6&&id.length()!=10){
			result.setSuccess(false);
			result.setErrorMessage("输入的位数不正确！");
		}
		return result;
	}
}
