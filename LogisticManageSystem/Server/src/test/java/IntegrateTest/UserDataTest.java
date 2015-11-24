package IntegrateTest;

import java.rmi.RemoteException;

import org.junit.Assert;
import org.junit.Test;

import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.dataService.UserDataService;
import edu.nju.lms.dataService.impl.UserDataImpl;

public class UserDataTest {
	UserDataService userData;
	ResultMessage success = new ResultMessage(true,null);
	ResultMessage fail11 = new ResultMessage(false,"The user already exists!");
	ResultMessage fail12 = new ResultMessage(false,"Could not find the user!");
	
	UserPO userPo1 = new UserPO("1234567899","999",PersonType.MANAGER);
	UserPO userPo2 = new UserPO("7364534263","876567",PersonType.ADMINISTRATOR);
	
	@Test
	public void testAddUser() throws RemoteException{
		userData = new UserDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table userpo");
		Assert.assertEquals(success,userData.addUser(userPo1));
		Assert.assertEquals(fail11,userData.addUser(userPo1));
		Assert.assertEquals(success, userData.addUser(userPo2));
	}
	@Test
	public void testDeleteUser() throws RemoteException{
		userData = new UserDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table userpo");
		userData.addUser(userPo1);
		Assert.assertEquals(success, userData.deleteUser(userPo1.getUserName()));
		Assert.assertEquals(fail12, userData.deleteUser(userPo1.getUserName()));
	}
	@Test
	public void testFindUser() throws RemoteException{
		userData = new UserDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table userpo");
		userData.addUser(userPo2);
		Assert.assertEquals(userPo2, userData.findUser(userPo2.getUserName()));
		Assert.assertEquals(null, userData.findUser(userPo1.getUserName()));
		
	}
	@Test
	public void testUpdateUser() throws RemoteException{
		userData = new UserDataImpl();
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table userpo");
		userData.addUser(userPo2);
		Assert.assertEquals(success,userData.updateUser(userPo2));
		Assert.assertEquals(fail12, userData.updateUser(userPo1));
	}
}
