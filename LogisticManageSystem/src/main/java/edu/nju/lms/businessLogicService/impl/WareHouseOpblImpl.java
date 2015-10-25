package edu.nju.lms.businessLogicService.impl;

import java.util.ArrayList;

import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.businessLogicService.WarehouseOpblService;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;

public class WareHouseOpblImpl implements WarehouseOpblService {

	public CheckinVO createCheckinList(CheckinVO baseMessage, String warehouseNum) {
		return new CheckinVO("1234567990",new String[20],"2015/4/6",new String[20]);
	}

	public ResultMessage saveCheckinList(CheckinVO checkinList, String warehouseNum) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public CheckoutVO createCheckoutList(CheckoutVO baseMessage, String warehouseNum) {
		// TODO Auto-generated method stub
		return new CheckoutVO("0124567890",new ArrayList<String>(),"2015/8/21","Peking",PartitionType.CAR,
				"1234567895","5789412560");
	}

	public ResultMessage saveCheckoutList(CheckoutVO checkoutList, String warehouseNum) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

}
