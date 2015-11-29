package edu.nju.lms.businessLogicService.impl.transport;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.SendPO;
import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.ReceiveVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.PackingType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.TransportMode;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;

public class TransProcessblImpl{
	TransportCommodityDataService commodity;
	TransportListDataService list;
	
	private static int basicSendNum=0;
	private static int basicArrivalNum=0;
	private static int basicLoadNum=0;
	private static int basicDispatchNum=0;
	private static int basicReceiveNum=0;
	
	public TransProcessblImpl(TransportCommodityDataService commodity,TransportListDataService list){
		this.commodity=commodity;
		this.list=list;
	}

	public ArrayList<OrderInforVO> checkOrderInfor(String orderNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public SendVO createSendList(SendVO baseMessage) {
		SendVO result=baseMessage;
		result.setId(createSendNum());
		try {
			FinanceController finance=BusinessLogicFactory.getFinanceController();
			PriceStrategyVO price=finance.findPriceStrategy();
			//TODO
		} catch (NoBusinessLogicException e) {
		}
		return result;
	}

	public ResultMessage saveSendList(SendVO sendList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		
		SendPO po=new SendPO(sendList.getExpressNum(),sendList.getState(),sendList.getId(),sendList.getBaseInfor(),sendList.getInitialNum(),
				sendList.getWeight(),sendList.getVolume(),sendList.getGoodsName(),sendList.getPackingType(),sendList.getMode(),sendList.getPrice(),sendList.getTime());
		try {
			result=list.addSend(po);
		} catch (RemoteException e) {
			// TODO
		}
		
		return result;
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
	
	public ReceiveVO createReceiveList(ReceiveVO receiveList) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage saveReceiveList(ReceiveVO receiveList) {
		// TODO Auto-generated method stub
		return null;
	}
	public ReceiveVO findReceiveList(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String createSendNum(){
		String temp=String.valueOf(basicSendNum);
		while(temp.length()<8){
			temp="0"+temp;
		}
		String result="01"+temp;
		basicSendNum++;
		return result;
	}
	public String createArrivalNum(){
		String temp=String.valueOf(basicArrivalNum);
		while(temp.length()<8){
			temp="0"+temp;
		}
		String result="03"+temp;
		basicArrivalNum++;
		return result;
	}
	public String createLoadNum(){
		String temp=String.valueOf(basicLoadNum);
		while(temp.length()<8){
			temp="0"+temp;
		}
		String result="02"+temp;
		basicLoadNum++;
		return result;
	}
	public String createDispatchNum(){
		String temp=String.valueOf(basicDispatchNum);
		while(temp.length()<8){
			temp="0"+temp;
		}
		String result="04"+temp;
		basicDispatchNum++;
		return result;
	}
	public String createReceiveNum(){
		String temp=String.valueOf(basicReceiveNum);
		while(temp.length()<8){
			temp="0"+temp;
		}
		String result="07"+temp;
		basicReceiveNum++;
		return result;
	}
}
