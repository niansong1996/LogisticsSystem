package edu.nju.lms.businessLogicService;

import edu.nju.lms.PO.CommodityPO;
import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.VO.TransportVO;
import edu.nju.lms.data.ArrivalState;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ResultMessage;

/**
 * Business services needed during the transport process, include creating
 * and saving lists and inquiring commodity state
 * @author Cui
 * Last modified: 2015-10-25 10:42:57
 */
public interface TransProcessblService {
	
	/**
	 * check the {@link ListState} and {@link OrderInforVO}
	 *  of the {@link CommodityPO} 
	 * @param orderNum: id of the commodity
	 * @return OrderInforVO: state and track information of the commodity
	 * @see OrderInforVO 
	 */
	public OrderInforVO checkOrderInfor(long orderNum);
	
	/**
	 * complete the {@link SendVO}
	 * @param baseMessage
	 * @return completed send list VO
	 */
	public SendVO createSendList(SendVO baseMessage);
	
	/**
	 * save {@link SendVO}
	 * @param sendList
	 * @return ResultMessage
	 * @see ResultMessage
	 */
	public ResultMessage saveSendList(SendVO sendList);
	
	/**
	 * complete {@link LoadVO}
	 * @param baseMessage
	 * @return completed load list VO
	 * @see LoadVO
	 */
	public LoadVO createLoadList(LoadVO baseMessage);
	
	/**
	 * save {@link LoadVO}
	 * @param loadList
	 * @return ResultMessage
	 * @see LoadVO
	 * @see ResultMessage
	 */
	public ResultMessage saveLoadList(LoadVO loadList);
	
	/**
	 * create {@link ArrivalVO}
	 * @param state
	 * @param orderNum
	 * @return ArrivalVO
	 * @see ArrivalVO 
	 * @see ArrivalState
	 */
	public ArrivalVO createArrivalList(ArrivalState state,long orderNum);
	
	/**
	 * save {@link ArrivalVO}
	 * @param arrivalList: ArrivalVO
	 * @return ResultMessage
	 * @see ResultMessage
	 * @see ArrivalVO
	 */
	public ResultMessage saveArrivalList(ArrivalVO arrivalList);
	
	/**
	 * create {@link DispatchVO}
	 * @param courierNum: long
	 * @return completed {@link DispatchVO}
	 * @see DispatchVO
	 */
	public DispatchVO createDispatchList(long courierNum);
	
	/**
	 * save {@link DispatchVO}
	 * @param dipatchList: {@link DispatchVO}
	 * @return {@link ResultMessage}
	 * @see ResultMessage
	 * @see DispatchVO
	 */
	public ResultMessage saveDispatchList(DispatchVO dipatchList);
	
	/**
	 * save {@link TransportVO}
	 * @param transportInfor: TransportVO
	 * @return {@link ResultMessage}
	 * @see ResultMessage
	 * @see TransportVO
	 */
	public ResultMessage saveTransportList(TransportVO transportInfor);
}
