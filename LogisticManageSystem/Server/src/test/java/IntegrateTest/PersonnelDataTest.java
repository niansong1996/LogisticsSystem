package IntegrateTest;

import java.rmi.RemoteException;

import org.junit.Assert;
import org.junit.Test;

import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.dataService.PersonnelDataService;
import edu.nju.lms.dataService.impl.PersonnelDataImpl;

public class PersonnelDataTest {
	PersonnelDataService personnelData;
	PersonnelPO personnelPo1 = new PersonnelPO("8273847263","高露","827384",PersonType.COURIER,3000,40,1000);
	PersonnelPO personnelPo2 = new PersonnelPO("5344235243","狗露","534423",PersonType.MANAGER,8000,20,5000);
	
	ResultMessage success = new ResultMessage(true,"success");
	ResultMessage fail1 = new ResultMessage(false,"The personnel already exists!");
	ResultMessage fail2 = new ResultMessage(false,"Could not find the personnel!");
	
	@Test
	public void testAddPersonnel() throws RemoteException{
		personnelData = new PersonnelDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table personnelpo");
		Assert.assertEquals(success,personnelData.addPersonnel(personnelPo1));
		Assert.assertEquals(fail1,personnelData.addPersonnel(personnelPo1));
		Assert.assertEquals(success, personnelData.addPersonnel(personnelPo2));
	}
	@Test
	public void testDeletePersonnel() throws RemoteException{
		personnelData = new PersonnelDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table personnelpo");
		personnelData.addPersonnel(personnelPo1);
		Assert.assertEquals(success, personnelData.deletePersonnel(personnelPo1.getId()));
		Assert.assertEquals(fail2, personnelData.deletePersonnel(personnelPo1.getId()));
	}
	@Test
	public void testFindPersonnel() throws RemoteException{
		personnelData = new PersonnelDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table personnelpo");
		personnelData.addPersonnel(personnelPo2);
		Assert.assertEquals(personnelPo2, personnelData.findPersonnel(personnelPo2.getId()));
		Assert.assertEquals(null, personnelData.findPersonnel(personnelPo1.getId()));
		
	}
	@Test
	public void testUpdatePersonnel() throws RemoteException{
		personnelData = new PersonnelDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table personnelpo");
		personnelData.addPersonnel(personnelPo2);
		Assert.assertEquals(success,personnelData.updatePersonnel(personnelPo2));
		Assert.assertEquals(fail2, personnelData.updatePersonnel(personnelPo1));
	}
}
