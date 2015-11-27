package edu.nju.lms.businessLogicService.impl.transport;

import java.util.ArrayList;

import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.LoadCarVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.businessLogicService.TransProcessblService;
import edu.nju.lms.data.ArrivalState;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.ShipState;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;
import edu.nju.lms.dataService.TransportToolDataService;

public class TransProcessblImpl{
	TransportCommodityDataService commodity;

	public ArrayList<OrderInforVO> checkOrderInfor(String orderNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addOrderInfor(OrderInforVO orderInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public SendVO createSendList(SendVO baseMessage) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage saveSendList(SendVO sendList) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateSengdList(SendVO sendList) {
		// TODO Auto-generated method stub
		return null;
	}

	public SendVO findSendList(String expressNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public LoadVO createLoadList(LoadVO baseMessage) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage saveLoadList(LoadVO loadList) {
		// TODO Auto-generated method stub
		return null;
	}

	public LoadVO findLoadList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrivalVO createArrivalList(ArrivalVO arrivalList) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage saveArrivalList(ArrivalVO arrivalList) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrivalVO findArrivalList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public DispatchVO createDispatchList(DispatchVO dipatchList) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage saveDispatchList(DispatchVO dipatchList) {
		// TODO Auto-generated method stub
		return null;
	}

	public DispatchVO findDispatchList(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
