package edu.nju.lms.businessLogicService;

import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public interface FinanceStrategyblService {
	//运费策略
	public ResultMessage addPriceStrategy (PriceStrategyVO priceStrategy);
	
	public ResultMessage updatePriceStrategy(PriceStrategyVO priceStrategy);
	
	public PriceStrategyVO findPriceStrategy();
	//薪水策略
	public ResultMessage addSalaryStrategy(SalaryStrategyVO salaryStrategy);
	
	public SalaryStrategyVO findSalaryStrategy(String type);
	
	public ResultMessage updateSalaryStrategy(SalaryStrategyVO salaryStrategy);
}
