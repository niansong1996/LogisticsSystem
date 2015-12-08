package edu.nju.lms.businessLogicService;

import java.util.Calendar;

import edu.nju.lms.PO.WarehousePO;
import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.VO.WarehouseInfoVO;
import edu.nju.lms.data.ResultMessage;

/**
 * business logic used to manage the basic info of a warehouse
 * 
 * @author Cui last modified: 2015-10-25 11:46:16
 */
public interface WareHouseblService {

	/**
	 * show the {@link InventoryExcelVO} during the period
	 * 
	 * @param start
	 * @param end
	 * @param warehouseNum
	 * @return {@link InventoryExcelVO}
	 */
	public InventoryExcelVO checkWarehouseInfor(Calendar start, Calendar end, String warehouseNum);

	/**
	 * export an excel file using {@link InventoryExcelVO}
	 * 
	 * @param excel
	 * @param wareHouseNum
	 * @return {@link ResultMessage}
	 */
	public ResultMessage exportExcel(InventoryExcelVO excel, String wareHouseNum);

	/**
	 * set the warning line of the warehouse
	 * 
	 * @param cordon
	 * @param warehouseNum
	 * @return {@link ResultMessage}
	 */
	public ResultMessage setCordon(double cordon, String warehouseNum);

	/**
	 * get the warning line of the warehouse
	 * 
	 * @param cordon
	 * @param warehouseNum
	 * @return {@link ResultMessage}
	 */
	public double getCordon(String warehouseNum);

	/**
	 * show {@link PartitionVO} information of the warehouse
	 * 
	 * @param warehouseNum
	 * @return {@link PartitionVO}
	 */
	public PartitionVO showPartition(String warehouseNum);

	/**
	 * find a {@link WarehousePO} by id, change its partition info using
	 * {@link PartitionVO}
	 * 
	 * @param modified
	 * @param warehouseNum
	 * @return {@link ResultMessage}
	 */
	public ResultMessage modifyPartition(PartitionVO modified, String warehouseNum);

	/**
	 * innitialize a {@link WarehousePO} using {@link PartitionVO}, cordon,
	 * warehouse number
	 * 
	 * @param partition
	 * @param cordon
	 * @param warehouseNum
	 * @return {@link ResultMessage}
	 */
	public ResultMessage initialize(PartitionVO partition, double cordon, String warehouseNum);

	/**
	 * business logic service used for commodity to check in and check out
	 * 
	 * @author Cui last modified: 2015-10-25 11:23:07
	 */
	public interface WarehouseOpblService {

		/**
		 * create {@link CheckinVO}
		 * 
		 * @param baseMessage
		 * @param warehouseNum
		 * @return completed checkinVO
		 */
		public CheckinVO createCheckinList(CheckinVO baseMessage, String warehouseNum);

		/**
		 * save {@link CheckinVO}
		 * 
		 * @param checkinList
		 * @param warehouseNum
		 * @return {@link ResultMessage}
		 */
		public ResultMessage saveCheckinList(CheckinVO checkinList, String warehouseNum);

		/**
		 * create {@link CheckoutVO}
		 * 
		 * @param baseMessage
		 * @param warehouseNum
		 * @return completed {@link CheckoutVO}
		 */
		public CheckoutVO createCheckoutList(CheckoutVO baseMessage, String warehouseNum);

		/**
		 * save {@link CheckoutVO}
		 * 
		 * @param checkoutList
		 * @param warehouseNum
		 * @return {@link ResultMessage}
		 */
		public ResultMessage saveCheckoutList(CheckoutVO checkoutList, String warehouseNum);
		/**
		 * show{@link WarehouseInfoVO}
		 * @param start
		 * @param end
		 * @param warehouseNum
		 * @return {@link WarehouseInfoVO}
		 */
		public WarehouseInfoVO showWarehouseInfo(Calendar start,Calendar end,String warehouseNum);
	}

}
