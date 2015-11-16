package IntegrateTest;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DepartmentPO;
import edu.nju.lms.data.DepartmentType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.DepartmentDataService;
import edu.nju.lms.dataService.impl.DepartmentDataImpl;

public class DepartmentDataTest {
	DepartmentDataService departmentData = new DepartmentDataImpl();
	ResultMessage success = new ResultMessage(true,null);
	ResultMessage fail1 = new ResultMessage(false,"The department already exists!");
	ResultMessage fail2 = new ResultMessage(false,"Could not find the department!");
	
	private ArrayList<Double> distance = new ArrayList<Double>();
	private ArrayList<String> businessNums = new ArrayList<String>();
	
	CityPO cityPo1 = new CityPO("0250","Nanjing",businessNums,distance);
	CityPO cityPo2 = new CityPO("0210","Shanghai",businessNums,distance);
	DepartmentPO departmentPo1 = new DepartmentPO(DepartmentType.BUSINESSHALL,"025010234",cityPo1);
	DepartmentPO departmentPo2 = new DepartmentPO(DepartmentType.BUSINESSHALL,"025010235",cityPo2);
	@Test
	public void testAddDepartment() throws RemoteException{
		Assert.assertEquals(success,departmentData.addDepartment(departmentPo1));
		Assert.assertEquals(fail1,departmentData.addDepartment(departmentPo1));
		Assert.assertEquals(success, departmentData.addDepartment(departmentPo2));
	}
	@Test
	public void testDeleteDepartment() throws RemoteException{
		Assert.assertEquals(success, departmentData.deleteDepartment(departmentPo1.getDepartmentNum()));
		Assert.assertEquals(fail2, departmentPo1.getDepartmentNum());
	}
	@Test
	public void testFindDepartment() throws RemoteException{
		Assert.assertEquals(success, departmentData.findDepartment(departmentPo2.getDepartmentNum()));
		Assert.assertEquals(null, departmentData.findDepartment(departmentPo1.getDepartmentNum()));
		
	}
	@Test
	public void testUpdateDepartment() throws RemoteException{
		Assert.assertEquals(success,departmentData.updateDepartment(departmentPo2));
		Assert.assertEquals(fail2, departmentData.updateDepartment(departmentPo1));
	}
	@Test
	public void testAddCity() throws RemoteException{
		Assert.assertEquals(success,departmentData.addCity(cityPo1));
		Assert.assertEquals(fail1,departmentData.addCity(cityPo1));
		Assert.assertEquals(success, departmentData.addCity(cityPo2));
	}
	@Test
	public void testDeleteCity() throws RemoteException{
		Assert.assertEquals(success, departmentData.deleteCity(cityPo1.getId()));
		Assert.assertEquals(fail2, cityPo1.getId());
	}
	@Test
	public void testFindCity() throws RemoteException{
		Assert.assertEquals(success, departmentData.findCity(cityPo2.getId()));
		Assert.assertEquals(null, departmentData.findCity(cityPo1.getId()));
		
	}
	@Test
	public void testUpdateCity() throws RemoteException{
		Assert.assertEquals(success,departmentData.updateCity(cityPo2));
		Assert.assertEquals(fail2, departmentData.updateCity(cityPo1));
	}
}
