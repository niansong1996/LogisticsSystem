package edu.nju.lms.businessLogicService.impl;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.data.ResultMessage;

public class UserblImpl implements UserblService{

	public UserVO findUserInfo(String id) {
		return new UserVO("010101", "123456", "总经理");
	}

	public ResultMessage deleteUser(String id) {
		return new ResultMessage(true, "");
	}

	public ResultMessage updateUser(UserVO User) {
		return new ResultMessage(true, "");
	}

	public ResultMessage addUser(UserVO User) {
		return new ResultMessage(true, "");
	}

}
