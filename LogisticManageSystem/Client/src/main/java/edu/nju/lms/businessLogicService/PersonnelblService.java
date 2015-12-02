package edu.nju.lms.businessLogicService;

import java.util.ArrayList;

import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.data.ResultMessage;

/**
 * business logic service used to manage basic information
 * of personnel
 * @author Cui
 * last modified: 2015-10-25 11:53:44
 */
public interface PersonnelblService {
	
	/**
	 * find {@link PersonnelVO} by id
	 * @param id
	 * @return {@link PersonnelVO}
	 */
	public ArrayList<PersonnelVO> findPersonInfo(String id);
	
	/**
	 * find a {@link PersonnelPO} by id and then delete it
	 * @param id
	 * @return {@link ResultMessage}
	 * @see #findPersonInfo(long)
	 */
	public ResultMessage deletePersonnel(String id);
	
	/**
	 * find a {@link PersonnelPO} by id, then replace it using {@link PersonnelVO}
	 * @param Personnel
	 * @return {@link ResultMessage}
	 */
	public ResultMessage updatePersonnel(PersonnelVO Personnel);
	
	/**
	 * add a {@link PersonnelPO} using {@link PersonnelVO}
	 * @param Personnel
	 * @return {@link ResultMessage}
	 */
	public ResultMessage addPersonnel(PersonnelVO Personnel);
	
	/**
	 * update the money for courier when a receipt is created
	 */
	public ResultMessage updatePerTimes(String id,double amount);
	
	public ArrayList<PersonnelVO> showAllPersonnel();
}

