package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.PO.InitialInforPO;
import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.PO.WarehousePO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;

public class FinanceAccountDataImpl implements FinanceAccountDataService{
	
	
	private ArrayList<InitialInforPO> initialInforList = new ArrayList<InitialInforPO>();
	private ArrayList<AccountPO> accountList=new ArrayList<AccountPO>();

	public FinanceAccountDataImpl(){
		
	}
	
	//TODO
	public ResultMessage addInitialInfo(InitialInforPO InitialInfo) throws RemoteException {
		ArrayList<DepartmentPO> departments=new ArrayList<DepartmentPO>();
		ArrayList<PersonnelPO> personnel=new ArrayList<PersonnelPO>();
		ArrayList<String> cars=new ArrayList<String>();
		ArrayList<WarehousePO> warehouses=new ArrayList<WarehousePO>();
		ArrayList<AccountPO> accounts=new ArrayList<AccountPO>();
		InitialInforPO po=new InitialInforPO(departments,personnel,cars,warehouses,accounts);
		
		return new ResultMessage(true,"");
	}

	public ResultMessage addAccount(AccountPO Account) throws RemoteException {
		if(findAccount(Account.getName())==null){
			this.accountList.add(Account);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The account already exists!");
		}

	}

	public AccountPO findAccount(String id) throws RemoteException {
		AccountPO result = null;
		Iterator<AccountPO> it = accountList.iterator();
		while(it.hasNext()){
			AccountPO next = it.next();
			if(next.getName()==id){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteAccount(String id) throws RemoteException {
		AccountPO Account = findAccount(id);
		if(!(Account==null)){
			accountList.remove(Account);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the account!");
		}
	}

	public ResultMessage updateAccount(AccountPO Account) throws RemoteException {
		AccountPO tempAccount = findAccount(Account.getName());
		if(tempAccount!=null){
			accountList.remove(findAccount(Account.getName()));
			accountList.add(Account);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the account!");
		}
	}

}
