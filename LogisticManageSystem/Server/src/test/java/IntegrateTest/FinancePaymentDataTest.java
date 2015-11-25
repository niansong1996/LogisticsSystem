package IntegrateTest;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Test;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.PaymentPO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.PaymentType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.dataService.FinancePaymentDataService;
import edu.nju.lms.dataService.impl.FinanceAccountDataImpl;
import edu.nju.lms.dataService.impl.FinancePaymentDataImpl;
import junit.framework.Assert;

public class FinancePaymentDataTest {
	public FinancePaymentDataService financePaymentData;
	Calendar cal1 = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	public AccountPO accountPo1 = new AccountPO("6225887941959874",1212343.5);
	public AccountPO accountPo2 = new AccountPO("6836474938271738",8736482.2);
	public PaymentPO paymentPo1 = new PaymentPO("8736473827",ListState.WAITING,PaymentType.SALARY,cal1,accountPo1.getName(),23452.2);
	public PaymentPO paymentPo2 = new PaymentPO("8394837820",ListState.WAITING,PaymentType.FREIGHT,cal2,accountPo2.getName(),83732.2);
	
	public ResultMessage success = new ResultMessage(true,null);
	public ResultMessage fail1 = new ResultMessage(false,"The payment already exists!");
	public ResultMessage fail2 = new ResultMessage(false,"Could not find the payment!");
	
	
	public FinancePaymentDataTest(){
		cal1.set(2015, 11, 15);
		cal2.set(2015, 11, 16);
	}
	
	
	
	@Test
	public void testAddPayment() throws RemoteException{
		financePaymentData = new FinancePaymentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table paymentpo");
		Assert.assertEquals(success,financePaymentData.addPayment(paymentPo1));
		Assert.assertEquals(fail1, financePaymentData.addPayment(paymentPo1));
		Assert.assertEquals(success, financePaymentData.addPayment(paymentPo2));
	}
	@Test
	public void testDeletePayment() throws RemoteException{
		financePaymentData = new FinancePaymentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table paymentpo");
		financePaymentData.addPayment(paymentPo1);
		Assert.assertEquals(success, financePaymentData.deletePayment(paymentPo1.getId()));
		Assert.assertEquals(fail2, financePaymentData.deletePayment(paymentPo1.getId()));
	}
	@Test
	public void testFindPayment_num() throws RemoteException{
		financePaymentData = new FinancePaymentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table paymentpo");
		financePaymentData.addPayment(paymentPo2);
		Assert.assertEquals(paymentPo2, financePaymentData.findPayment(paymentPo2.getId()));
		Assert.assertEquals(null, financePaymentData.findPayment(paymentPo1.getId()));
	}
	@Test 
	public void testFindPayment_time() throws RemoteException{
		financePaymentData = new FinancePaymentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table paymentpo");
		financePaymentData.addPayment(paymentPo2);
		Assert.assertEquals(paymentPo2, financePaymentData.findPayment(cal2));
		Assert.assertEquals(null, financePaymentData.findPayment(cal1));
	}
	@Test
	public void testUpdatePayment() throws RemoteException{
		financePaymentData = new FinancePaymentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table paymentpo");
		financePaymentData.addPayment(paymentPo2);
		Assert.assertEquals(success, financePaymentData.updatePayment(paymentPo2));
		Assert.assertEquals(fail2, financePaymentData.updatePayment(paymentPo1));
	}

	@Test
	public void testFindEarnings() throws RemoteException{
		
	}
}
