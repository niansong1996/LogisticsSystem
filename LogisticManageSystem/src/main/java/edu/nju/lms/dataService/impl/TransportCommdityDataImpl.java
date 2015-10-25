package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.CommodityPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.Location;
import edu.nju.lms.PO.ReceivePO;
import edu.nju.lms.PO.SendPO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.data.ArrivalState;
import edu.nju.lms.data.LoadType;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;

import edu.nju.lms.dataService.TransportCommdityDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class TransportCommdityDataImpl implements TransportCommdityDataService {

	public ResultMessage addCommodity(CommodityPO commodity) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public CommodityPO findCommodity(String id) throws RemoteException {
		// TODO Auto-generated method stub
	
		ArrayList<String> baseInfo = new ArrayList<String>();
		baseInfo.add("du");
	
		return new CommodityPO(new SendPO("0000000000", "0000000000", baseInfo, 1, 1, "goods", 23, 1));
	}

	public ResultMessage deleteCommodity(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateCommodity(CommodityPO commodity) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
