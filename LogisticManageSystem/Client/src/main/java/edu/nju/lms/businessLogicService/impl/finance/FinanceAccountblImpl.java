package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.InitialInforPO;
import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.InitialInfoVO;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinanceAccountblImpl{
	private FinanceAccountDataService service;
	CommonUtility getTime=new CommonUtility();
	
	public FinanceAccountblImpl(FinanceAccountDataService service){
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
			// TODO
		}
		return result;
	}

	public AccountVO showAccount(String id) {
		AccountVO result=null;
		AccountPO accountPO=null;
		try {
			accountPO=service.findAccount(id);
		} catch (RemoteException e) {
			// TODO 
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
			// TODO
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
			// TODO
		}
		return result;
	}
	
	public ArrayList<AccountVO> showAllAccount() {
		ArrayList<AccountVO> result=new ArrayList<AccountVO>();
		ArrayList<AccountPO> po=null;
		try {
			po=service.showAllAccount();
		} catch (RemoteException e) {
			// TODO
		}
		if(po!=null){
			for(AccountPO temp : po){
				AccountVO vo=new AccountVO(temp.getName(),temp.getAmount());
				result.add(vo);
			}
		}
		return result;
	}
	
	public ResultMessage addInitialInfo(InitialInfoVO initial) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		initial.setDate(getTime.getTime());
		InitialInforPO po=new InitialInforPO(getTime.String2Cal(initial.getDate()),initial.getDepartments(),
				initial.getPersonnel(),initial.getCars(),initial.getWarehouses(),initial.getAccounts());
		try {
			result=service.addInitialInfo(po);
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public ResultMessage initialInfo() {
		ResultMessage result=new ResultMessage(false,"");
		FinanceBuildInitial initial=new FinanceBuildInitial();
		InitialInfoVO vo=new InitialInfoVO("",initial.getDepartments(),initial.getPersonnel(),
				initial.getCars(),initial.getWarehouse(),initial.getAccounts());
		result=addInitialInfo(vo);
		return result;
	}

	public ArrayList<InitialInfoVO> findInitialInfo() {
		ArrayList<InitialInfoVO> result=new ArrayList<InitialInfoVO>();
		ArrayList<InitialInforPO> po=null;
		try {
			po=service.findInitialInfo();
		} catch (RemoteException e) {
			// TODO
		}
		if(po!=null){
			for(InitialInforPO temp : po){
				InitialInfoVO vo=new InitialInfoVO(getTime.Cal2String(temp.getDate()),temp.getDepartments(),
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
