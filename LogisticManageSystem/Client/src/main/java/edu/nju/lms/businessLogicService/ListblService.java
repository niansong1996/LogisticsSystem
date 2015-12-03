package edu.nju.lms.businessLogicService;

import java.util.ArrayList;

import edu.nju.lms.PO.NumOccupancyPO;
import edu.nju.lms.VO.ListVO;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public interface ListblService {
	/**
	 *  to find if there exist list that has'nt checked
	 * @return
	 */
	public ArrayList<ListVO>  getListInfo(ListType type);
	
	public ArrayList<ListVO> getAllList();
	
	/**
	 * use id to find List，and change the data
	 * @param List
	 * @return
	 */
	public ResultMessage changeList(ListVO List,ListType type);
	/**
	 * use to store the occupancy of the used num of the lists
	 * @author nians
	 * 
	 */
	public NumOccupancyPO getNumOccupancy();
	
	public ResultMessage updateNumOccupancy(NumOccupancyPO numOccupancyPO);
	
}
