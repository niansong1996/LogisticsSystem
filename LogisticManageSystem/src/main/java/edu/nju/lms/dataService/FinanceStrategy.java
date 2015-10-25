package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.PriceStrategyPO;
import edu.nju.lms.PO.SalaryStrategyPO;
import edu.nju.lms.data.ResultMessage;

/**
 * data of the strategy
 * @author oppa
 * 2015/10/25
 */
public interface FinanceStrategy {
	/**
	 * @param PriceStrategy
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addPriceStrategy(PriceStrategyPO PriceStrategy) throws RemoteException;
	
	/**
	 * @return PriceStrategyPO
	 * @throws RemoteException
	 * @see PriceStrategyPO
	 */
	public PriceStrategyPO findPriceStrategy() throws RemoteException;
	
	/**
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deletePriceStrategy() throws RemoteException;
	
	/**
	 * @param PriceStrategyPo
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage updatePriceStrategy(PriceStrategyPO PriceStrategy) throws RemoteException;
	
	/**
	 * @param SalaryStrategy
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addSalaryStrategy(SalaryStrategyPO SalaryStrategy) throws RemoteException;
	
	/**
	 * @return SalaryStrategyPO
	 * @throws RemoteException
	 * @see SalaryStrategyPO
	 */
	public SalaryStrategyPO findSalaryStrategy() throws RemoteException;
	
	/**
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deleteSalaryStrategy() throws RemoteException;
	
	/**
	 * @param SalaryStrategyPo
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage updateSalaryStrategy(SalaryStrategyPO SalaryStrategy) throws RemoteException;
	
	
}
