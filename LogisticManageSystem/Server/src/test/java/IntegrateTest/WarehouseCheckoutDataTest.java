package IntegrateTest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.LoadType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;
import edu.nju.lms.dataService.impl.WarehouseCheckoutDataImpl;

public class WarehouseCheckoutDataTest {
	WarehouseCheckoutDataService checkoutData;
	ResultMessage success = new ResultMessage(true,"success");
	ResultMessage fail11 = new ResultMessage(false,"The checkout already exists!");
	ResultMessage fail12 = new ResultMessage(false,"Could not find the checkout!");
	Calendar cal1 = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	ArrayList<String> a1 = new ArrayList<String>();
	ArrayList<String> a2 = new ArrayList<String>();
	ArrayList<String> a3 = new ArrayList<String>();
	ArrayList<String> a4 = new ArrayList<String>();
	
	
	CheckoutPO checkoutPo1 = new CheckoutPO("8923234244",ListState.WAITING,a1,cal1,a3,LoadType.AIRPLANE,"8924729762","8924729762","8937463526");
	CheckoutPO checkoutPo2 = new CheckoutPO("7364534263",ListState.WAITING,a2,cal2,a4,LoadType.CAR,"2942732941","8924729762","9420374621");
	
//	@Test
	public void testAddCheckout() throws RemoteException{
		checkoutData = new WarehouseCheckoutDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table checkoutpo");
		Assert.assertEquals(success,checkoutData.addCheckout(checkoutPo1));
		Assert.assertEquals(fail11,checkoutData.addCheckout(checkoutPo1));
		Assert.assertEquals(success, checkoutData.addCheckout(checkoutPo2));
	}
//	@Test
	public void testDeleteCheckout() throws RemoteException{
		checkoutData = new WarehouseCheckoutDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table checkoutpo");
		checkoutData.addCheckout(checkoutPo1);
		Assert.assertEquals(success, checkoutData.deleteCheckout(checkoutPo1.getId()));
		Assert.assertEquals(fail12, checkoutData.deleteCheckout(checkoutPo1.getId()));
	}
//	@Test
	public void testFindCheckout() throws RemoteException{
		checkoutData = new WarehouseCheckoutDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table checkoutpo");
		checkoutData.addCheckout(checkoutPo2);
		Assert.assertEquals(checkoutPo2, checkoutData.findCheckout(checkoutPo2.getId()));
		Assert.assertEquals(null, checkoutData.findCheckout(checkoutPo1.getId()));
		
	}
	@Test
	public void testUpdateCheckout() throws RemoteException{
		checkoutData = new WarehouseCheckoutDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table checkoutpo");
		checkoutData.addCheckout(checkoutPo2);
		Assert.assertEquals(success,checkoutData.updateCheckout(checkoutPo2));
		Assert.assertEquals(fail12, checkoutData.updateCheckout(checkoutPo1));
	}
}
