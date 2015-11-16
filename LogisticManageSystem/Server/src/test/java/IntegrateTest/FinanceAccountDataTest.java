package IntegrateTest;

import java.rmi.RemoteException;

import org.junit.Test;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.InitialInforPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;
import edu.nju.lms.dataService.impl.FinanceAccountDataImpl;
import junit.framework.Assert;

public class FinanceAccountDataTest {
	public FinanceAccountDataService financeAccountData = new FinanceAccountDataImpl();
//	public InitialInforPO initialInfoPo = new InitialInforPO();
	public AccountPO accountPo1 = new AccountPO("6225887941959874",1212343.5);
	public AccountPO accountPo2 = new AccountPO("6836474938271738",8736482.2);
	
	public ResultMessage success = new ResultMessage(true,null);
	public ResultMessage fail1 = new ResultMessage(false,"The account already exists!");
	public ResultMessage fail2 = new ResultMessage(false,"Could not find the account!");
	
	@Test
	public void testAddInitialInfo(){
		
	}
	@Test
	public void testAddAccount() throws RemoteException{
		Assert.assertEquals(success, financeAccountData.addAccount(accountPo1));
		Assert.assertEquals(fail1,financeAccountData.addAccount(accountPo1));
		Assert.assertEquals(success, financeAccountData.addAccount(accountPo2));
		
	}
	@Test
	public void testDeleteAccount() throws RemoteException{
		financeAccountData.addAccount(accountPo1);
		Assert.assertEquals(success, financeAccountData.deleteAccount(accountPo1.getName()));
		Assert.assertEquals(fail2, financeAccountData.deleteAccount(accountPo1.getName()));
	}
	@Test 
	public void testUpadtaAccout() throws RemoteException{
		financeAccountData.addAccount(accountPo2);
		Assert.assertEquals(fail2, financeAccountData.updateAccount(accountPo1));
		Assert.assertEquals(success, financeAccountData.updateAccount(accountPo2));
	}
	@Test
	public void testFindAccount() throws RemoteException{
		financeAccountData.addAccount(accountPo2);
		Assert.assertEquals(success,financeAccountData.findAccount(accountPo2.getName()));
		Assert.assertEquals(null,financeAccountData.findAccount(accountPo1.getName()));
	}
}
