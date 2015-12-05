package edu.nju.lms.businessLogicService.impl.user;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.UserPO;
import edu.nju.lms.VO.UserVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.UserDataService;

/**
 * 
 * @author Cui
 * 2015-10-26 09:46:03
 */
public class UserblImpl{
	
	private UserDataService dataService = null;
	
	public UserblImpl(UserDataService service) {
		this.dataService=service;
	}
	
	public UserVO findUserInfo(String id) {
		UserPO userPO = null;
		UserVO user = new UserVO("", "", null);
		if(!idCheck(id).isSuccess()) {
			user.setUserName(null);
		}
		try {
			userPO = dataService.findUser(id);
		} catch (RemoteException e) {
		}
		if (userPO != null) {
			user = new UserVO(userPO.getUserName(), userPO.getPassword(), userPO.getPower());
		}
		return user;
	}

	public ResultMessage deleteUser(String id) {
		ResultMessage  result = idCheck(id);
		if(!result.isSuccess()) {
			return result;
		}
		result = new ResultMessage(false, "网络未连接");
		try {
			result = dataService.deleteUser(id);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public ResultMessage updateUser(UserVO user) {
		ResultMessage  result = idCheck(user.getUserName());
		if(!result.isSuccess()) {
			return result;
		}
		result = passwordCheck(user.getPassword());
		if(!result.isSuccess()) {
			return result;
		}
		result = new ResultMessage(false, "网络未连接");
		UserPO userPO = new UserPO(user.getUserName(), user.getPassword(), user.getPower());
		try {
			result = dataService.updateUser(userPO);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public ResultMessage addUser(UserVO User) {
		ResultMessage result = idCheck(User.getUserName());
		if(!result.isSuccess()) {
			return result;
		}
		result = passwordCheck(User.getPassword());
		if(!result.isSuccess()) {
			return result;
		}
		result = new ResultMessage(false, "网络未连接");
		UserPO userPO = new UserPO(User.getUserName(), User.getPassword(), User.getPower());
		try {
			result = dataService.addUser(userPO);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}
	
	private ResultMessage idCheck(String id) {
		ResultMessage result = new ResultMessage(true, "");
		if(id.equals("admin")){
			return result;
		}
		if(id.length()!=10) {
			result.setSuccess(false);
			result.setErrorMessage("输入的位数不正确");
			return result;
		}
		for(int i = 0; i < id.length(); i++) {
			if(id.charAt(i)<'0'||id.charAt(i)>'9') {
				result.setSuccess(false);
				result.setErrorMessage("输入的格式不正确");
				return result;
			}
		}
		return result;
	}
	
	private ResultMessage passwordCheck(String password) {
		ResultMessage result = new ResultMessage(true, "");
		if(password.length()<6){
			result.setSuccess(false);
			result.setErrorMessage("位数太少");
		} else if (password.length()>9) {
			result.setSuccess(false);
			result.setErrorMessage("位数太多");
		}
		for(int i = 0; i < password.length(); i++) {
			char test = password.charAt(i);
			if(!((test>='0'&&test<='9')||(test>='a'&&test<='z')||(test>='A'&&test<='Z'))) {
				result.setSuccess(false);
				result.setErrorMessage("请不要出现除字母或数字以外的字符");
			}
		}
		return result;
	}

	public ArrayList<UserVO> findAllUser() {
		ArrayList<UserPO> users = null;
		try {
			users = dataService.getAllUser();
		} catch (RemoteException e) {
		}
		ArrayList<UserVO> usersVO = new ArrayList<UserVO>();
		for(UserPO user: users) {
			UserVO userVO = new UserVO(user.getUserName(), user.getPassword(), user.getPower());
			usersVO.add(userVO);
		}
		return usersVO;
	}
}
