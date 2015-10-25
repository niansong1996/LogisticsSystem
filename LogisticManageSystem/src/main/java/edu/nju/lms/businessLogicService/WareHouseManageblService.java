package edu.nju.lms.businessLogicService;

import java.util.Calendar;

import edu.nju.lms.PO.WarehousePO;
import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.data.ResultMessage;

/**
 * business logic used to manage the basic info of a warehouse
 * @author Cui
 * last modified: 2015-10-25 11:46:16
 */
public interface WareHouseManageblService {
	
	/**
	 * show the {@link InventoryExcelVO} during the period
	 * @param start
	 * @param end
	 * @param warehouseNum
	 * @return {@link InventoryExcelVO}
	 */
	public InventoryExcelVO checkWarehouseInfor(Calendar start,
			Calendar end, long warehouseNum);

	/**
	 * export an excel file using {@link InventoryExcelVO}
	 * @param excel
	 * @param wareHouseNum
	 * @return {@link ResultMessage}
	 */
	public ResultMessage exportExcel(InventoryExcelVO excel, long wareHouseNum);
	
	/**
	 * set the cordon of the warehouse
	 * @param cordon
	 * @param warehouseNum
	 * @return {@link ResultMessage}
	 */
	public ResultMessage setCordon(double cordon, long warehouseNum);
	
	/**
	 * show {@link PartitionVO} information of the warehouse
	 * @param warehouseNum
	 * @return {@link PartitionVO}
	 */
	public PartitionVO showPartition(long warehouseNum);
	
	/**
	 * find a {@link WarehousePO} by id, change its partition info 
	 * using {@link PartitionVO}
	 * @param modified
	 * @param warehouseNum
	 * @return {@link ResultMessage}
	 */
	public ResultMessage modifyPartition(PartitionVO modified,long warehouseNum );
	
	/**
	 * innitialize a {@link WarehousePO} 
	 * using {@link PartitionVO}, cordon, warehouse number
	 * @param partition
	 * @param cordon
	 * @param warehouseNum
	 * @return {@link ResultMessage}
	 */
	public ResultMessage initialize (PartitionVO partition, double cordon, long warehouseNum);
}
