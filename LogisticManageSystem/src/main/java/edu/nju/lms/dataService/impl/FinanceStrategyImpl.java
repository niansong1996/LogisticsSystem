package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;

import edu.nju.lms.PO.PriceStrategyPO;
import edu.nju.lms.PO.SalaryStrategyPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceStrategy;

public class FinanceStrategyImpl implements FinanceStrategy{

	public ResultMessage addPriceStrategy(PriceStrategyPO PriceStrategy)
			throws RemoteException {
		
		return new ResultMessage(true,"");
	}

	public PriceStrategyPO findPriceStrategy() throws RemoteException {
		
		PriceStrategyPO po=new PriceStrategyPO(250.0);
		return null;
	}

	public ResultMessage deletePriceStrategy() throws RemoteException {
		
		return new ResultMessage(true,"");
	}

	public ResultMessage updatePriceStrategy(PriceStrategyPO PriceStrategy)
			throws RemoteException {
		
		return new ResultMessage(true,"");
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyPO SalaryStrategy)
			throws RemoteException {
		
		return new ResultMessage(true,"");
	}

	public SalaryStrategyPO findSalaryStrategy() throws RemoteException {
		
		SalaryStrategyPO po=new SalaryStrategyPO(PersonType.MANAGER,10000.0,10,8000.0);
		return null;
	}

	public ResultMessage deleteSalaryStrategy() throws RemoteException {
		
		return new ResultMessage(true,"");
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyPO SalaryStrategy)
			throws RemoteException {
	
		return new ResultMessage(true,"");
	}

}
