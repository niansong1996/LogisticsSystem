package edu.nju.lms.businessLogicService.impl.transport;

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
import edu.nju.lms.dataService.TransportCommdityDataService;
import edu.nju.lms.dataService.TransportListDataService;
import edu.nju.lms.dataService.TransportToolDataService;

public class TransProcessblImpl implements TransProcessblService {
	TransportCommdityDataService commodity;
	TransportListDataService list;
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
		return new ResultMessage(true, "");
	}

	public ArrivalVO createArrivalList(ArrivalState state, String orderNum) {
		return new ArrivalVO("0000000000", ArrivalState.COMPLETE, "0000000000", "北京", "南京", "0000000000");
	}

	public ResultMessage saveArrivalList(ArrivalVO arrivalList) {
		return new ResultMessage(false, "");
	}

	public DispatchVO createDispatchList(String courierNum,String dispatchperson) {
		return new DispatchVO("0000000000", "zhangsan", "2015/01/04", "0000000000");
	}

	public ResultMessage saveDispatchList(DispatchVO dipatchList) {
		return new ResultMessage(true, "");
	}

	public ResultMessage saveTransportList(TransportVO transportInfor) {
		return new ResultMessage(true, "");
	}

}
