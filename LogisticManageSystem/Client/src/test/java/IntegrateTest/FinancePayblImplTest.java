package IntegrateTest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.businessLogicService.impl.finance.FinancePayblImpl;
import edu.nju.lms.data.ResultMessage;
import junit.framework.Assert;

/**
 *@author tj
 *@date 2015年11月16日
 */
public class FinancePayblImplTest {
	FinancePayblImpl paybl = new FinancePayblImpl();
	@Test
	public void testcreateRent() {
		RentVO re = paybl.createRent(15555, 2015);
		RentVO test = new RentVO(15555, 2015);
		boolean is_same = re.equals(test);
		assertEquals(true,is_same);
	}

	@Test
	public void testSaveRent() {
		RentVO test = new RentVO(15555, 2015);
		ResultMessage re = paybl.saveRent(test);
		assertEquals(true,re.isSuccess());
	}

	@Test
	public void testUpdateFreight() {
		assertEquals(true,paybl.updateFreight(20).isSuccess());
	}

	@Test
	public void testSaveFreight() {
		FreightVO f = new FreightVO("2015/8/21","1574444577786456",259,null);
		ResultMessage re = paybl.saveFreight(f);
		assertEquals(true,re.isSuccess());
	}

	@Test
	public void testShowEarning() {
		paybl.createRent(1244, 2015);
		paybl.createSalary(new SalaryVO("2015/10/22","1548569789699968",2000,null));
		EarningVO e = paybl.showEarning();
		Assert.assertEquals(e.getProfit(),-3244);
	}

	@Test
	public void testExportEarning() {
		EarningVO e = new EarningVO(1544,100,1444,"2015/8/21","1025897856");
		boolean re = paybl.exportEarning(e);
		assertEquals(true,re);
	}

}
