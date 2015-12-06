package edu.nju.lms.businessLogicService.impl.transport;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.CommodityPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadCarPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.ReceivePO;
import edu.nju.lms.PO.SendPO;
import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.LoadCarVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.VO.ReceiveVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.City;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.NumRound;
import edu.nju.lms.data.PackingType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.ShipState;
import edu.nju.lms.data.TransportMode;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;

public class TransProcessblImpl{
	TransportCommodityDataService commodity;
	TransportListDataService list;
	
	ListController listController;
	DepartmentController departmentController;
	FinanceController financeController;
	
	public TransProcessblImpl(ListController listController,DepartmentController departmentController,TransportCommodityDataService commodity,TransportListDataService list){
		this.listController = listController;
		this.departmentController=departmentController;
		this.commodity=commodity;
		this.list=list;
	}

	public OrderInforVO checkOrderInfor(String orderNum){
		TransHistoryTrack historyTrack = new TransHistoryTrack(commodity,list);
		try {
			return historyTrack.getTrack(orderNum);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public SendVO createSendList(SendVO baseMessage) {
		SendVO result=baseMessage;
		result.setId(listController.applyListNum(ListType.SEND));
		result.setCreateTime(CommonUtility.getTime());
		result.setPrice(calculateMoney(baseMessage.getPackingType(),baseMessage.getMode()));
		result.setTime(NumRound.round(Math.random()*3+1));
		return result;
	}

	public ResultMessage saveSendList(SendVO sendList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		SendPO po=new SendPO(sendList.getExpressNum(),sendList.getState(),sendList.getId(),sendList.getBaseInfor(),sendList.getInitialNum(),sendList.getWeight(),
				sendList.getVolume(),sendList.getGoodsName(),sendList.getPackingType(),sendList.getMode(),sendList.getPrice(),sendList.getTime(),CommonUtility.String2Cal(sendList.getCreateTime()));
		try {
			result=list.addSend(po);
		} catch (RemoteException e) {
			return result;
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
			po=list.findSend(expressNum);
		} catch (RemoteException e) {
			return result;
		}
		if(po!=null){
			result=new SendVO(po.getExpressNum(),po.getId(),po.getBaseInfor(),po.getInitialNum(),po.getWeight(),
					po.getVolume(),po.getGoodsName(),po.getPackingType(),po.getMode(),po.getPrice(),po.getTime(),CommonUtility.Cal2String(po.getCreateTime()));
		}
		return result;
	}

	public LoadVO createLoadList(LoadVO baseMessage) {
		LoadVO result=baseMessage;
		result.setId(this.listController.applyListNum(ListType.LOAD));
		result.setLoadDate(CommonUtility.getTime());
		result.setFreight(calculateFreight(result));
		return result;
	}
	
	public ResultMessage saveLoadList(LoadVO loadList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		LoadPO po=new LoadPO(loadList.getId(),loadList.getState().toString(),loadList.getLoadType(),CommonUtility.String2Cal(loadList.getLoadDate()),
				loadList.getBusinessHallNum(),loadList.getMotorNum(),loadList.getDestiCity().getId(),loadList.getBusinessHallNum(),
				loadList.getVehicleNum(),loadList.getDriverNum(),loadList.getCommodityNums(),loadList.getFreight());
		try {
			result=list.addLoad(po);
		} catch (RemoteException e) {
			return result;
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

	public ArrayList<LoadVO> findUnpaidLoad() {
		ArrayList<LoadVO> result=new ArrayList<LoadVO>();
		ArrayList<LoadPO> po=null;
		try {
			po=list.findUnpaidLoad();
		} catch (RemoteException e) {
			return result;
		}
		if(po!=null){
			for(LoadPO temp : po){
				CityVO city=departmentController.findCity(temp.getDestiCity());
				LoadVO vo=new LoadVO(temp.getId(),temp.getLoadType(),CommonUtility.Cal2String(temp.getLoadDate()),
						temp.getBusinessHallNum(),temp.getMotorNum(),city,temp.getBusinessHallNum(),
						temp.getVehicleNum(),temp.getDriverNum(),temp.getCommodityNums(),temp.getFreight());
				result.add(vo);
			}
		}
		return result;
	}
	
	public LoadCarVO createLoadCarList(LoadCarVO baseMessage) {
		LoadCarVO result=baseMessage;
		result.setId(listController.applyListNum(ListType.LOAD));
		result.setLoadDate(CommonUtility.getTime());
		int commodityNum=baseMessage.getCommodityNums().size();
		double freight=30*2*(commodityNum/100.0);
		result.setFreight(freight);
		return result;
	}

	public ResultMessage saveLoadCarList(LoadCarVO loadCarList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		LoadCarPO po=new LoadCarPO(loadCarList.getId(),loadCarList.getState().toString(),CommonUtility.String2Cal(loadCarList.getLoadDate()),
				loadCarList.getBusinessHallNum(),loadCarList.getMotorNum(),loadCarList.getDestiBusinessHall(),loadCarList.getVehicleNum(),
				loadCarList.getDriverNum(),loadCarList.getCommodityNums(),loadCarList.getFreight());
		try {
			result=list.addLoadCar(po);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}
	
	public ArrayList<LoadCarVO> findUnpaidLoadCar() {
		ArrayList<LoadCarVO> result=new ArrayList<LoadCarVO>();
		ArrayList<LoadCarPO> po=null;
		try {
			po=list.findUnpaidLoadCar();
		} catch (RemoteException e) {
			return result;
		}
		if(po!=null){
			for(LoadCarPO temp : po){
				LoadCarVO vo=new LoadCarVO(temp.getId(),CommonUtility.Cal2String(temp.getLoadDate()),
				temp.getBusinessHallNum(),temp.getMotorNum(),temp.getBusinessHallNum(),
				temp.getVehicleNum(),temp.getDriverNum(),temp.getCommodityNums(),temp.getFreight());
				result.add(vo);
			}
		}
		return result;
	}
	
	public ArrivalVO createArrivalList(ArrivalVO arrivalList) {
		ArrivalVO result=arrivalList;
		result.setId(this.listController.applyListNum(ListType.ARRIVAL));
		result.setArrivalDate(CommonUtility.getTime());
		return result;
	}

	public ResultMessage saveArrivalList(ArrivalVO arrivalList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		ArrivalPO po=new ArrivalPO(arrivalList.getId(),arrivalList.getState().toString(),arrivalList.getArrivalState(),arrivalList.getExpressNum(),
				arrivalList.getDestination(),arrivalList.getSetOut(),CommonUtility.String2Cal(arrivalList.getArrivalDate()));
		try {
			result=list.addArrival(po);
		} catch (RemoteException e) {
			return result;
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
			return result;
		}
		if(po!=null){
			result=new ArrivalVO(po.getId(),po.getArrivalState(), po.getExpressNum(), po.getDestination(),po.getSetOut(), CommonUtility.Cal2String(po.getArrivalDate()));
		}
		return result;
	}

	public DispatchVO createDispatchList(DispatchVO dispatchList) {
		DispatchVO result=dispatchList;
		result.setId(this.listController.applyListNum(ListType.DISPATCH));
		result.setArrivalDate(CommonUtility.getTime());
		return result;
	}

	public ResultMessage saveDispatchList(DispatchVO dipatchList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		DispatchPO po=new DispatchPO(dipatchList.getId(),dipatchList.getState().toString(),dipatchList.getDispatchPerson(),CommonUtility.String2Cal(dipatchList.getArrivalDate()),dipatchList.getExpressNum());
		try {
			result=list.addDispatch(po);
		} catch (RemoteException e1) {
			return result;
		}
		if(result.isSuccess()){
			try {
				CommodityPO c=commodity.findCommodity(dipatchList.getExpressNum());
				c.setDispatch(dipatchList.getId());;
				commodity.updateCommodity(c);
			} catch (RemoteException e) {}
		}
		return result;
	}

	public DispatchVO findDispatchList(String id) {
		DispatchVO result=null;
		DispatchPO po=null;
		try {
			po=list.findDispatch(id);
		} catch (RemoteException e) {
			return result;
		}
		if(po!=null){
			result=new DispatchVO(po.getId(),po.getDispatchPerson(),CommonUtility.Cal2String(po.getArrivalDate()),po.getExpressNum());
		}
		return result;
	}
	
	public ReceiveVO createReceiveList(ReceiveVO receiveList) {
		ReceiveVO result=receiveList;
		result.setId(this.listController.applyListNum(ListType.RECEIVE));
		result.setReceiveTime(CommonUtility.getTime());
		return result;
	}
	public ResultMessage saveReceiveList(ReceiveVO receiveList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		ReceivePO po=new ReceivePO(receiveList.getId(),receiveList.getState().toString(),receiveList.getReceiverName(),CommonUtility.String2Cal(receiveList.getReceiveTime()),receiveList.getExpressNum());
		try {
			result=list.addReceive(po);
		} catch (RemoteException e) {
			return result;
		}
		if(result.isSuccess()){
			try {
				CommodityPO c=commodity.findCommodity(receiveList.getExpressNum());
				c.setReceive(receiveList.getId());
				commodity.updateCommodity(c);
			} catch (RemoteException e) {}
		}
		return result;
	}
	public ReceiveVO findReceiveList(String id) {
		ReceiveVO receive=null;
		ReceivePO po=null;
		try {
			po=list.findReceive(id);
		} catch (RemoteException e) {
			return receive;
		}
		if(po!=null){
			receive=new ReceiveVO(po.getId(),po.getReceiverName(),CommonUtility.Cal2String(po.getReceiveTime()),po.getExpressNum());
		}
		return receive;
	}
	
	public double calculateFreight(LoadVO load){
		double result=1;
		CityVO current=departmentController.findCity(load.getBusinessHallNum().substring(0, 3));
		CityVO destiny=load.getDestiCity();
		
		int temp=City.returnValue(destiny.getName());
		double distance=current.getDistance().get(temp+1);
		
		int commodityNum=load.getCommodityNums().size();
		switch(load.getLoadType()){
		case AIRPLANE:
			result=distance*20*(commodityNum/100.0); return result;
		case TRAIN:
			result=distance*(0.2)*(commodityNum/100.0); return result;
		case CAR:
			result=distance*2*(commodityNum/100.0); return result;
		}
		result=NumRound.round(result);
		return result;
	}
	
	public double calculateMoney(PackingType packingType, TransportMode mode){
		double money=0;
		switch(packingType){
		case WOODENBOX:
			money+=10;break;
		case CARTON:
			money+=5;break;
		case BAG:
			money+=1;
		}
		if(financeController==null){
			financeController=BusinessLogicFactory.createFinanceController();
		}
		switch(mode){
		case CHEAP:
			money+=financeController.findPriceStrategy().getEconomic();break;
		case NORMAL:
			money+=financeController.findPriceStrategy().getStandard();break;
		case FAST:
			money+=financeController.findPriceStrategy().getExpress();
		}
		return money;
	}
}
