package IntegrateTest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceReceiptDataService;
import edu.nju.lms.dataService.impl.FinanceReceiptDataImpl;
import junit.framework.Assert;

public class FinanceReceiptDataTest {
	public FinanceReceiptDataService financeReceiptData = new FinanceReceiptDataImpl();
	
	Calendar cal1 = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	ArrayList<String> expressNums1 = new ArrayList<String>();
	ArrayList<String> expressNums2 = new ArrayList<String>();
	public ReceiptPO receipt1 = new ReceiptPO("7384736271",cal1,873647.5,"9384736283",expressNums1);
	public ReceiptPO receipt2 = new ReceiptPO("5374927463",cal1,283626.5,"2326367483",expressNums1);
	
	public ResultMessage success = new ResultMessage(true,null);
	public ResultMessage fail1 = new ResultMessage(false,"The receipt already exists!");
	public ResultMessage fail2 = new ResultMessage(false,"Could not find the receipt!");
	
	@Test
	public void testAddReceipt() throws RemoteException{
		Assert.assertEquals(success, financeReceiptData.addReceipt(receipt1));
		Assert.assertEquals(fail1, financeReceiptData.addReceipt(receipt1));
		Assert.assertEquals(success, financeReceiptData.addReceipt(receipt2));
	}
	@Test
	public void testDeleteReceipt() throws RemoteException{
		financeReceiptData.addReceipt(receipt1);
		Assert.assertEquals(success, financeReceiptData.deleteReceipt(receipt1.getId()));
		Assert.assertEquals(fail2, financeReceiptData.deleteReceipt(receipt1.getId()));
		
	}
	@Test
	public void testFindReceipt_name() throws RemoteException{
		
		
	}
	@Test
	public void testFindReceipt_time() throws RemoteException{
		financeReceiptData.addReceipt(receipt2);
		Assert.assertEquals(success, financeReceiptData.findReceipt(cal2));
		Assert.assertEquals(null, financeReceiptData.findReceipt(cal1));
	}
	@Test
	public void testUpdateReceipt() throws RemoteException{
		financeReceiptData.addReceipt(receipt2);
		Assert.assertEquals(success, financeReceiptData.updateReceipt(receipt2));
		Assert.assertEquals(fail2, financeReceiptData.updateReceipt(receipt1));
	}



}
