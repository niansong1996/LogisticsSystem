package edu.nju.lms.businessLogicService.impl.warehouse;

import java.rmi.Naming;
import java.util.Calendar;

import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.WareHouseblService;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.WarehouseCheckinDataService;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;
import edu.nju.lms.dataService.WarehouseDataService;

/**
 *@author tj
 *@date 2015年11月15日
 */
public class WarehouseController implements WareHouseblService{
	WarehouseManageblImpl warehouseManagebl;
	WarehouseOpblImpl warehouseOpbl;
	LogController logController;
	ListController listController;
	WarehouseDataService warehouseData;
	WarehouseCheckinDataService warehouseCheckinData;
	WarehouseCheckoutDataService warehouseCheckoutData;
	public WarehouseController(){
		try {
			logController=BusinessLogicFactory.getLogController();
			listController=BusinessLogicFactory.getListController();
			warehouseData=(WarehouseDataService) Naming.lookup("//127.0.0.1:1099/WarehouseDataService"); 
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("网络未连接");
		}
		

		warehouseManagebl = new WarehouseManageblImpl(warehouseData);
		warehouseOpbl = new WarehouseOpblImpl(warehouseData,warehouseCheckinData,warehouseCheckoutData,listController);



	}
	public CheckinVO createCheckinList(CheckinVO baseMessage, String warehouseNum) {
		return warehouseOpbl.createCheckinList(baseMessage, warehouseNum);
	}

	public ResultMessage saveCheckinList(CheckinVO checkinList, String warehouseNum) {
		return warehouseOpbl.saveCheckinList(checkinList, warehouseNum);
	}

	public CheckoutVO createCheckoutList(CheckoutVO baseMessage, String warehouseNum) {
		return warehouseOpbl.createCheckoutList(baseMessage, warehouseNum);
	}

	public ResultMessage saveCheckoutList(CheckoutVO checkoutList, String warehouseNum) {
		return warehouseOpbl.saveCheckoutList(checkoutList, warehouseNum);
	}

	public InventoryExcelVO checkWarehouseInfor(Calendar start, Calendar end, String warehouseNum) {
		return warehouseManagebl.checkWarehouseInfor(start, end, warehouseNum);
	}

	public ResultMessage exportExcel(InventoryExcelVO excel, String wareHouseNum) {
		return warehouseManagebl.exportExcel(excel, wareHouseNum);
	}

	public ResultMessage setCordon(double cordon, String warehouseNum) {
		return warehouseManagebl.setCordon(cordon, warehouseNum);
	}

	public PartitionVO showPartition(String warehouseNum) {
		return warehouseManagebl.showPartition(warehouseNum);
	}

	public ResultMessage modifyPartition(PartitionVO modified, String warehouseNum) {
		return warehouseManagebl.modifyPartition(modified, warehouseNum);
	}

	public ResultMessage initialize(PartitionVO partition, double cordon, String warehouseNum) {
		return warehouseManagebl.initialize(partition, cordon, warehouseNum);
	}

}
