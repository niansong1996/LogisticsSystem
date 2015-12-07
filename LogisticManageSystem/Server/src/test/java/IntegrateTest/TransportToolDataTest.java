package IntegrateTest;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Test;

import edu.nju.lms.PO.DriverPO;
import edu.nju.lms.PO.VehiclePO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.dataService.TransportToolDataService;
import edu.nju.lms.dataService.impl.TransportToolDataImpl;
import junit.framework.Assert;

public class TransportToolDataTest {
	TransportToolDataService transportToolData;
	
	public ResultMessage success1 = new ResultMessage(true,"success");
	public ResultMessage fail11 = new ResultMessage(false,"The driver already exists!");
	public ResultMessage fail12 = new ResultMessage(false,"Could not find the driver!");
	
	public ResultMessage success2 = new ResultMessage(true,"success");
	public ResultMessage fail21 = new ResultMessage(false,"The vehicle already exists!");
	public ResultMessage fail22 = new ResultMessage(false,"Could not find the vehicle!");
	
	Calendar cal1 = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	
	DriverPO driverPO1 = new DriverPO("9876563523", "ABC", cal1, "8927362738273", "13487653645", 0, cal2, "892736");
	DriverPO driverPO2 = new DriverPO("3432324353", "DIE", cal2, "2345876542342", "19723242224", 1, cal1, "242452");
	
	VehiclePO vehiclePO1 = new VehiclePO("8724824","fwuf","284241",5);
	VehiclePO vehiclePO2 = new VehiclePO("2429242","8vaf","928424",2);
	@Test
	public void testAddDriver() throws RemoteException{
		transportToolData = new TransportToolDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table driverpo");
		JDBC.ExecuteData("truncate table vehiclepo");
		Assert.assertEquals(success1, transportToolData.addDriver(driverPO1));
		Assert.assertEquals(fail11, transportToolData.addDriver(driverPO1));
		Assert.assertEquals(success1, transportToolData.addDriver(driverPO2));
	}
	@Test
	public void testUpdateDriver() throws RemoteException{
		transportToolData = new TransportToolDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table driverpo");
		JDBC.ExecuteData("truncate table vehiclepo");
		Assert.assertEquals(fail12, transportToolData.updateDriver(driverPO2));
		transportToolData.addDriver(driverPO2);
		Assert.assertEquals(success1, transportToolData.updateDriver(driverPO2));
	}
	@Test
	public void testFindDriver() throws RemoteException{
		transportToolData = new TransportToolDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table driverpo");
		JDBC.ExecuteData("truncate table vehiclepo");
		Assert.assertEquals(null, transportToolData.findDriver(driverPO1.getDriverNum()));
		transportToolData.addDriver(driverPO2);
		Assert.assertEquals(driverPO2, transportToolData.findDriver(driverPO2.getDriverNum()));
	}
	@Test
	public void testAddVehicle() throws RemoteException{
		transportToolData = new TransportToolDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table driverpo");
		JDBC.ExecuteData("truncate table vehiclepo");
		Assert.assertEquals(success2, transportToolData.addVehicle(vehiclePO1));
		Assert.assertEquals(fail21, transportToolData.addVehicle(vehiclePO1));
		Assert.assertEquals(success2, transportToolData.addVehicle(vehiclePO2));
	}	
	@Test
	public void testUpdateVehicle() throws RemoteException{
		transportToolData = new TransportToolDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table driverpo");
		JDBC.ExecuteData("truncate table vehiclepo");
		Assert.assertEquals(fail22, transportToolData.updateVehicle(vehiclePO2));
		transportToolData.addVehicle(vehiclePO2);
		Assert.assertEquals(success2, transportToolData.updateVehicle(vehiclePO2));
	}
	@Test
	public void testFindVehicle() throws RemoteException{
		transportToolData = new TransportToolDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table driverpo");
		JDBC.ExecuteData("truncate table vehiclepo");
		Assert.assertEquals(null, transportToolData.findVehicle(vehiclePO1.getVehicleNum()));
		transportToolData.addVehicle(vehiclePO2);
		Assert.assertEquals(vehiclePO2, transportToolData.findVehicle(vehiclePO2.getVehicleNum()));
	}
}
