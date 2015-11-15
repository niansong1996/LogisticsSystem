package edu.nju.lms.driver;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseManageblImpl;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseOpblImpl;
import edu.nju.lms.data.PartitionType;

public class WarehouseblService_Driver {
	public static void main(String[] args){
		WarehouseManageblImpl warehousemanagebl = new WarehouseManageblImpl();
		WarehouseOpblImpl warehouseopbl = new WarehouseOpblImpl();
		
		String warehouseNum = "5675467875";
		String[] ss =  {"6787653456"};
		ArrayList<String> sa = new ArrayList();
		sa.add(warehouseNum);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.set(2015, 10, 22);
		c2.set(2015, 10, 26);
		InventoryExcelVO excel = new InventoryExcelVO(null, null, null, null);
		PartitionVO partition = new PartitionVO(null);
		CheckinVO checkin = new CheckinVO(warehouseNum, null, warehouseNum, null);
		CheckoutVO checkout = new CheckoutVO(warehouseNum, sa, "2015/10/23","Nanjing", PartitionType.AIRPLANE, "6738473847", "6738473847");
		
		double cordon = 0.9;
		
		
		warehousemanagebl.checkWarehouseInfor(c1, c2, warehouseNum);
		warehousemanagebl.exportExcel(excel, warehouseNum);
		warehousemanagebl.initialize(partition, cordon, warehouseNum);
		warehousemanagebl.modifyPartition(partition, warehouseNum);
		warehousemanagebl.setCordon(cordon, warehouseNum);
		warehousemanagebl.showPartition(warehouseNum);
		
		warehouseopbl.createCheckinList(checkin, warehouseNum);
		warehouseopbl.createCheckoutList(checkout, warehouseNum);
		warehouseopbl.saveCheckinList(checkin, warehouseNum);
		warehouseopbl.saveCheckoutList(checkout, warehouseNum);
	}
}
