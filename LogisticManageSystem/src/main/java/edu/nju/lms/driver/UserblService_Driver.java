package edu.nju.lms.driver;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.businessLogicService.impl.UserblImpl;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.UserDataService;
import edu.nju.lms.dataService.impl.UserDataImpl;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class UserblService_Driver {
	public void drive(UserblService userbl){
		UserVO user = userbl.findUserInfo("010101");
		System.out.println(user.getUserName());
		ResultMessage result = userbl.deleteUser("0000000000");
		if(result.isSuccess()){
			System.out.println("Delte success\n");
		}else{
			System.out.println("Failue!");
		}
		result = userbl.addUser(new UserVO("du","0",PersonType.MANAGER));
		if(result.isSuccess()){
			System.out.println("Add success\n");
		}else{
			System.out.println("Failue!");
		}
		result = userbl.updateUser(new UserVO("du","0",PersonType.MANAGER));
		if(result.isSuccess()){
			System.out.println("Update success\n");
		}else{
			System.out.println("Failue!");
		}
	}
	public static void main1(String[] args) {
		UserDataService service = new UserDataImpl();
		UserblService_Driver driver = new UserblService_Driver();
		UserblService userbl = new UserblImpl(service);
		driver.drive(userbl);

	}
}
