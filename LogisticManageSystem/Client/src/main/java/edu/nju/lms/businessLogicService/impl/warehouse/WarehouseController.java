package edu.nju.lms.businessLogicService.impl.warehouse;

import java.util.Calendar;

import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.businessLogicService.WareHouseblService;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年11月15日
 */
public class WarehouseController implements WareHouseblService {
	WarehouseManageblImpl managebl;
	WarehouseOpblImpl opbl;
	public CheckinVO createCheckinList(CheckinVO baseMessage, String warehouseNum) {
		return opbl.createCheckinList(baseMessage, warehouseNum);
	}

	public ResultMessage saveCheckinList(CheckinVO checkinList, String warehouseNum) {
		return opbl.saveCheckinList(checkinList, warehouseNum);
	}

	public CheckoutVO createCheckoutList(CheckoutVO baseMessage, String warehouseNum) {
		return opbl.createCheckoutList(baseMessage, warehouseNum);
	}

	public ResultMessage saveCheckoutList(CheckoutVO checkoutList, String warehouseNum) {
		return opbl.saveCheckoutList(checkoutList, warehouseNum);
	}

	public InventoryExcelVO checkWarehouseInfor(Calendar start, Calendar end, String warehouseNum) {
		return managebl.checkWarehouseInfor(start, end, warehouseNum);
	}

	public ResultMessage exportExcel(InventoryExcelVO excel, String wareHouseNum) {
		return managebl.exportExcel(excel, wareHouseNum);
	}

	public ResultMessage setCordon(double cordon, String warehouseNum) {
		return managebl.setCordon(cordon, warehouseNum);
	}

	public PartitionVO showPartition(String warehouseNum) {
		return managebl.showPartition(warehouseNum);
	}

	public ResultMessage modifyPartition(PartitionVO modified, String warehouseNum) {
		return managebl.modifyPartition(modified, warehouseNum);
	}

	public ResultMessage initialize(PartitionVO partition, double cordon, String warehouseNum) {
		return managebl.initialize(partition, cordon, warehouseNum);
	}

}
