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
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage saveCheckinList(CheckinVO checkinList, String warehouseNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public CheckoutVO createCheckoutList(CheckoutVO baseMessage, String warehouseNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage saveCheckoutList(CheckoutVO checkoutList, String warehouseNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public InventoryExcelVO checkWarehouseInfor(Calendar start, Calendar end, String warehouseNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage exportExcel(InventoryExcelVO excel, String wareHouseNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage setCordon(double cordon, String warehouseNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public PartitionVO showPartition(String warehouseNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modifyPartition(PartitionVO modified, String warehouseNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage initialize(PartitionVO partition, double cordon, String warehouseNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
