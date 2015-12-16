package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;

import edu.nju.lms.PO.PriceStrategyPO;
import edu.nju.lms.PO.SalaryStrategyPO;
import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceStrategyDataService;

/**
 * @author tj
 * @date 2015年10月25日
 */
public class FinanceStrategyblImpl {

	private FinanceStrategyDataService service;

	public FinanceStrategyblImpl(FinanceStrategyDataService service) {
		this.service = service;
	}

	public ResultMessage addPriceStrategy(double std) {
		PriceStrategyPO po = new PriceStrategyPO(std);
		try {
			return service.addPriceStrategy(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
	}

	public ResultMessage updatePriceStrategy(double std) {
		PriceStrategyPO po = new PriceStrategyPO(std);
		try {
			return service.updatePriceStrategy(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
	}

	public PriceStrategyVO findPriceStrategy() {
		PriceStrategyVO result = null;
		try {
			PriceStrategyPO po = service.findPriceStrategy();
			if (po != null)
				result = new PriceStrategyVO(po.getStandard(), po.getExpress(), po.getEconomic());
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
			return null;
		}
		return result;
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result=checkStrategy(salaryStrategy);
		if(!result.isSuccess()){
			return result;
		}
		PersonType type = PersonType.valueOf(salaryStrategy.getType().toUpperCase());
		SalaryStrategyPO po = new SalaryStrategyPO(type, salaryStrategy.getBasic(), salaryStrategy.getPerTime(),
				salaryStrategy.getBonus());
		try {
			return service.addSalaryStrategy(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
	}

	public SalaryStrategyVO findSalaryStrategy(PersonType type) {
		SalaryStrategyVO result = null;
		PersonType POtype = type;
		try {
			SalaryStrategyPO po = service.findSalaryStrategy(POtype);
			if (po != null) {
				String VOtype = po.getType().toString().toLowerCase();
				result = new SalaryStrategyVO(VOtype, po.getBasic(), po.getPerTime(), po.getBonus());
			}
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
			return null;
		}
		return result;
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result=checkStrategy(salaryStrategy);
		if(!result.isSuccess()){
			return result;
		}
		PersonType type = PersonType.valueOf(salaryStrategy.getType().toUpperCase());
		SalaryStrategyPO po = new SalaryStrategyPO(type, salaryStrategy.getBasic(), salaryStrategy.getPerTime(),
				salaryStrategy.getBonus());
		try {
			return service.updateSalaryStrategy(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
	}
	
	private ResultMessage checkStrategy(SalaryStrategyVO salaryStrategy){
		if(!(salaryStrategy.getType().equals("COURIER")||salaryStrategy.getType().equals("DRIVER"))&&salaryStrategy.getPerTime()!=0){
			return new ResultMessage(false, "工资类型与输入数据矛盾！");
		}
		if((salaryStrategy.getType().equals("COURIER")||salaryStrategy.getType().equals("DRIVER"))&&salaryStrategy.getPerTime()==0){
			return new ResultMessage(false, "工资类型与输入数据矛盾！");
		}
		return new ResultMessage(true, "");
	}
}
