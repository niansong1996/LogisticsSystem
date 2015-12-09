package IntegrateTest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.dataService.WarehouseCheckinDataService;
import edu.nju.lms.dataService.impl.WarehouseCheckinDataImpl;

public class WarehouseCheckinDataTest {
	WarehouseCheckinDataService checkinData;
	ResultMessage success = new ResultMessage(true,"success");
	ResultMessage fail11 = new ResultMessage(false,"The checkin already exists!");
	ResultMessage fail12 = new ResultMessage(false,"Could not find the checkin!");
	Calendar cal1 = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	ArrayList<String> a1 = new ArrayList<String>();
	ArrayList<String> a2 = new ArrayList<String>();
	CheckinPO checkinPo1 = new CheckinPO("8923234244",ListState.WAITING,a1,cal1,"8726372636");
	CheckinPO checkinPo2 = new CheckinPO("7364534263",ListState.WAITING,a2,cal2,"8726372636");
	
	@Test
	public void testAddCheckin() throws RemoteException{
		checkinData = new WarehouseCheckinDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table checkinpo");
		Assert.assertEquals(success,checkinData.addCheckin(checkinPo1));
		Assert.assertEquals(fail11,checkinData.addCheckin(checkinPo1));
		Assert.assertEquals(success, checkinData.addCheckin(checkinPo2));
	}
	@Test
	public void testDeleteCheckin() throws RemoteException{
		checkinData = new WarehouseCheckinDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table checkinpo");
		checkinData.addCheckin(checkinPo1);
		Assert.assertEquals(success, checkinData.deleteCheckin(checkinPo1.getId()));
		Assert.assertEquals(fail12, checkinData.deleteCheckin(checkinPo1.getId()));
	}
	@Test
	public void testFindCheckin() throws RemoteException{
		checkinData = new WarehouseCheckinDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table checkinpo");
		checkinData.addCheckin(checkinPo2);
		Assert.assertEquals(checkinPo2, checkinData.findCheckin(checkinPo2.getId()));
		Assert.assertEquals(null, checkinData.findCheckin(checkinPo1.getId()));
		
	}
	@Test
	public void testUpdateCheckin() throws RemoteException{
		checkinData = new WarehouseCheckinDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table checkinpo");
		checkinData.addCheckin(checkinPo2);
		Assert.assertEquals(success,checkinData.updateCheckin(checkinPo2));
		Assert.assertEquals(fail12, checkinData.updateCheckin(checkinPo1));
	}
}
