package edu.nju.lms.businessLogicService.impl.warehouse;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.VO.WarehouseInfoVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.WareHouseblService;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.utility.DataServiceFactory;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.WarehouseCheckinDataService;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;
import edu.nju.lms.dataService.WarehouseDataService;

/**
 *@author tj
 *@date 2015年11月15日
 */
public class WarehouseController implements WareHouseblService{
	private WarehouseManageblImpl warehouseManagebl;
	private WarehouseOpblImpl warehouseOpbl;
	private LogController logController;
	private ListController listController;
	private WarehouseDataService warehouseData;
	private WarehouseCheckinDataService warehouseCheckinData;
	private WarehouseCheckoutDataService warehouseCheckoutData;
	public WarehouseController(){
		try {
			logController=BusinessLogicFactory.getLogController();
			listController=BusinessLogicFactory.getListController();
			warehouseData= DataServiceFactory.getWarehouseDataService();
			warehouseCheckinData = DataServiceFactory.getWarehouseCheckinDataService();
			warehouseCheckoutData = DataServiceFactory.getWarehouseCheckoutDataService();
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
		
		warehouseManagebl = new WarehouseManageblImpl();
		warehouseOpbl = new WarehouseOpblImpl();

	}
	
	public CheckinVO createCheckinList(CheckinVO baseMessage, String warehouseNum) {
		return warehouseOpbl.createCheckinList(baseMessage, warehouseNum);
	}

	public ResultMessage saveCheckinList(CheckinVO checkinList, String warehouseNum) {
		logController.addLog("对仓库"+warehouseNum+"创建入库单");
		return warehouseOpbl.saveCheckinList(warehouseData,warehouseCheckinData,checkinList, warehouseNum,listController);
	}

	public CheckoutVO createCheckoutList(CheckoutVO baseMessage, String warehouseNum) {
		return warehouseOpbl.createCheckoutList(baseMessage, warehouseNum);
	}

	public ResultMessage saveCheckoutList(CheckoutVO checkoutList, String warehouseNum) {
		logController.addLog("对仓库"+warehouseNum+"创建出库单");
		return warehouseOpbl.saveCheckoutList(warehouseData,warehouseCheckoutData,checkoutList, warehouseNum,listController);
	}

	public InventoryExcelVO checkWarehouseInfor(Calendar start, Calendar end, String warehouseNum) {
		logController.addLog("对仓库"+warehouseNum+"查看库存信息");
		return warehouseManagebl.checkWarehouseInfor(warehouseData,start, end, warehouseNum);
	}

	public ResultMessage exportExcel(InventoryExcelVO excel, String warehouseNum) {
		logController.addLog("对仓库"+warehouseNum+"导出Excel表格");
		return warehouseManagebl.exportExcel(excel, warehouseNum);
	}

	public ResultMessage setCordon(double cordon, String warehouseNum) {
		logController.addLog("对仓库"+warehouseNum+"设置警戒值");
		return warehouseManagebl.setCordon(warehouseData,cordon, warehouseNum);
	}

	public PartitionVO showPartition(String warehouseNum) {
		logController.addLog("对仓库"+warehouseNum+"查看分区");
		return warehouseManagebl.showPartition(warehouseData,warehouseNum);
	}

	public ResultMessage modifyPartition(PartitionVO modified, String warehouseNum) {
		logController.addLog("对仓库"+warehouseNum+"修改分区");
		return warehouseManagebl.modifyPartition(warehouseData,modified, warehouseNum);
	}

	public ResultMessage initialize(PartitionVO partition, double cordon, String warehouseNum) {
		logController.addLog("对仓库"+warehouseNum+"进行初始化");
		return warehouseManagebl.initialize(warehouseData,partition, cordon, warehouseNum);
	}
	
	public double getCordon(String warehouseNum) {
		return warehouseManagebl.getCordon(warehouseData,warehouseNum);
	}
	
	public WarehouseInfoVO showWarehouseInfo(Calendar start, Calendar end, String warehouseNum) {
		return warehouseOpbl.showWarehouseInfo(warehouseData,warehouseCheckinData,warehouseCheckoutData,start,end,warehouseNum);
	}
	
	public CheckinVO findCheckinList(String id) {
		return warehouseOpbl.findCheckinList(warehouseCheckinData,id);
	}

	public CheckoutVO findCheckoutList(String id) {
		return warehouseOpbl.findCheckoutList(warehouseCheckoutData,id);
	}
	
	public String getCurrentWarehouseNum(){
		return logController.getLogId().substring(0, 6);
	}
	
	public int getTotalRowNum(){
		PartitionVO vo = warehouseManagebl.showPartition(warehouseData,getCurrentWarehouseNum());
		ArrayList<Partition> info = vo.getPartitionInfor();
		int result = 0;
		for(Partition p :info){
			result+=p.getCapacity();
		}
		return result;
	}
/*//for test

	public static void main(String[] args){
//		WarehouseController warehouseController = BusinessLogicFactory.createWarehouseController();
//		ArrayList<String> expresses = new ArrayList<String>();
//		ArrayList<String> exdestination = new ArrayList<String>();
//		ArrayList<Location> locations = new ArrayList<Location>();
//		CheckoutVO checkin = new CheckoutVO("8765467687",expresses,exdestination,LoadType.AIRPLANE,"899884","232424");
//		CheckoutVO tmp = warehouseController.createCheckoutList(checkin,"9876237262");
//		warehouseController.saveCheckoutList(tmp, "8765467687");
//		warehouseController.listController.saveListNum();
		
//		WarehouseController warehouseController = BusinessLogicFactory.createWarehouseController();
//		InventoryExcelVO excel = warehouseController.checkWarehouseInfor(CommonUtility.String2Cal("2014-01-01 00:00:00"), CommonUtility.String2Cal("2016-01-01 00:00:00"), "1234567890");
//		for(int i=0;i<excel.getDestination().size();i++){
//			System.out.println(excel.getExpressNums().get(i)+" "+excel.getCheckinTime().get(i)+" "+excel.getCheckinTime().get(i)+" "+excel.getLocation().get(i));
//		}
//		PartitionVO partition = warehouseController.showPartition("1234567890");
//		for(Partition p :partition.getPartitionInfor()){
//			System.out.println(p);
//		}
		
		WarehouseController warehouseController = BusinessLogicFactory.createWarehouseController();
		Partition p1 = new Partition(999,2,1000,PartitionType.AIRPLANE);
		Partition p2 = new Partition(1001,1500,500,PartitionType.TRAIN);
		Partition p3 = new Partition(1501,1700,200,PartitionType.CAR);
		Partition p4 = new Partition(1701,2000,300,PartitionType.FLEXIBLE);
		ArrayList<Partition> partitionInfor = new ArrayList<Partition>();
		partitionInfor.add(p1);
		partitionInfor.add(p2);
		partitionInfor.add(p3);
		partitionInfor.add(p4);
		
		PartitionVO partition = new PartitionVO(partitionInfor);
		
//		warehouseController.modifyPartition(partition, "1234567890");
		
//		warehouseController.initialize(partition, 0.7, "1234567890");
		
		warehouseController.setCordon(0.5, "1234567890");
	}
	*/

	

	
}
