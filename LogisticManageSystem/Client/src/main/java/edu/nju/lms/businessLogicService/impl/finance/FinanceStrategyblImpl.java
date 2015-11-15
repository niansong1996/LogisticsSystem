package edu.nju.lms.businessLogicService.impl.finance;

import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.businessLogicService.FinanceStrategyblService;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinanceStrategyblImpl implements FinanceStrategyblService {

	public ResultMessage addPriceStrategy(PriceStrategyVO priceStrategy) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ResultMessage updatePriceStrategy(PriceStrategyVO priceStrategy) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public PriceStrategyVO findPriceStrategy() {
		// TODO Auto-generated method stub
		return new PriceStrategyVO(20, 30, 50);
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public SalaryStrategyVO findSalaryStrategy() {
		// TODO Auto-generated method stub
		return new SalaryStrategyVO("manager",5000,0,5000);
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

}
