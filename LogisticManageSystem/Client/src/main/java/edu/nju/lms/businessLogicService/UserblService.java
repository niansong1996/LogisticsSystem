package edu.nju.lms.businessLogicService;

import java.util.ArrayList;

import edu.nju.lms.PO.UserPO;
import edu.nju.lms.VO.UserVO;
import edu.nju.lms.data.ResultMessage;

/**
 * business logic service used to manage basic information
 * of a user of the system
 * @author Cui
 * last modified: 2015-10-25 11:56:51
 */
public interface UserblService {

	/**
	 * find {@link UserVO} by id
	 * @param id
	 * @return {@link UserVO}
	 */
	public UserVO findUserInfo(String id);
	
	/**
	 * find a {@link UserPO} by id and then delete it
	 * @param id
	 * @return {@link ResultMessage}
	 * @see #findUserInfo(long)
	 */
	public ResultMessage deleteUser(String id);
	
	/**
	 * find a {@link UserPO} by id, then replace it using {@link UserVO}
	 * @param User
	 * @return {@link ResultMessage}
	 */
	public ResultMessage updateUser(UserVO User);
	
	/**
	 * add a {@link UserPO} using {@link UserVO}
	 * @param User
	 * @return {@link ResultMessage}
	 */
	public ResultMessage addUser(UserVO User);
	
	/**
	 * get all the user info
	 * @return {@link ArrayList}
	 */
	public ArrayList<UserVO> findAllUser();
}
