package mockObject;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.businessLogicService.impl.warehouse.ExpressItemInfo;
import edu.nju.lms.businessLogicService.impl.warehouse.ExpressList;

/**
 *@author tj
 *@date 2015年11月16日
 */
public class MockExpressList extends ExpressList{
	private ArrayList<ExpressItemInfo>  expresses;
	public MockExpressList(){
		expresses = new ArrayList<ExpressItemInfo>();
	}
	/**
	 * when add a check in list, add an express information object into the list
	 * @param expressNum
	 */
	public void addExpress(MockExpressItemInfo ei){
		
	}
	/**
	 * when add a check out list, delete an express information object into the list
	 * @param expressNum
	 */
	public void deleteExpress(String expressNum){
		
	}
	
	public void exportExcel(){
		
	}
	/**
	 * return the check out list numbers from start to end
	 * @param start
	 * @param end
	 */
	public int showCheckoutNum(Calendar start,Calendar end){
		return 0;
	}
	/**
	 * return the check in list numbers from start to end
	 * @param start
	 * @param end
	 */
	public int showCheckinNum(Calendar start,Calendar end){
		return 0;
	}
	/**
	 * return the inventory number
	 * @return
	 */
	public int showInventory(){
		return 0;
	}
}
