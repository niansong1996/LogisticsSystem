package edu.nju.lms.businessLogicService;

import java.util.ArrayList;

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
	
	/**
	 * check the {@link ListState} and {@link OrderInforVO}
	 *  of the {@link CommodityPO} 
	 * @param orderNum: id of the commodity
	 * @return OrderInforVO: state and track information of the commodity
	 * @see OrderInforVO 
	 */
	public OrderInforVO checkOrderInfor(String orderNum);
	/**
	 * complete {@link SendVO}
	 * @param baseMessage
	 * @return completed send list VO
	 * @see SendVO
	 */
	public SendVO createSendList(SendVO baseMessage);
	/**
	* save {@link SendVO}
	* @param sendList
	* @return ResultMessage
	* @see ResultMessage
	*/
	public ResultMessage saveSendList(SendVO sendList);
	
	public SendVO findSendList(String expressNum);
	
	public SendVO findSendListById(String expressNum);
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
	* @see ResultMessage
	*/
	public ResultMessage saveLoadList(LoadVO loadList);
	
	public LoadVO findLoadList(String id);
	
	public LoadCarVO findLoadCarList(String id);
	
	public ArrayList<LoadVO> findUnpaidLoad();
	
	/**
	 * complete {@link LoadCarVO}
	 * @param baseMessage
	 * @return completed loadCar list VO
	 * @see LoadCarVO
	 */
	public LoadCarVO createLoadCarList(LoadCarVO baseMessage);
	/**
	* save {@link LoadCarVO}
	* @param loadCarList
	* @return ResultMessage
	* @see ResultMessage
	*/
	public ResultMessage saveLoadCarList(LoadCarVO loadCarList);
	
	public ArrayList<LoadCarVO> findUnpaidLoadCar();

	
	/**
	 * complete {@link ArrivalVO}
	 * @param baseMessage
	 * @return completed Arrival list VO
	 * @see ArrivalVO
	 */
	public ArrivalVO createArrivalList(ArrivalVO arrivalList);
	/**
	* save {@link ArrivalVO}
	* @param arrivalList
	* @return ResultMessage
	* @see ResultMessage
	*/
	public ResultMessage saveArrivalList(ArrivalVO arrivalList);
	
	public ArrivalVO findArrivalList(String id);
	
	/**
	 * complete {@link DispatchVO}
	 * @param baseMessage
	 * @return completed Dispatch list VO
	 * @see DispatchVO
	 */
	public DispatchVO createDispatchList(DispatchVO dipatchList);
	/**
	* save {@link DispatchVO}
	* @param dispatchList
	* @return ResultMessage
	* @see ResultMessage
	*/
	public ResultMessage saveDispatchList(DispatchVO dipatchList);
	
	public DispatchVO findDispatchList(String id);
	
	/**
	 * complete {@link ReceiveVO}
	 * @param baseMessage
	 * @return completed Receive list VO
	 * @see ReceiveVO
	 */
	public ReceiveVO createReceiveList(ReceiveVO receiveList);
	/**
	* save {@link ReceiveVO}
	* @param receiveList
	* @return ResultMessage
	* @see ResultMessage
	*/
	public ResultMessage saveReceiveList(ReceiveVO receiveList);
	
	public ReceiveVO findReceiveList(String id);
	
	
}
