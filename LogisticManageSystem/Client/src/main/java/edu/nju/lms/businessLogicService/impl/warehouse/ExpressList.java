package edu.nju.lms.businessLogicService.impl.warehouse;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *@author tj
 *@date 2015年11月15日
 */
public class ExpressList {
	private ArrayList<ExpressItemInfo>  expresses;
	/**
	 * when add a check in list, add an express information object into the list
	 * @param expressNum
	 */
	public void addExpress(String expressNum){
		
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
