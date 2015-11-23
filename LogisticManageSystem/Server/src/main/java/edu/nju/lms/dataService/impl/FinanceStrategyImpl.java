package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;

import edu.nju.lms.PO.PriceStrategyPO;
import edu.nju.lms.PO.SalaryStrategyPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceStrategyDataService;

public class FinanceStrategyImpl implements FinanceStrategyDataService{
	PriceStrategyPO priceStrategy;
	SalaryStrategyPO salaryStrategy;


	public FinanceStrategyImpl(){

	}

	public ResultMessage addPriceStrategy(PriceStrategyPO PriceStrategy)
			throws RemoteException {
		if(this.priceStrategy==null){
			this.priceStrategy = PriceStrategy;
			return new ResultMessage(true,null);
		}
		else
			return new ResultMessage(true,"The price strategy already exists");
	}

	public PriceStrategyPO findPriceStrategy() throws RemoteException {
		return this.priceStrategy;
	}

	public ResultMessage deletePriceStrategy() throws RemoteException {
		if(this.priceStrategy==null) return new ResultMessage(false,"Counld not find th price strategy!");
		this.priceStrategy = null;
		return new ResultMessage(true,null);
	}

	public ResultMessage updatePriceStrategy(PriceStrategyPO PriceStrategy)
			throws RemoteException {
		if(this.priceStrategy==null) return new ResultMessage(false,"Counld not find th price strategy!");
		this.priceStrategy = PriceStrategy;
		return new ResultMessage(true,null);
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyPO SalaryStrategy)
			throws RemoteException {
		if(this.salaryStrategy==null){
			this.salaryStrategy = SalaryStrategy;
			return new ResultMessage(true,null);
		}
		else
			return new ResultMessage(true,"The salary strategy already exists");
	}

	public SalaryStrategyPO findSalaryStrategy(PersonType type) throws RemoteException {
		return this.salaryStrategy;
	}

	public ResultMessage deleteSalaryStrategy() throws RemoteException {
		if(this.salaryStrategy==null) return new ResultMessage(false,"Counld not find th salary strategy!");
		this.salaryStrategy = null;
		return new ResultMessage(true,null);
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyPO SalaryStrategy)
			throws RemoteException {
		if(this.salaryStrategy==null) return new ResultMessage(false,"Counld not find th salary strategy!");
		this.salaryStrategy = SalaryStrategy;
		return new ResultMessage(true,null);
	}

}
