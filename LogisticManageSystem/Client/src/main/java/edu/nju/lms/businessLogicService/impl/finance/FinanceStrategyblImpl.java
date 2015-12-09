package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;

import edu.nju.lms.PO.PriceStrategyPO;
import edu.nju.lms.PO.SalaryStrategyPO;
import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.SalaryStrategyVO;
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
		ResultMessage result = new ResultMessage(false, "网络未连接");
		PriceStrategyPO po = new PriceStrategyPO(std);
		try {
			result = service.addPriceStrategy(po);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public ResultMessage updatePriceStrategy(double std) {
		ResultMessage result = new ResultMessage(false, "网络未连接");
		PriceStrategyPO po = new PriceStrategyPO(std);
		try {
			result = service.updatePriceStrategy(po);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public PriceStrategyVO findPriceStrategy() {
		PriceStrategyVO result = null;
		try {
			PriceStrategyPO po = service.findPriceStrategy();
			if (po != null)
				result = new PriceStrategyVO(po.getStandard(), po.getExpress(), po.getEconomic());
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result = new ResultMessage(false, "网络未连接");
		PersonType type = PersonType.valueOf(salaryStrategy.getType().toUpperCase());
		SalaryStrategyPO po = new SalaryStrategyPO(type, salaryStrategy.getBasic(), salaryStrategy.getPerTime(),
				salaryStrategy.getBonus());
		try {
			result = service.addSalaryStrategy(po);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public SalaryStrategyVO findSalaryStrategy(String type) {
		SalaryStrategyVO result = null;
		PersonType POtype = PersonType.valueOf(type.toUpperCase());
		try {
			SalaryStrategyPO po = service.findSalaryStrategy(POtype);
			if (po != null) {
				String VOtype = po.getType().toString().toLowerCase();
				result = new SalaryStrategyVO(VOtype, po.getBasic(), po.getPerTime(), po.getBonus());
			}
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result = new ResultMessage(false, "网络未连接");
		PersonType type = PersonType.valueOf(salaryStrategy.getType().toUpperCase());
		SalaryStrategyPO po = new SalaryStrategyPO(type, salaryStrategy.getBasic(), salaryStrategy.getPerTime(),
				salaryStrategy.getBonus());
		try {
			result = service.updateSalaryStrategy(po);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}
}
