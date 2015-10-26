package edu.nju.lms.businessLogicService.impl;

import java.rmi.RemoteException;

import edu.nju.lms.PO.UserPO;
import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.UserDataService;

/**
 * 
 * @author Cui
 * 2015-10-26 09:46:03
 */
public class UserblImpl implements UserblService{
	
	private UserDataService dataService = null;
	
	public UserblImpl(UserDataService service) {
		setDataService(service);
	}
	
	public UserVO findUserInfo(String id) {
		UserPO userPO = null;
		UserVO user = null;
		try {
			userPO = dataService.findUser(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (userPO != null) {
			user = new UserVO(userPO.getUserName(), userPO.getPassword(), userPO.getPower());
		}
		return user;
	}

	public ResultMessage deleteUser(String id) {
		ResultMessage result = new ResultMessage(false, "网络未连接");
		try {
			result = dataService.deleteUser(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage updateUser(UserVO user) {
		ResultMessage result = new ResultMessage(false, "网络未连接");
		UserPO userPO = new UserPO(user.getUserName(), user.getPassword(), user.getPower());
		try {
			result = dataService.updateUser(userPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage addUser(UserVO User) {
		ResultMessage result = new ResultMessage(false, "网络未连接");
		UserPO userPO = new UserPO(User.getUserName(), User.getPassword(), User.getPower());
		try {
			result = dataService.addUser(userPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public UserDataService getDataService() {
		return dataService;
	}

	public void setDataService(UserDataService dataService) {
		this.dataService = dataService;
	}

}
