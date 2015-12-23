package IntegrateTest;

import org.junit.Assert;
import org.junit.Test;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;

public class UserblImplTest {

	private UserController userController=BusinessLogicFactory.createUserController();
	
	@Test
	public void testAddUser(){	
		UserVO user1=new UserVO("1000000031", "123456", PersonType.FINANCIAL_ADVANCED);
		UserVO user2=new UserVO("1000000030", "123456", PersonType.FINANCIAL_NORMAL);
		
		ResultMessage addResult1=userController.addUser(user1);
		ResultMessage addResult2=userController.addUser(user2);
		ResultMessage addResult3=userController.addUser(user1);
		
		Assert.assertEquals(true, addResult1.isSuccess());
		Assert.assertEquals(true, addResult2.isSuccess());
		Assert.assertEquals(false, addResult3.isSuccess());
	}
	
	@Test
	public void testDeleteUser(){
		ResultMessage deleteResult=userController.deleteUser("1000000037");
		Assert.assertEquals(true, deleteResult.isSuccess());
	}
	
	@Test
	public void testUpdateUser(){
		UserVO user1=new UserVO("1000000030","123456",PersonType.FINANCIAL_ADVANCED);
		
		ResultMessage updateResult1=userController.updateUser(user1);
		Assert.assertEquals(true, updateResult1.isSuccess());
		
	}
	
	@Test
	public void testFindUserInfo(){
		UserVO findResult=userController.findUserInfo("1000000020");
		Assert.assertEquals("123456", findResult.getPassword());
		
	}
	
}
