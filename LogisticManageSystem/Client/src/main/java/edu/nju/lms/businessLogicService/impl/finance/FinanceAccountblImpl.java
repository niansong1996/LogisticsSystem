package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.InitialInfoPO;
import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.InitialInfoVO;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinanceAccountblImpl{
	
	public FinanceAccountblImpl(){
	}

	public ResultMessage addAccount(AccountVO account,FinanceAccountDataService service) {
		ResultMessage result=idCheck(account.getID());
		if(!result.isSuccess()){
			return result;
		} 
		AccountPO accountPO=new AccountPO(account.getID(),account.getAmount());
		try {
			result=service.addAccount(accountPO);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public AccountVO showAccount(String id,FinanceAccountDataService service) {
		AccountVO result=null;
		AccountPO accountPO=null;
		try {
			accountPO=service.findAccount(id);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(accountPO!=null){
			result=new AccountVO(accountPO.getName(),accountPO.getAmount());
		}
		return result;
	}

	public ResultMessage deleteAccount(String id,FinanceAccountDataService service) {
		ResultMessage result=idCheck(id);
		if(!result.isSuccess()){
			return result;
		}
		try {
			result=service.deleteAccount(id);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public ResultMessage updateAccount(AccountVO account,FinanceAccountDataService service){
		ResultMessage result=idCheck(account.getID());
		if(!result.isSuccess()){
			return result;
		}
		AccountPO accountPO=new AccountPO(account.getID(),account.getAmount());
		try {
			result=service.updateAccount(accountPO);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}
	
	public ArrayList<AccountVO> showAllAccount(FinanceAccountDataService service) {
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
	
	public ResultMessage addMoney(String accountNum,double money,FinanceAccountDataService service) {
		AccountPO account=null;
		try {
			account=service.findAccount(accountNum);
		if(account==null){
			return new ResultMessage(false,"未找到对应账户！");
		}
		double currentMoney=account.getAmount();
		currentMoney+=money;
		account.setAmount(currentMoney);

			return service.updateAccount(account);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
	}
	
	public ResultMessage addInitialInfo(InitialInfoVO initial,FinanceAccountDataService service) {
		initial.setDate(CommonUtility.getTime());
		InitialInfoPO po=new InitialInfoPO(CommonUtility.String2Cal(initial.getDate()),initial.getDepartments(),
				initial.getPersonnel(),initial.getCars(),initial.getWarehouses(),initial.getAccounts());
		try {
			return service.addInitialInfo(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
	}
	
	
	public ArrayList<InitialInfoVO> findInitialInfo(FinanceAccountDataService service) {
		ArrayList<InitialInfoVO> result=new ArrayList<InitialInfoVO>();
		ArrayList<InitialInfoPO> po=null;
		try {
			po=service.findInitialInfo();
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
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
