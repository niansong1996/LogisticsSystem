package IntegrateTest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.nju.lms.businessLogicService.impl.finance.FinancePayblImpl;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年11月16日
 */
public class FinancePayblImplTest {
	FinancePayblImpl paybl = new FinancePayblImpl();
	@Test
	public void testcreateRent() {
		ResultMessage re = paybl.createRent(15555, 2015);
	}

	@Test
	public void testSaveRent() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowFreight() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateFreight() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveFreight() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowSalary() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowSalarySum() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowEarning() {
		fail("Not yet implemented");
	}

	@Test
	public void testExportEarning() {
		fail("Not yet implemented");
	}

}
