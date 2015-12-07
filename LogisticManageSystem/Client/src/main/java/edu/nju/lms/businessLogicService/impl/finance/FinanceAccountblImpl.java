package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.InitialInfoPO;
import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.InitialInfoVO;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinanceAccountblImpl{
	private FinanceAccountDataService service;
	PersonnelController personnelController;
	TransportController transportController;
	DepartmentController departmentController;
	//WarehouseController warehouseController;
	
	public FinanceAccountblImpl(DepartmentController departmentController,PersonnelController personnelController,TransportController transportController,FinanceAccountDataService service){
		this.personnelController=personnelController;
		this.departmentController=departmentController;
		this.transportController=transportController;
		//this.warehouseController=warehouseController;
		this.service=service;
	}

	public ResultMessage addAccount(AccountVO account) {
		ResultMessage result=idCheck(account.getID());
		if(!result.isSuccess()){
			return result;
		} 
		result=new ResultMessage(false,"网络未连接");
		AccountPO accountPO=new AccountPO(account.getID(),account.getAmount());
		try {
			result=service.addAccount(accountPO);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public AccountVO showAccount(String id) {
		AccountVO result=null;
		AccountPO accountPO=null;
		try {
			accountPO=service.findAccount(id);
		} catch (RemoteException e) {
			return result;
		}
		if(accountPO!=null){
			result=new AccountVO(accountPO.getName(),accountPO.getAmount());
		}
		return result;
	}

	public ResultMessage deleteAccount(String id) {
		ResultMessage result=idCheck(id);
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		try {
			result=service.deleteAccount(id);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public ResultMessage updateAccount(AccountVO account){
		ResultMessage result=idCheck(account.getID());
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		AccountPO accountPO=new AccountPO(account.getID(),account.getAmount());
		try {
			result=service.updateAccount(accountPO);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}
	
	public ArrayList<AccountVO> showAllAccount() {
		ArrayList<AccountVO> result=new ArrayList<AccountVO>();
		ArrayList<AccountPO> po=null;
		try {
			po=service.showAllAccount();
		} catch (RemoteException e) {
			return result;
		}
		if(po!=null){
			for(AccountPO temp : po){
				AccountVO vo=new AccountVO(temp.getName(),temp.getAmount());
				result.add(vo);
			}
		}
		return result;
	}
	
	public ResultMessage addMoney(String accountNum,double money) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		AccountPO account=null;
		try {
			account=service.findAccount(accountNum);
		} catch (RemoteException e) {
			return result;
		}
		if(account==null){
			result=new ResultMessage(false,"未找到对应账户！");
			return result;
		}
		double currentMoney=account.getAmount();
		currentMoney+=money;
		account.setAmount(currentMoney);
		try {
			result=service.updateAccount(account);
		} catch (RemoteException e) {
		}
		return result;
	}
	
	public ResultMessage addInitialInfo(InitialInfoVO initial) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		initial.setDate(CommonUtility.getTime());
		InitialInfoPO po=new InitialInfoPO(CommonUtility.String2Cal(initial.getDate()),initial.getDepartments(),
				initial.getPersonnel(),initial.getCars(),initial.getWarehouses(),initial.getAccounts());
		try {
			result=service.addInitialInfo(po);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public ResultMessage initialInfo() {
		ResultMessage result=new ResultMessage(false,"");
		FinanceBuildInitial initial=new FinanceBuildInitial(departmentController,personnelController,transportController);
		InitialInfoVO vo=new InitialInfoVO("",initial.getDepartments(),initial.getPersonnel(),
				initial.getCars(),initial.getWarehouse(),initial.getAccounts());
		result=addInitialInfo(vo);
		return result;
	}

	public ArrayList<InitialInfoVO> findInitialInfo() {
		ArrayList<InitialInfoVO> result=new ArrayList<InitialInfoVO>();
		ArrayList<InitialInfoPO> po=null;
		try {
			po=service.findInitialInfo();
		} catch (RemoteException e) {
			return result;
		}
		if(po!=null){
			for(InitialInfoPO temp : po){
				InitialInfoVO vo=new InitialInfoVO(CommonUtility.Cal2String(temp.getDate()),temp.getDepartments(),
						temp.getPersonnel(),temp.getCars(),temp.getWarehouses(),temp.getAccounts());
				result.add(vo);
			}
		}
		return result;
	}
	
	public ResultMessage idCheck(String id){
		ResultMessage result=new ResultMessage(true,"");
		if(id.length()!=16){
			result.setSuccess(false);
			result.setErrorMessage("输入账户名称的位数不正确！");
		}
		return result;
	}

}
