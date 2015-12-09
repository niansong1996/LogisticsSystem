package IntegrateTest;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.ArrivalState;
import edu.nju.lms.data.ShipState;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;

public class TransprocessblImplTest {
	
	ListController listController;
	TransportListDataService list;
	TransportCommodityDataService commodity;
//	TransProcessblImpl process = new TransProcessblImpl(listController,commodity,list);
	
	@Test
	public void testSend() {
		ArrayList<String> baseInfo = new ArrayList<String>();
		baseInfo.add("张三");baseInfo.add("南京");baseInfo.add("南京大学");baseInfo.add("南京大学");baseInfo.add("12312341234");baseInfo.add("");
		baseInfo.add("李四");baseInfo.add("北京");baseInfo.add("北京大学");baseInfo.add("北京大学");baseInfo.add("12312341235");baseInfo.add("");
//		SendVO sendR = new SendVO("0000000000", "0000000000", baseInfo, 1, 1, "goods", 20.7, 1);
//		SendVO send = new SendVO("0000000000", "0000000000", baseInfo, 1, 1, "goods", -1, 1);
//		Assert.assertEquals(sendR, process.createSendList(send));
//		Assert.assertEquals(true, process.saveSendList(sendR).isSuccess());
	}
	
	/**
	 * add basic commodity information
	 */
	private void send() {
		ArrayList<String> baseInfo = new ArrayList<String>();
		baseInfo.add("张三");baseInfo.add("南京");baseInfo.add("南京大学");baseInfo.add("南京大学");baseInfo.add("12312341234");baseInfo.add("");
		baseInfo.add("李四");baseInfo.add("北京");baseInfo.add("北京大学");baseInfo.add("北京大学");baseInfo.add("12312341235");baseInfo.add("");
		//SendVO sendR = new SendVO("0000000000", "0000000000", baseInfo, 1, 1, "goods", 20.7, 1);
		//process.saveSendList(sendR);
	}
	
	@Test
	public void testLoad() {
		send();
		ArrayList<String> commodityNums = new ArrayList<String>();
		commodityNums.add("0000000000");
//		LoadVO loadR = new LoadVO("0000000000", "2015/01/02", "0250101", "0000000000", "0250102", "010101", "01",commodityNums , 23);
//		LoadVO load = new LoadVO("0000000000", "2015/01/02", "0250101", "0000000000", "0250102", "010101", "01",commodityNums , 23);
		//Assert.assertEquals(loadR, process.createLoadList(load));
		//Assert.assertEquals(true, process.saveLoadList(loadR).isSuccess());
	}
	
	@Test
	public void testDispatch() {
		send();
		DispatchVO dispatch = new DispatchVO("0000000000", "zhangsan", "2015/01/04", "0000000000");
		//Assert.assertEquals(dispatch, process.createDispatchList("0000000000", "zhangsan"));
	//	Assert.assertEquals(true, process.saveDispatchList(dispatch).isSuccess());
	}
	
	@Test
	public void testArrival() {
		send();
		ArrivalVO arrival = new ArrivalVO("0000000000", ArrivalState.COMPLETE, "0000000000", "北京", "南京", "0000000000");
		//Assert.assertEquals(arrival, process.createArrivalList(ArrivalState.COMPLETE, "0000000000"));
	//	Assert.assertEquals(true, process.saveArrivalList(arrival).isSuccess());
	}
	
	@Test
	public void testCheckInfo() {
		send();
		ArrayList<String> track = new ArrayList<String>();
		//TODO
		track.add("");
		OrderInforVO info = new OrderInforVO(ShipState.RECEIPIENT, track, "0000000000");
	//	Assert.assertEquals(info, process.checkOrderInfor("0000000000"));
		
	}

}
