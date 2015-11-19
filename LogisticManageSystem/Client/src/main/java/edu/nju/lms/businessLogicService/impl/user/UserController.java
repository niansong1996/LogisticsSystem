package edu.nju.lms.businessLogicService.impl.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.data.ResultMessage;

public class UserController implements UserblService{

	UserblImpl user;
	private String logID;
	LogController logController;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	String time = sdf.format(new Date());
	OperationVO op=null;
	public UserController(){
		
	}
	public UserController(String id){
		this.logID=id;
	}
	
	public UserVO findUserInfo(String id) {
		UserVO result=user.findUserInfo(id);
		if(result.getUserName()!=null){
			op=new OperationVO(time,logID,"查询员工"+id+"的信息");
			logController.addLog(op);
		}
		return result;
	}

	public ResultMessage deleteUser(String id) {
		ResultMessage result=user.deleteUser(id);
		if(result.isSuccess()){
			op=new OperationVO(time,logID,"删除员工"+id+"的信息");
			logController.addLog(op);
		}
		return result;
	}

	public ResultMessage updateUser(UserVO User) {
		ResultMessage result=user.updateUser(User);
		if(result.isSuccess()){
			op=new OperationVO(time,logID,"更新员工"+User.getUserName()+"的信息");
			logController.addLog(op);
		}
		return result;
	}

	public ResultMessage addUser(UserVO User) {
		ResultMessage result=user.addUser(User);
		if(result.isSuccess()){
			op=new OperationVO(time,logID,"增加员工"+User.getUserName()+"的信息");
			logController.addLog(op);
		}
		return result;
	}

	public ArrayList<UserVO> findAllUser() {
		ArrayList<UserVO> result=user.findAllUser();
		op=new OperationVO(time,logID,"查看所有用户的信息");
		logController.addLog(op);
		return result;
	}
	public void setID(String id){
		this.logID = id;
	}

}
