package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;

public class FinanceMoneyblImpl{
	private FinanceAccountDataService service;
	
	public FinanceMoneyblImpl(FinanceAccountDataService service){
		this.service=service;
	}

	public ResultMessage payMoney(String accountNum,double money) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		AccountPO account=null;
		try {
			account=service.findAccount(accountNum);
		} catch (RemoteException e) {
			// TODO
		}
		if(account==null){
			result=new ResultMessage(false,"未找到对应账户！");
			return result;
		}
		double currentMoney=account.getAmount();
		currentMoney-=money;
		account.setAmount(currentMoney);
		try {
			result=service.updateAccount(account);
		} catch (RemoteException e) {
			//TODO
		}
		return result;
	}

	public ResultMessage addMoney(String accountNum,double money) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		AccountPO account=null;
		try {
			account=service.findAccount(accountNum);
		} catch (RemoteException e) {
			// TODO
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
			//TODO
		}
		return result;
	}

}
