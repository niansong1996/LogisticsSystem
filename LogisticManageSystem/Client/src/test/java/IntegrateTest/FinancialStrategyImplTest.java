package IntegrateTest;

import org.junit.Test;

import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceStrategyblImpl;
import junit.framework.Assert;

public class FinancialStrategyImplTest {

	FinanceStrategyblImpl strategyImpl/* = new FinanceStrategyblImpl()*/;
	@Test
	public void testPriceStrategy() {
		PriceStrategyVO priceStrategyVO = new PriceStrategyVO(23, 25, 18);
		Assert.assertEquals(true, strategyImpl.addPriceStrategy(new PriceStrategyVO(23, 0, 0)).isSuccess());
		Assert.assertEquals(priceStrategyVO,strategyImpl.findPriceStrategy());
		priceStrategyVO = new PriceStrategyVO(46, 50, 36);
		Assert.assertEquals(true, strategyImpl.updatePriceStrategy(priceStrategyVO).isSuccess());
		Assert.assertEquals(46, strategyImpl.findPriceStrategy().getStandard(),0.01);
	}
	
	@Test
	public void testSalaryStrategy() {
		SalaryStrategyVO salaryStrategyVO = new SalaryStrategyVO("快递员", 4000, 10, 200);
		Assert.assertEquals(true, strategyImpl.addPriceStrategy(new PriceStrategyVO(23, 0, 0)).isSuccess());
		//TODO Error!
	//	Assert.assertEquals(salaryStrategyVO,strategyImpl.findSalaryStrategy());
		salaryStrategyVO = new SalaryStrategyVO("快递员", 4500, 10, 200);
		Assert.assertEquals(true, strategyImpl.updateSalaryStrategy(salaryStrategyVO).isSuccess());
	//	Assert.assertEquals(4500, strategyImpl.findSalaryStrategy().getBasic());
	}

}
