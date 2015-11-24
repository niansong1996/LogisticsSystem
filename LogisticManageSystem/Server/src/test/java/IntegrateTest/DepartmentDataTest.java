package IntegrateTest;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.data.DepartmentType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.dataService.DepartmentDataService;
import edu.nju.lms.dataService.impl.DepartmentDataImpl;
import edu.nju.lms.dataService.impl.FinanceAccountDataImpl;

public class DepartmentDataTest {
	DepartmentDataService departmentData;
	ResultMessage success = new ResultMessage(true,null);
	ResultMessage fail11 = new ResultMessage(false,"The department already exists!");
	ResultMessage fail12 = new ResultMessage(false,"Could not find the department!");
	
	ResultMessage fail21 = new ResultMessage(false,"The city already exists!");
	ResultMessage fail22 = new ResultMessage(false,"Could not find the city!");
	
	private ArrayList<Double> distance = new ArrayList<Double>();
	private ArrayList<String> businessNums = new ArrayList<String>();
	
	CityPO cityPo1 = new CityPO("0250","Nanjing",businessNums,distance);
	CityPO cityPo2 = new CityPO("0210","Shanghai",businessNums,distance);
	DepartmentPO departmentPo1 = new DepartmentPO(DepartmentType.BUSINESSHALL,"025010234",cityPo1.getId());
	DepartmentPO departmentPo2 = new DepartmentPO(DepartmentType.BUSINESSHALL,"025010235",cityPo2.getId());
	@Test
	public void testAddDepartment() throws RemoteException{
		departmentData = new DepartmentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table departmentpo;");
		JDBC.ExecuteData("truncate table citypo;");
		Assert.assertEquals(success,departmentData.addDepartment(departmentPo1));
		Assert.assertEquals(fail11,departmentData.addDepartment(departmentPo1));
		Assert.assertEquals(success, departmentData.addDepartment(departmentPo2));
	}
	@Test
	public void testDeleteDepartment() throws RemoteException{
		departmentData = new DepartmentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table departmentpo;");
		JDBC.ExecuteData("truncate table citypo;");
		departmentData.addDepartment(departmentPo1);
		Assert.assertEquals(success, departmentData.deleteDepartment(departmentPo1.getDepartmentNum()));
		Assert.assertEquals(fail12, departmentData.deleteDepartment(departmentPo1.getDepartmentNum()));
	}
	@Test
	public void testFindDepartment() throws RemoteException{
		departmentData = new DepartmentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table departmentpo;");
		JDBC.ExecuteData("truncate table citypo;");
		departmentData.addDepartment(departmentPo2);
		Assert.assertEquals(departmentPo2, departmentData.findDepartment(departmentPo2.getDepartmentNum()));
		Assert.assertEquals(null, departmentData.findDepartment(departmentPo1.getDepartmentNum()));
		
	}
	@Test
	public void testUpdateDepartment() throws RemoteException{
		departmentData = new DepartmentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table departmentpo;");
		JDBC.ExecuteData("truncate table citypo;");
		departmentData.addDepartment(departmentPo2);
		Assert.assertEquals(success,departmentData.updateDepartment(departmentPo2));
		Assert.assertEquals(fail12, departmentData.updateDepartment(departmentPo1));
	}
//	@Test
	public void testAddCity() throws RemoteException{
		departmentData = new DepartmentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table departmentpo;");
		JDBC.ExecuteData("truncate table citypo;");
		Assert.assertEquals(success,departmentData.addCity(cityPo1));
		Assert.assertEquals(fail21,departmentData.addCity(cityPo1));
		Assert.assertEquals(success, departmentData.addCity(cityPo2));
	}
//	@Test
	public void testDeleteCity() throws RemoteException{
		departmentData = new DepartmentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table departmentpo;");
		JDBC.ExecuteData("truncate table citypo;");
		departmentData.addCity(cityPo1);
		Assert.assertEquals(success, departmentData.deleteCity(cityPo1.getId()));
		Assert.assertEquals(fail22, departmentData.deleteCity(cityPo1.getId()));
	}
//	@Test
	public void testFindCity() throws RemoteException{
		departmentData = new DepartmentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table departmentpo;");
		JDBC.ExecuteData("truncate table citypo;");
		departmentData.addCity(cityPo2);
		Assert.assertEquals(cityPo2, departmentData.findCity(cityPo2.getId()));
		Assert.assertEquals(null, departmentData.findCity(cityPo1.getId()));
		
	}
//	@Test
	public void testUpdateCity() throws RemoteException{
		departmentData = new DepartmentDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table departmentpo;");
		JDBC.ExecuteData("truncate table citypo;");
		departmentData.addCity(cityPo2);
		Assert.assertEquals(success,departmentData.updateCity(cityPo2));
		Assert.assertEquals(fail22, departmentData.updateCity(cityPo1));
	}
}
