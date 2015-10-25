package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.ResultMessage;
/**
 * manage the info of users
 * @author oppa
 *2015/10/25
 */
public interface UserDataService {
	/**
	 * add a user
	 * @param user
	 * @return ResultMessage
	 * @throws RemoteException
	 * @see UserPO ResultMessage
	 */
	public ResultMessage addUser(UserPO user) throws RemoteException;
	
	/**
	 * find the info of a user
	 * @param id
	 * @return UserPO
	 * @throws RemoteException
	 */
	public UserPO findUser(long id) throws RemoteException;
	
	/**
	 * delete the info of a user
	 * @param id
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deleteUser(long id) throws RemoteException;
	
	/**
	 * update the info of a user
	 * @param user
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage updateUser(UserPO user) throws RemoteException;
}
