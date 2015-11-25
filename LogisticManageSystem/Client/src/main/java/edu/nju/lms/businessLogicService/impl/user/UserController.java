package edu.nju.lms.businessLogicService.impl.user;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.UserDataService;
public class UserController implements UserblService{
	UserDataService userService;   
	UserblImpl user;

	private String logID;
	
	public UserController(){
		try{
			userService=(UserDataService) Naming.lookup("//127.0.0.1:1099/UserDataService"); 
			user=new UserblImpl(userService);
			//logController=new LogController();
	    }    
	    catch (Exception e){
	    	System.out.println("网络未连接");
	    	System.exit(0);
	    }
	}
	public UserController(String id){
		this.logID=id;
	}
	
	public UserVO findUserInfo(String id) {
		UserVO result=user.findUserInfo(id);

		return result;
	}

	public ResultMessage deleteUser(String id) {
		ResultMessage result=user.deleteUser(id);

		return result;
	}

	public ResultMessage updateUser(UserVO User) {
		ResultMessage result=user.updateUser(User);

		return result;
	}

	public ResultMessage addUser(UserVO User) {
		ResultMessage result=user.addUser(User);

		return result;
	}

	public ArrayList<UserVO> findAllUser() {
		ArrayList<UserVO> result=user.findAllUser();

		return result;
	}
	public void setID(String id){
		this.logID = id;
	}

}
