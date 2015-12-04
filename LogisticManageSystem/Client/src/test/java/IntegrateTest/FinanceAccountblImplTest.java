package IntegrateTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.InitialInfoVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceAccountblImpl;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年11月16日
 */
public class FinanceAccountblImplTest {
	FinanceAccountblImpl accountbl /*= new FinanceAccountblImpl()*/;
	@Test
	public void testAddAccount() {
		AccountVO a = new AccountVO("1256975631269789",25455);
		ResultMessage re = accountbl.addAccount(a);
		assertEquals(true,re.isSuccess());
	}

	@Test
	public void testShowAccount() {
		AccountVO a = new AccountVO("1256975631269789",25455);
		accountbl.addAccount(a);
		AccountVO re = accountbl.showAccount("1256975631269789");
		Assert.assertEquals(re.getAmount(),25455);
	}

	@Test
	public void testDeleteAccount() {
		AccountVO a = new AccountVO("1256975631269789",25455);
		accountbl.addAccount(a);
		ResultMessage re = accountbl.deleteAccount("1256975631269789");
		assertEquals(true,re.isSuccess());
	}

	@Test
	public void testAddInitialInfo() {
		ArrayList<String> departments=new ArrayList<String>();
		ArrayList<String> personnel=new ArrayList<String>();
		ArrayList<String> cars=new ArrayList<String>();
		ArrayList<String> warehouses=new ArrayList<String>();
		ArrayList<String> accounts=new ArrayList<String>();
		InitialInfoVO init = new InitialInfoVO("",departments, personnel, cars, warehouses, accounts);
		ResultMessage re = accountbl.addInitialInfo(init);
		assertEquals(true,re.isSuccess());
	}

}
