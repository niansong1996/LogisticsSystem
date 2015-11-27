package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.nju.lms.PO.PriceStrategyPO;
import edu.nju.lms.PO.SalaryStrategyPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.FinanceStrategyDataService;

public class FinanceStrategyDataImpl extends UnicastRemoteObject implements FinanceStrategyDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3796517921459190041L;


	public FinanceStrategyDataImpl() throws RemoteException{

	}
	
	public ResultMessage addPriceStrategy(PriceStrategyPO PriceStrategy)
			throws RemoteException {
		if(findPriceStrategy()==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(PriceStrategy, PriceStrategy.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The price strategy already exists!");
		}
	}

	public PriceStrategyPO findPriceStrategy() throws RemoteException {
		PriceStrategyPO priceStrategy = null;
		ResultSet result = JDBC.ExecuteQuery("select * from priceStrategypo;");
		try{
		if(!result.wasNull())
			priceStrategy = (PriceStrategyPO)POGenerator.generateObject(result, PriceStrategyPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return priceStrategy;
	}

	public ResultMessage updatePriceStrategy(PriceStrategyPO PriceStrategy)
			throws RemoteException {
		PriceStrategyPO tempPriceStrategy = findPriceStrategy();
		if(!(tempPriceStrategy==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(PriceStrategy, PriceStrategy.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the price strategy!");
		}
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyPO SalaryStrategy)
			throws RemoteException {
		if(findSalaryStrategy(SalaryStrategy.getType())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(SalaryStrategy, SalaryStrategy.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The salary strategy already exists!");
		}
	}

	public SalaryStrategyPO findSalaryStrategy(PersonType type) throws RemoteException {
		SalaryStrategyPO salaryStrategy = null;
		ResultSet result = JDBC.ExecuteQuery("select * from salaryStrategypo where type = \""+type+"\";");
		try{
		if(!result.wasNull())
			salaryStrategy = (SalaryStrategyPO)POGenerator.generateObject(result, SalaryStrategyPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return salaryStrategy;
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyPO SalaryStrategy)
			throws RemoteException {
		SalaryStrategyPO tempSalaryStrategy = findSalaryStrategy(SalaryStrategy.getType());
		if(!(tempSalaryStrategy==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(SalaryStrategy, SalaryStrategy.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the salary strategy!");
		}
	}

}
