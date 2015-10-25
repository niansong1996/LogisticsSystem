package edu.nju.lms.businessLogicService.impl;

import java.util.ArrayList;

import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.VO.TransportVO;
import edu.nju.lms.businessLogicService.TransProcessblService;
import edu.nju.lms.data.ArrivalState;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.ShipState;

public class TransProcessblImpl implements TransProcessblService {

	public OrderInforVO checkOrderInfor(String orderNum) {
		ArrayList<String> track = new ArrayList<String>();
		track.add("2015/01/01 8:00 : 快递员已收件");
		return new OrderInforVO(ShipState.RECEIPIENT, track, "0000000000");
	}

	public SendVO createSendList(SendVO baseMessage) {
		ArrayList<String> baseInfo = new ArrayList<String>();
		baseInfo.add("张三");
		return new SendVO("0000000000", "0000000000", baseInfo, 1, 1, "goods", 23, 1);
	}

	public ResultMessage saveSendList(SendVO sendList) {
		return new ResultMessage(true, "");
	}

	public LoadVO createLoadList(LoadVO baseMessage) {
		ArrayList<String> commodityNums = new ArrayList<String>();
		commodityNums.add("0000000000");
		commodityNums.add("0000000001");
		return new LoadVO("0000000000", "2015/01/02", "0250101", "0000000000", "0250102", "010101", "01",commodityNums , 23);
	}

	public ResultMessage saveLoadList(LoadVO loadList) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrivalVO createArrivalList(ArrivalState state, String orderNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage saveArrivalList(ArrivalVO arrivalList) {
		// TODO Auto-generated method stub
		return null;
	}

	public DispatchVO createDispatchList(String courierNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage saveDispatchList(DispatchVO dipatchList) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage saveTransportList(TransportVO transportInfor) {
		// TODO Auto-generated method stub
		return null;
	}

}
