package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.InitialInforPO;
import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.InitialInfoVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinanceAccountblImpl{
	private FinanceAccountDataService service;
	
	public FinanceAccountblImpl(FinanceAccountDataService service){
		this.service=service;
	}

	public ResultMessage addAccount(AccountVO account) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
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
		ResultMessage result=new ResultMessage(false,"网络未连接");
		try {
			result=service.deleteAccount(id);
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public ResultMessage updateAccount(AccountVO account){
		ResultMessage result=new ResultMessage(false,"网络未连接");
		AccountPO accountPO=new AccountPO(account.getID(),account.getAmount());
		try {
			result=service.updateAccount(accountPO);
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}
	
	public ResultMessage addInitialInfo(InitialInfoVO initial) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		//TODO
		return result;
	}

}
