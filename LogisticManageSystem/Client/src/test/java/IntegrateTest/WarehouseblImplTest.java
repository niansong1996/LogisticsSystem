package IntegrateTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;

import mockObject.MockExpressItemInfo;
import mockObject.MockExpressList;

import org.junit.Test;

import edu.nju.lms.PO.Location;
import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.transport.TransProcessblImpl;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseManageblImpl;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseOpblImpl;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;

/**
 *@author tj
 *@date 2015年11月15日
 */
public class WarehouseblImplTest {
	WarehouseManageblImpl manage = new WarehouseManageblImpl();
	WarehouseOpblImpl operation = new WarehouseOpblImpl();
	MockExpressList expressList = new MockExpressList();
	ListController listController;
	TransportListDataService list;
	TransportCommodityDataService commodity;
	TransProcessblImpl trans= new TransProcessblImpl(listController,commodity,list);
	
	@Test
	public void testCheckWarehouseInfor() {
		Calendar start = Calendar.getInstance();
		start.set(2015,7,26);
		Calendar end = Calendar.getInstance();
		end.set(2015,8,28);
		String warehouseNum = "025000";
		InventoryExcelVO re = manage.checkWarehouseInfor(start, end, warehouseNum);
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("1458756100");
		CheckinVO checkin = new CheckinVO(null,null,expressNums,"2015/8/21", null);
		operation.createCheckinList(checkin, warehouseNum);
		Calendar s = Calendar.getInstance();
		s.set(2015,8,21);
		MockExpressItemInfo item1 = new MockExpressItemInfo("1458756100",s,"NanJing",new Location(PartitionType.AIRPLANE,2,2));
		expressList.addExpress(item1);
		manage.setExpressList(expressList);
		
		assertEquals(expressNums,re.getExpressNums());
	
	}

	@Test
	public void testExportExcel() {
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("4596125893");
		ArrayList<String> checkinTime = new ArrayList<String>();
		checkinTime.add("2015/2/18");
		ArrayList<String> destination = new ArrayList<String>();
		destination.add("南京");
		ArrayList<String> location = new ArrayList<String>();
		location.add("航空区2排3架5位");
		
		InventoryExcelVO excel = new InventoryExcelVO(expressNums, checkinTime, destination, location);
		
		String wareHouseNum = "025000";
		ResultMessage re = manage.exportExcel(excel, wareHouseNum);
		assertEquals(true,re.isSuccess());
	}

	@Test
	public void testSetCordon() {
		String warehouseNum = "025000";
		ResultMessage re1 = manage.setCordon(0.25, warehouseNum);
		ResultMessage re2 = manage.setCordon(100, warehouseNum);
		assertEquals(true,re1.isSuccess());
		assertEquals(false,re2.isSuccess());
	}

	@Test
	public void testShowPartition() {
		ArrayList<Partition> partition = new ArrayList<Partition>();
		Partition partition1 = new Partition(1000, 1, 200, PartitionType.AIRPLANE);
		Partition partition2 = new Partition(1000, 201, 400, PartitionType.CAR);
		Partition partition3 = new Partition(1000, 401, 600, PartitionType.FLEXIBLE);
		Partition partition4 = new Partition(1000, 601, 800, PartitionType.TRAIN);
		partition.add(partition1);
		partition.add(partition2);
		partition.add(partition3);
		partition.add(partition4);
		PartitionVO partitionVO = new PartitionVO(partition);
		manage.initialize(partitionVO, 0.25, "025000");
		PartitionVO test = manage.showPartition("025000");
		boolean is_same = test.equals(partitionVO);
		assertEquals(true,is_same);
		
	}

	@Test
	public void testModifyPartition() {
		ArrayList<Partition> partition = new ArrayList<Partition>();
		Partition partition1 = new Partition(1000, 1, 200, PartitionType.AIRPLANE);
		Partition partition2 = new Partition(1000, 201, 400, PartitionType.CAR);
		Partition partition3 = new Partition(1000, 401, 600, PartitionType.FLEXIBLE);
		Partition partition4 = new Partition(1000, 601, 800, PartitionType.TRAIN);
		partition.add(partition1);
		partition.add(partition2);
		partition.add(partition3);
		partition.add(partition4);
		PartitionVO partitionVO = new PartitionVO(partition);
		ResultMessage re = manage.modifyPartition(partitionVO, "025000");
		assertEquals(true,re.isSuccess());
	}

	@Test
	public void testInitialize() {
		ArrayList<Partition> partition = new ArrayList<Partition>();
		Partition partition1 = new Partition(1000, 1, 200, PartitionType.AIRPLANE);
		Partition partition2 = new Partition(1000, 201, 400, PartitionType.CAR);
		Partition partition3 = new Partition(1000, 401, 600, PartitionType.FLEXIBLE);
		Partition partition4 = new Partition(1000, 601, 800, PartitionType.TRAIN);
		partition.add(partition1);
		partition.add(partition2);
		partition.add(partition3);
		partition.add(partition4);
		PartitionVO partitionVO = new PartitionVO(partition);
		ResultMessage re = manage.initialize(partitionVO, 0.25, "025000");
		assertEquals(true,re.isSuccess());
	}
	
	@Test
	public void testCreateCheckinList(){
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("1458756100");
		Location l = new Location(PartitionType.AIRPLANE,32,2);
		CheckinVO checkin = new CheckinVO(null,l,expressNums,"2015/8/21", null);
		CheckinVO re = operation.createCheckinList(checkin, "025000");
		ArrayList<String>baseInfo = new ArrayList<String>();
		baseInfo.add("lily");
		baseInfo.add("南京大学仙林校区");
//		SendPO s = new SendPO("1458756100",ListState.WAITING,"0289630156",baseInfo,0,0,"goods",0,3);

//		CommodityPO c = new CommodityPO(s);
		assertEquals("南京大学仙林校区",re.getExDestination());
	}
	
	@Test
	public void testSaveCheckinList(){
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("1458756100");
		ArrayList<String> exDestination = new ArrayList<String>();
		exDestination.add("NanJing");
		Location l = new Location(PartitionType.AIRPLANE,32,2);
		CheckinVO checkin = new CheckinVO("025000",l,expressNums,"2015/8/21", exDestination);
		ResultMessage re = operation.saveCheckinList(checkin, "025000");
		assertEquals(true,re.isSuccess());
	}
	
	@Test
	public void testCreateCheckoutList(){
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("1458756100");
		CheckoutVO checkout = new CheckoutVO("025000",expressNums,"2015/8/21","Peking",null,
				"1234567895","5789412560");
		CheckoutVO test = operation.createCheckoutList(checkout, "025000");
		//ArrivalVO arrival = trans.saveArrivalList(ArrivalState.COMPLETE, "1458756100");
		//trans.saveArrivalList(arrival);
		//assertEquals(test.getArrivalNum(),arrival.getTransitNum());
	}
	
	@Test
	public void testSaveCheckoutList(){
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("1458756100");
		CheckoutVO checkout = new CheckoutVO("025000",expressNums,"2015/8/21","Peking",PartitionType.CAR,
				"1234567895","5789412560");
		ResultMessage result = operation.saveCheckoutList(checkout, "025000");
		assertEquals(true,result.isSuccess());
	}
}
