package edu.nju.lms.businessLogicService;

import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.data.ResultMessage;

/**
 * business logic service used for commodity to check in and check out
 * @author Cui
 * last modified: 2015-10-25 11:23:07
 */
public interface WarehouseOpblService {
	
	/**
	 * create {@link CheckinVO}
	 * @param baseMessage
	 * @param warehouseNum
	 * @return completed checkinVO
	 */
	public CheckinVO createCheckinList(CheckinVO baseMessage,long warehouseNum);
	
	/**
	 * save {@link CheckinVO}
	 * @param checkinList
	 * @param warehouseNum
	 * @return {@link ResultMessage}
	 */
	public ResultMessage saveCheckinList(CheckinVO checkinList, long warehouseNum);
	
	/**
	 * create {@link CheckoutVO}
	 * @param baseMessage
	 * @param warehouseNum
	 * @return completed {@link CheckoutVO}
	 */
	public CheckoutVO createCheckoutList(CheckoutVO baseMessage, long warehouseNum);
	
	/**
	 * save {@link CheckoutVO}
	 * @param checkoutList
	 * @param warehouseNum
	 * @return {@link ResultMessage}
	 */
	public ResultMessage saveCheckoutList(CheckoutVO checkoutList, long warehouseNum);
	
	

}
