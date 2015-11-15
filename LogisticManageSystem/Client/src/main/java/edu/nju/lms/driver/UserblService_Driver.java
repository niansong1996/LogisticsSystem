package edu.nju.lms.driver;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.businessLogicService.impl.user.UserblImpl;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.UserDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class UserblService_Driver {
	public void drive(UserblService userbl){
		ResultMessage result = userbl.addUser(new UserVO("0101010101","123456",PersonType.MANAGER));
		if(result.isSuccess()){
			System.out.println("Add success\n");
		}else{
			System.out.println("Failue!");
		}
		
		ResultMessage result2 = userbl.addUser(new UserVO("0101010101","123456",PersonType.MANAGER));
		if(result2.isSuccess()){
			System.out.println("Add success\n");
		}else{
			System.out.println("Failue!"+result2.getErrorMessage());
		}
		
		UserVO user = userbl.findUserInfo("0101010101");
		if(user==null){
			System.out.println("not found!!");
		}
		else{
			System.out.println("Find success\n");
		}
		
		result = userbl.updateUser(new UserVO("0101010101","123456",PersonType.COURIER));
		if(result.isSuccess()){
			System.out.println("Update success\n");
		}else{
			System.out.println("Failue!"+result.getErrorMessage());
		}
		
		
		result = userbl.deleteUser("0101010101");
		if(result.isSuccess()){
			System.out.println("Delte success\n");
		}else{
			System.out.println("Failue!");
		}
		
	}
	public static void main(String[] args) {
//		UserDataService service = new UserDataImpl();
//		UserblService_Driver driver = new UserblService_Driver();
//		UserblService userbl = new UserblImpl(service);
//		driver.drive(userbl);

	}
}
