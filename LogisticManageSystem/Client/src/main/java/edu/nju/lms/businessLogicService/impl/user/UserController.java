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
//	LogController logController;
//	
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//	String time="";
//	OperationVO op=null;
	private String logID;
	
	public UserController(){
		try{    
			userService=(UserDataService) Naming.lookup("//127.0.0.1:1099/UserDataService"); 
			user=new UserblImpl(userService);
			//logController=new LogController();
	    }    
	    catch (Exception e){
	    	System.out.println("网络未连接！");
	    	System.exit(0);;
	    }
	}
	public UserController(String id){
		this.logID=id;
	}
	
	public UserVO findUserInfo(String id) {
		UserVO result=user.findUserInfo(id);
//		if(result.getUserName()!=null){
//			time = sdf.format(new Date());
//			op=new OperationVO(time,logID,"查询用户"+id+"的信息");
//			logController.addLog(op);
//		}
		return result;
	}

	public ResultMessage deleteUser(String id) {
		ResultMessage result=user.deleteUser(id);
//		if(result.isSuccess()){
//			time = sdf.format(new Date());
//			op=new OperationVO(time,logID,"删除用户"+id+"的信息");
//			logController.addLog(op);
//		}
		return result;
	}

	public ResultMessage updateUser(UserVO User) {
		ResultMessage result=user.updateUser(User);
//		if(result.isSuccess()){
//			time = sdf.format(new Date());
//			op=new OperationVO(time,logID,"更新用户"+User.getUserName()+"的信息");
//			logController.addLog(op);
//		}
		return result;
	}

	public ResultMessage addUser(UserVO User) {
		ResultMessage result=user.addUser(User);
//		if(result.isSuccess()){
//			time = sdf.format(new Date());
//			op=new OperationVO(time,logID,"增加用户"+User.getUserName()+"的信息");
//			logController.addLog(op);
//		}
		return result;
	}

	public ArrayList<UserVO> findAllUser() {
		ArrayList<UserVO> result=user.findAllUser();
//		time = sdf.format(new Date());
//		op=new OperationVO(time,logID,"查看所有用户的信息");
//		logController.addLog(op);
		return result;
	}
	public void setID(String id){
		this.logID = id;
	}
	
//	public static void main(String[] args){
//		UserController controller=new UserController();
//		ResultMessage a=controller.deleteUser("1000000037");
//		System.out.println(a.isSuccess());
//	}

}
