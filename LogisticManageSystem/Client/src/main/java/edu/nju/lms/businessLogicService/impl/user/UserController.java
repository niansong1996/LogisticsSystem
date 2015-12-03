package edu.nju.lms.businessLogicService.impl.user;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.UserDataService;
public class UserController implements UserblService{
	UserDataService userService;   
	UserblImpl user;

	LogController logController;
	
	public UserController(){
		try{
			logController=BusinessLogicFactory.getLogController();
			userService=(UserDataService) Naming.lookup("//127.0.0.1:1099/UserDataService"); 
			user=new UserblImpl(userService);
	    }    
	    catch (Exception e){
			System.out.println("网络未连接");
	    	System.exit(0);
	    }
	}
	
	public UserVO findUserInfo(String id) {
		UserVO result=user.findUserInfo(id);
		
		logController.addLog("查看用户"+id+"的信息");

		return result;
	}

	public ResultMessage deleteUser(String id) {
		ResultMessage result=user.deleteUser(id);
		
		if(result.isSuccess()){
			logController.addLog("删除用户"+id+"的信息");
		}

		return result;
	}

	public ResultMessage updateUser(UserVO User) {
		ResultMessage result=user.updateUser(User);
		
		if(result.isSuccess()){
			logController.addLog("更新用户"+User.getUserName()+"的信息");
		}

		return result;
	}

	public ResultMessage addUser(UserVO User) {
		ResultMessage result=user.addUser(User);

		if(result.isSuccess()){
			logController.addLog("新增用户"+User.getUserName()+"的信息");
		}
		
		return result;
	}

	public ArrayList<UserVO> findAllUser() {
		ArrayList<UserVO> result=user.findAllUser();

		logController.addLog("查看所有用户的信息");
		
		return result;
	}
	
}
