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
import edu.nju.lms.data.PartitionType;
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
	public void reconnect(){
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
		if(vo==null){
			return -1;
		}
		ArrayList<Partition> info = vo.getPartitionInfor();
		int result = 0;
		for(Partition p :info){
			result+=p.getCapacity();
		}
		return result;
	}
	public ResultMessage setTotalRowNum(int num){
		ArrayList<Partition> lists = new ArrayList<Partition>();
		lists.add(new Partition(0,0,0,PartitionType.AIRPLANE));
		lists.add(new Partition(0,0,0,PartitionType.TRAIN));
		lists.add(new Partition(0,0,0,PartitionType.CAR));
		lists.add(new Partition(num,0,num-1,PartitionType.FLEXIBLE));
		PartitionVO vo =  new PartitionVO(lists);
		return this.initialize(vo, 90 , this.getCurrentWarehouseNum());
	}
	
	public int getAirRowNum(){
		PartitionVO partitions = warehouseManagebl.showPartition(warehouseData,this.getCurrentWarehouseNum());
		if(partitions==null){
			return 0;
		}
		return partitions.getPartitionInfor().get(0).getCapacity();
	}
	
	public int getTrainRowNum(){
		PartitionVO partitions = warehouseManagebl.showPartition(warehouseData,this.getCurrentWarehouseNum());
		if(partitions==null){
			return 0;
		}
		return partitions.getPartitionInfor().get(1).getCapacity();
	}
	
	public int getCarRowNum(){
		PartitionVO partitions = warehouseManagebl.showPartition(warehouseData,this.getCurrentWarehouseNum());
		if(partitions==null){
			return 0;
		}
		return partitions.getPartitionInfor().get(2).getCapacity();
	}
	
	public int getFlexibleRowNum(){
		PartitionVO partitions = warehouseManagebl.showPartition(warehouseData,this.getCurrentWarehouseNum());
		if(partitions==null){
			return 0;
		}
		return partitions.getPartitionInfor().get(3).getCapacity();
	}
	/**
	 * 调整航空区的容量 会造成机动区进行响应地调整，其他两个区不变 如果超出库存总排数 返回error
	 * 默认航空区排数从0开始，机动区最后
	 * 不用写调整机动区的方法
	 * @param capacity
	 */
	public ResultMessage setAirRowNum(int capacity){
		if(capacity<0||capacity>=this.getAirRowNum()+this.getTrainRowNum()+this.getCarRowNum()+this.getFlexibleRowNum())
			return new ResultMessage(false,"输入数字非法");
		int bias = capacity-this.getAirRowNum();
		if(bias>this.getFlexibleRowNum())
			return new ResultMessage(false,"空间不足以调整");
		PartitionVO partitions = this.showPartition(this.getCurrentWarehouseNum());
		Partition air = partitions.getPartitionInfor().get(0);
		Partition train	= partitions.getPartitionInfor().get(1);
		Partition car = partitions.getPartitionInfor().get(2);
		Partition flexible = partitions.getPartitionInfor().get(3);
		air.setEndRow(air.getEndRow()+bias);
		air.setCapacity(capacity);
		train.setStartRow(train.getStartRow()+bias);
		train.setEndRow(train.getEndRow()+bias);
		car.setStartRow(car.getStartRow()+bias);
		car.setEndRow(car.getEndRow()+bias);
		flexible.setStartRow(flexible.getStartRow()+bias);
		flexible.setEndRow(flexible.getEndRow()+bias);
		flexible.setCapacity(flexible.getCapacity()-bias);
		return this.modifyPartition(partitions, this.getCurrentWarehouseNum());
	}
	
	public ResultMessage setTrainRowNum(int capacity){
		if(capacity<0||capacity>=this.getAirRowNum()+this.getTrainRowNum()+this.getCarRowNum()+this.getFlexibleRowNum())
			return new ResultMessage(false,"输入数字非法");
		int bias = capacity-this.getTrainRowNum();
		if(bias>this.getFlexibleRowNum())
			return new ResultMessage(false,"空间不足以调整");
		PartitionVO partitions = this.showPartition(this.getCurrentWarehouseNum());
		Partition train	= partitions.getPartitionInfor().get(1);
		Partition car = partitions.getPartitionInfor().get(2);
		Partition flexible = partitions.getPartitionInfor().get(3);
		train.setCapacity(capacity);
		train.setEndRow(train.getEndRow()+bias);
		car.setStartRow(car.getStartRow()+bias);
		car.setEndRow(car.getEndRow()+bias);
		flexible.setStartRow(flexible.getStartRow()+bias);
		flexible.setEndRow(flexible.getEndRow()+bias);
		flexible.setCapacity(flexible.getCapacity()-bias);
		return this.modifyPartition(partitions, this.getCurrentWarehouseNum());
	}
	
	public ResultMessage setCarRowNum(int capacity){
		if(capacity<0||capacity>=this.getAirRowNum()+this.getTrainRowNum()+this.getCarRowNum()+this.getFlexibleRowNum())
			return new ResultMessage(false,"输入数字非法");
		int bias = capacity-this.getCarRowNum();
		if(bias>this.getFlexibleRowNum())
			return new ResultMessage(false,"空间不足以调整");
		PartitionVO partitions = this.showPartition(this.getCurrentWarehouseNum());

		Partition car = partitions.getPartitionInfor().get(2);
		Partition flexible = partitions.getPartitionInfor().get(3);

		car.setCapacity(capacity);
		car.setEndRow(car.getEndRow()+bias);
		flexible.setStartRow(flexible.getStartRow()+bias);
		flexible.setEndRow(flexible.getEndRow()+bias);
		flexible.setCapacity(flexible.getCapacity()-bias);
		return this.modifyPartition(partitions, this.getCurrentWarehouseNum());
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
