package edu.nju.lms.businessLogicService;

import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.LoadCarVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.VO.ReceiveVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.data.ResultMessage;

/**
 * Business services needed during the transport process, include creating
 * and saving lists and inquiring commodity state
 * @author Cui
 * Last modified: 2015-10-25 10:42:57
 */
public interface TransProcessblService {
	
	public OrderInforVO checkOrderInfor(String orderNum);
	
	public SendVO createSendList(SendVO baseMessage);
	
	public ResultMessage saveSendList(SendVO sendList);
	
	public SendVO findSendList(String expressNum);
	
	
	public LoadVO createLoadList(LoadVO baseMessage);

	public ResultMessage saveLoadList(LoadVO loadList);
	
	public LoadVO findLoadList(String id);
	
	
	public LoadCarVO createLoadCarList(LoadCarVO baseMessage);

	public ResultMessage saveLoadCarList(LoadCarVO loadCarList);
	
	public LoadCarVO findLoadCarList(String id);
	
	
	public ArrivalVO createArrivalList(ArrivalVO arrivalList);

	public ResultMessage saveArrivalList(ArrivalVO arrivalList);
	
	public ArrivalVO findArrivalList(String id);
	

	public DispatchVO createDispatchList(DispatchVO dipatchList);

	public ResultMessage saveDispatchList(DispatchVO dipatchList);
	
	public DispatchVO findDispatchList(String id);
	
	
	public ReceiveVO createReceiveList(ReceiveVO receiveList);

	public ResultMessage saveReceiveList(ReceiveVO receiveList);
	
	public ReceiveVO findReceiveList(String id);
	
}
