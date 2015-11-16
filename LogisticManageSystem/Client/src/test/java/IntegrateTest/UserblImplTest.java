package IntegrateTest;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;

/**
 * 
 * @author oppalu
 * 2015/11/15
 *
 */
public class UserblImplTest {

	private UserController userController=new UserController();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddUser(){	
		UserVO user1=new UserVO("1000000027","oppalu37",PersonType.MANAGER);
		UserVO user2=new UserVO("10000000","12345678",PersonType.ADMINISTRATOR);
		UserVO user3=new UserVO("1000000037","1234567890",PersonType.ADMINISTRATOR);
		
		ResultMessage addResult1=userController.addUser(user1);
		ResultMessage addResult2=userController.addUser(user2);
		ResultMessage addResult3=userController.addUser(user3);
		
		Assert.assertEquals(true, addResult1.isSuccess());
		Assert.assertEquals("输入的位数不正确", addResult2.getErrorMessage());
		Assert.assertEquals("位数太多", addResult3.getErrorMessage());
	}
	
	@Test
	public void testDeleteUser(){
		UserVO user1=new UserVO("1000000027","oppalu37",PersonType.MANAGER);
		userController.addUser(user1);
		
		ResultMessage deleteResult1=userController.deleteUser("1000000027");
		Assert.assertEquals(true, deleteResult1.isSuccess());
		
		ResultMessage deleteResult2=userController.deleteUser("1000000007");
		Assert.assertEquals(false, deleteResult2.isSuccess());
		
	}
	
	@Test
	public void testUpdateUser(){
		UserVO user1=new UserVO("1000000027","oppalu37",PersonType.MANAGER);
		userController.addUser(user1);
		
		UserVO user2=new UserVO("1000000027","oppalu0",PersonType.MANAGER);
		ResultMessage updateResult1=userController.updateUser(user2);
		Assert.assertEquals(true, updateResult1.isSuccess());
		
		UserVO user3=new UserVO("1000000027","1234567890",PersonType.ADMINISTRATOR);
		ResultMessage updateResult2=userController.updateUser(user3);
		Assert.assertEquals("位数太多", updateResult2.getErrorMessage());
	}
	
	@Test
	public void testFindUserInfo(){
		UserVO user1=new UserVO("1000000027","oppalu37",PersonType.MANAGER);
		userController.addUser(user1);
		
		UserVO user2=userController.findUserInfo("1000000027");
		Assert.assertEquals("oppalu37", user2.getPassword());
		
		UserVO user3=userController.findUserInfo("1000000020");
		Assert.assertEquals("未找到该人员", user3.getUserName());
		
	}
	
	@Test
	public void testFindAllUser(){
		UserVO user1=new UserVO("1000000027","oppalu37",PersonType.MANAGER);
		userController.addUser(user1);
		
		ArrayList<UserVO> list=userController.findAllUser();
		System.out.println("**********start testing**********");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getUserName()+" "+list.get(i).getPassword()+" "+list.get(i).getPower());
		}
		System.out.println("**********end testing**********");
	}
}
