package edu.nju.lms.businessLogicService.impl.user;

import java.util.ArrayList;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.utility.DataServiceFactory;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.UserDataService;
public class UserController implements UserblService{
	UserDataService userService;   
	UserblImpl user;

	LogController logController;
	
	public UserController(){
		try{
			logController=BusinessLogicFactory.getLogController();
			userService=DataServiceFactory.getUserDataService();
			user=new UserblImpl();
	    } catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
	}
	public void reconnect(){
		try{
			logController=BusinessLogicFactory.getLogController();
			userService=DataServiceFactory.getUserDataService();
			user=new UserblImpl();
	    } catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
	}
	public UserVO findUserInfo(String id) {
		return user.findUserInfo(id,this.userService);
	}

	public ResultMessage deleteUser(String id) {
		ResultMessage result=user.deleteUser(id,this.userService);
		
		if(result.isSuccess()){
			logController.addLog("删除用户"+id+"的信息");
		}

		return result;
	}

	public ResultMessage updateUser(UserVO User) {
		ResultMessage result=user.updateUser(User,this.userService);
		
		if(result.isSuccess()){
			logController.addLog("更新用户"+User.getUserName()+"的信息");
		}

		return result;
	}

	public ResultMessage addUser(UserVO User) {
		ResultMessage result=user.addUser(User,this.userService);

		if(result.isSuccess()){
			logController.addLog("新增用户"+User.getUserName()+"的信息");
		}
		
		return result;
	}

	public ArrayList<UserVO> findAllUser() {
		ArrayList<UserVO> result=user.findAllUser(this.userService);

		logController.addLog("查看所有用户的信息");
		
		return result;
	}
	
	
}
