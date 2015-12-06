package edu.nju.lms.businessLogicService.impl.warehouse;

import java.util.ArrayList;

import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.WarehouseCheckinDataService;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;

public class WarehouseOpblImpl {
	private CheckinPO checkinPO;
	private CheckoutPO checkoutPO;
	
	private WarehouseCheckinDataService checkinData;
	private WarehouseCheckoutDataService checkoutData;
	
	public WarehouseOpblImpl(WarehouseCheckinDataService checkinData,WarehouseCheckoutDataService checkoutData,TransportController transportController){
		this.checkinData = checkinData;
		this.checkoutData = checkoutData;
	}
	
	public CheckinVO createCheckinList(CheckinVO baseMessage, String warehouseNum) {
		baseMessage.setCheckinDate(CommonUtility.getTime());
		for(String s : baseMessage.getExpresses()){
			
		}
		
		String[] expresses = {"124567895"};
		String[] exDestination = {"Shanghai"};
		return new CheckinVO("1234567990",null,null,"2015/4/6",null);
	}

	public ResultMessage saveCheckinList(CheckinVO checkinList, String warehouseNum) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public CheckoutVO createCheckoutList(CheckoutVO baseMessage, String warehouseNum) {
		// TODO Auto-generated method stub
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("145875610");
		return new CheckoutVO("0124567890",expressNums,"2015/8/21","Peking",PartitionType.CAR,
				"1234567895","5789412560");
	}

	public ResultMessage saveCheckoutList(CheckoutVO checkoutList, String warehouseNum) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}
}
