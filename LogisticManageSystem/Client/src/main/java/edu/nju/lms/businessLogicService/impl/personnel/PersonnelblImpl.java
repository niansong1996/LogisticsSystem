package edu.nju.lms.businessLogicService.impl.personnel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.data.PersonType;
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
				if(personPO!=null){
					PersonnelVO person=new PersonnelVO(personPO.getId(),personPO.getName(),personPO.getDepartmentNum(),
							changeToVO(personPO.getDuty()),personPO.getSalary(),personPO.getPerTime(),personPO.getBonus());
					result.add(person);
				}
			} catch (RemoteException e) {
				// TODO
			}
		}else{
			try {
				ArrayList<PersonnelPO> po=service.ambiFindPersonnel(id);
				if(po.size()!=0){
					for(PersonnelPO temp : po){
						PersonnelVO person=new PersonnelVO(temp.getId(),temp.getName(),temp.getDepartmentNum(),
								changeToVO(temp.getDuty()),temp.getSalary(),temp.getPerTime(),temp.getBonus());
						result.add(person);
					}
				}
			} catch (RemoteException e) {
				// TODO
			}
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
				changeToPO(Personnel.getDuty()),Personnel.getSalary(),Personnel.getPerTime(),Personnel.getBonus());
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
				Personnel.getDepartmentNum(),changeToPO(Personnel.getDuty()),Personnel.getSalary(),
				Personnel.getPerTime(),Personnel.getBonus());
		try {
			result=service.addPersonnel(personnelPO);
		} catch (RemoteException e) {
		}
		return result;
	}
	
	public ArrayList<PersonnelVO> showAllPersonnel() {
		ArrayList<PersonnelVO> result=new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> po=null;
		
		try {
			po=service.showAllPersonnel();
		} catch (RemoteException e) {
			// TODO
		}
		if(po!=null){
			for(PersonnelPO person : po){
				PersonnelVO vo=new PersonnelVO(person.getId(),person.getName(),person.getDepartmentNum(),
						person.getDuty().toString(),person.getSalary(),person.getPerTime(),person.getBonus());
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
	
	public PersonType changeToPO(String duty){
		if(duty.equals("管理员")){
			return PersonType.ADMINISTRATOR;
		}else if(duty.equals("总经理")){
			return PersonType.MANAGER;
		}else if(duty.equals("普通财务人员")){
			return PersonType.FINANCIAL_NORMAL;
		}else if(duty.equals("高级财务人员")){
			return PersonType.FINANCIAL_ADVANCED;
		}else if(duty.equals("中转中心仓库管理人员")){
			return PersonType.WAREHOUSE;
		}else if(duty.equals("中转中心业务员")){
			return PersonType.COUNTER_INTERMEDIATE;
		}else if(duty.equals("营业厅业务员")){
			return PersonType.COUNTER_BUSSINESS;
		}else if(duty.equals("快递员")){
			return PersonType.COURIER;
		}else{
			return PersonType.DRIVER;
		}
	}
	public String changeToVO(PersonType duty){
		switch(duty){
		case ADMINISTRATOR:
			return "管理员";
		case MANAGER:
			return "总经理";
		case FINANCIAL_NORMAL:
			return "普通财务人员";
		case FINANCIAL_ADVANCED:
			return "高级财务人员";
		case WAREHOUSE:
			return "中转中心仓库管理人员";
		case COUNTER_INTERMEDIATE:
			return "中转中心业务员";
		case COUNTER_BUSSINESS:
			return "营业厅业务员";
		case COURIER:
			return "快递员";
		case DRIVER:
			return "司机";
		}
		return null;
	}
}
