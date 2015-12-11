package edu.nju.lms.businessLogicService.impl.personnel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.PersonnelDataService;
import edu.nju.lms.presentation.components.EnumTransformer;

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
				if(personPO!=null){
					PersonnelVO person=new PersonnelVO(personPO.getId(),personPO.getName(),personPO.getDepartmentNum(),
							EnumTransformer.PersonType2Str(personPO.getDuty()),personPO.getSalary(),personPO.getPerTime(),personPO.getBonus());
					result.add(person);
				}
			} catch (RemoteException e) {
				RemoteExceptionHandler.handleRemoteException(e);
			}
		}else{
			try {
				ArrayList<PersonnelPO> po=service.ambiFindPersonnel(id);
				if(po.size()!=0){
					for(PersonnelPO temp : po){
						PersonnelVO person=new PersonnelVO(temp.getId(),temp.getName(),temp.getDepartmentNum(),
								EnumTransformer.PersonType2Str(temp.getDuty()),temp.getSalary(),temp.getPerTime(),temp.getBonus());
						result.add(person);
					}
				}
			} catch (RemoteException e) {
				RemoteExceptionHandler.handleRemoteException(e);
			}
		}
		return result;
	}

	public ResultMessage deletePersonnel(String id) {
		ResultMessage result=idCheck(id);
		if(!result.isSuccess()){
			return result;
		}
		try {
			result=service.deletePersonnel(id);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public ResultMessage updatePersonnel(PersonnelVO Personnel) {
		ResultMessage result=idCheck(Personnel.getId());
		if(!result.isSuccess()){
			return result;
		}
		PersonnelPO personPO=null;
		personPO=new PersonnelPO(Personnel.getId(),Personnel.getName(),Personnel.getDepartmentNum(),
				EnumTransformer.str2PersonType(Personnel.getDuty()),Personnel.getSalary(),Personnel.getPerTime(),Personnel.getBonus());
		try {
			result=service.updatePersonnel(personPO);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public ResultMessage addPersonnel(PersonnelVO Personnel) {
		ResultMessage result=idCheck(Personnel.getId());
		if(!result.isSuccess()){
			return result;
		}
		PersonnelPO personnelPO=new PersonnelPO(Personnel.getId(),Personnel.getName(),
				Personnel.getDepartmentNum(),EnumTransformer.str2PersonType(Personnel.getDuty()),Personnel.getSalary(),
				Personnel.getPerTime(),Personnel.getBonus());
		try {
			result=service.addPersonnel(personnelPO);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}
	
	public ArrayList<PersonnelVO> showAllPersonnel() {
		ArrayList<PersonnelVO> result=new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> po=null;
		
		try {
			po=service.showAllPersonnel();
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			for(PersonnelPO person : po){
				PersonnelVO vo=new PersonnelVO(person.getId(),person.getName(),person.getDepartmentNum(),
						EnumTransformer.PersonType2Str(person.getDuty()),person.getSalary(),person.getPerTime(),person.getBonus());
				result.add(vo);
			}
		}
		return result;
	}

	public ResultMessage idCheck(String id){
		ResultMessage result=new ResultMessage(true,"");
		if(id.length()!=10){
			result.setSuccess(false);
			result.setErrorMessage("输入的位数不正确！");
		}
		return result;
	}

	public ResultMessage updatePerTime(String id,double amount){
		ResultMessage result=new ResultMessage(false,"");
		ArrayList<PersonnelVO> list=findPersonInfo(id);
		PersonnelVO temp=list.get(0);
		if(temp!=null){
			Double currentAmount=temp.getPerTime();
			amount+=currentAmount;
			temp.setPerTime(amount);
			result=updatePersonnel(temp);
		}
		return result;
	}
	
}
