package edu.nju.lms.businessLogicService.impl.transport;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.CommodityPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.ReceivePO;
import edu.nju.lms.PO.SendPO;
import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.VO.ReceiveVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.CreateTime;
import edu.nju.lms.data.PackingType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.ShipState;
import edu.nju.lms.data.TransportMode;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;

public class TransProcessblImpl{
	TransportCommodityDataService commodity;
	TransportListDataService list;
	CreateTime getTime=new CreateTime();
	
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
		result.setCreateTime(getTime.returnTime());
		result.setPrice(calculateMoney(baseMessage.getPackingType(),baseMessage.getMode()));
		//TODO   time
		return result;
	}

	public ResultMessage saveSendList(SendVO sendList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		SendPO po=new SendPO(sendList.getExpressNum(),sendList.getState(),sendList.getId(),sendList.getBaseInfor(),sendList.getInitialNum(),sendList.getWeight(),
				sendList.getVolume(),sendList.getGoodsName(),sendList.getPackingType(),sendList.getMode(),sendList.getPrice(),sendList.getTime(),sendList.getCreateTime());
		try {
			result=list.addSend(po);
		} catch (RemoteException e) {
			// TODO
		}
		if(result.isSuccess()){
			ArrayList<String> loading=new ArrayList<String>();
			ArrayList<String> arrival=new ArrayList<String>();
			ArrayList<String> checkin=new ArrayList<String>();
			ArrayList<String> checkout=new ArrayList<String>();
			CommodityPO c=new CommodityPO(sendList.getExpressNum(),ShipState.RECEIPIENT,sendList.getId(),loading,arrival,"",checkin,checkout,"");
			try {
				commodity.addCommodity(c);
			} catch (RemoteException e) {}
		}
		return result;
	}

	public SendVO findSendList(String expressNum) {
		SendVO result=null;
		SendPO po=null;
		try {
			po=list.findSendList(expressNum);
		} catch (RemoteException e) {
			// TODO
		}
		if(po!=null){
			result=new SendVO(po.getExpressNum(),po.getId(),po.getBaseInfor(),po.getInitialNum(),po.getWeight(),
					po.getVolume(),po.getGoodsName(),po.getPackingType(),po.getMode(),po.getPrice(),po.getTime(),po.getCreateTime());
		}
		return result;
	}

	public LoadVO createLoadList(LoadVO baseMessage) {
		LoadVO result=baseMessage;
		result.setId(createLoadNum());
		result.setLoadDate(getTime.returnTime());
		return result;
	}

	public ResultMessage saveLoadList(LoadVO loadList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		LoadPO po=new LoadPO(loadList.getId(),loadList.getState().toString(),loadList.getLoadType(),getTime.changeToCal(loadList.getLoadDate()),
				loadList.getBusinessHallNum(),loadList.getMotorNum(),loadList.getDestiCity().getId(),loadList.getBusinessHallNum(),
				loadList.getVehicleNum(),loadList.getDriverNum(),loadList.getCommodityNums(),loadList.getFreight());
		try {
			result=list.addLoad(po);
		} catch (RemoteException e) {
			// TODO 
		}
		if(result.isSuccess()){
			ArrayList<String> temp=loadList.getCommodityNums(); 
			for(String num : temp){
				try {
					CommodityPO c=commodity.findCommodity(num);
					ArrayList<String> loading=c.getLoad();
					loading.add(loadList.getId());
					c.setLoad(loading);
					commodity.updateCommodity(c);
				} catch (RemoteException e) {}
			}
		}
		return result;
	}

	public LoadVO findLoadList(String id) {
		LoadVO result=null;
		LoadPO po=null;
		try {
			po=list.findLoadList(id);
		} catch (RemoteException e) {
			// TODO
		}
		if(po!=null){
			DepartmentController depart;
			try {
				depart = BusinessLogicFactory.getDepartmentController();
				CityVO city=depart.findCity(po.getDestiCity());
				result=new LoadVO(po.getId(),po.getLoadType(),getTime.changeToString(po.getLoadDate()),
						po.getBusinessHallNum(),po.getMotorNum(),city,po.getBusinessHallNum(),
						po.getVehicleNum(),po.getDriverNum(),po.getCommodityNums(),po.getFreight());
			} catch (NoBusinessLogicException e) {
			}
		}
		return result;
	}

	public ArrivalVO createArrivalList(ArrivalVO arrivalList) {
		ArrivalVO result=arrivalList;
		result.setId(createArrivalNum());
		result.setArrivalDate(getTime.returnTime());
		return result;
	}

	public ResultMessage saveArrivalList(ArrivalVO arrivalList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		ArrivalPO po=new ArrivalPO(arrivalList.getId(),arrivalList.getState().toString(),arrivalList.getArrivalState(),arrivalList.getExpressNum(),
				arrivalList.getDestination(),arrivalList.getSetOut(),getTime.changeToCal(arrivalList.getArrivalDate()));
		try {
			result=list.addArrival(po);
		} catch (RemoteException e) {
			// TODO 
		}
		if(result.isSuccess()){
			try {
				CommodityPO c=commodity.findCommodity(arrivalList.getExpressNum());
				ArrayList<String> arrival=c.getArrival();
				arrival.add(arrivalList.getId());
				c.setArrival(arrival);
				commodity.updateCommodity(c);
			} catch (RemoteException e) {}
		}
		return result;
	}

	public ArrivalVO findArrivalList(String id) {
		ArrivalVO result=null;
		ArrivalPO po=null;
		try {
			po=list.findArrival(id);
		} catch (RemoteException e) {
			// TODO
		}
		if(po!=null){
			result=new ArrivalVO(po.getId(),po.getArrivalState(), po.getExpressNum(), po.getDestination(),po.getSetOut(), getTime.changeToString(po.getArrivalDate()));
		}
		return result;
	}

	public DispatchVO createDispatchList(DispatchVO dispatchList) {
		DispatchVO result=dispatchList;
		result.setId(createDispatchNum());
		result.setArrivalDate(getTime.returnTime());
		return result;
	}

	public ResultMessage saveDispatchList(DispatchVO dipatchList) {
		// TODO Auto-generated method stub
		return null;
	}

	public DispatchVO findDispatchList(String id) {
		DispatchVO result=null;
		DispatchPO po=null;
		try {
			po=list.findDispatch(id);
		} catch (RemoteException e) {
			// TODO
		}
		if(po!=null){
			result=new DispatchVO(po.getId(),po.getDispatchPerson(),getTime.changeToString(po.getArrivalDate()),po.getExpressNum());
		}
		return result;
	}
	
	public ReceiveVO createReceiveList(ReceiveVO receiveList) {
		ReceiveVO result=receiveList;
		result.setId(createReceiveNum());
		result.setReceiveTime(getTime.returnTime());
		return result;
	}
	public ResultMessage saveReceiveList(ReceiveVO receiveList) {
		// TODO Auto-generated method stub
		return null;
	}
	public ReceiveVO findReceiveList(String id) {
		ReceiveVO receive=null;
		ReceivePO po=null;
		try {
			po=list.findReceive(id);
		} catch (RemoteException e) {
			// TODO
		}
		if(po!=null){
			receive=new ReceiveVO(po.getReceiverName(),po.getExpressNum());
		}
		return receive;
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
	
	public double calculateMoney(PackingType packingType, TransportMode mode){
		double money=0;
		FinanceController finance=null;
		try {
			finance=BusinessLogicFactory.getFinanceController();
		} catch (NoBusinessLogicException e) {}
		switch(packingType){
		case WOODENBOX:
			money+=10;
			break;
		case CARTON:
			money+=5;
			break;
		case BAG:
			money+=1;
		}
		switch(mode){
		case CHEAP:
			money+=finance.findPriceStrategy().getEconomic();
			break;
		case NORMAL:
			money+=finance.findPriceStrategy().getStandard();
			break;
		case FAST:
			money+=finance.findPriceStrategy().getExpress();
		}
		return money;
	}
}
