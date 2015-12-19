package edu.nju.lms.businessLogicService.impl.transport;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.CommodityPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.LoadcarPO;
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
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.City;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.NumRound;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.ShipState;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;

public class TransProcessblImpl{
	FinanceController financeController;

	public TransProcessblImpl(){
	}

	public OrderInforVO checkOrderInfor(TransportListDataService list,TransportCommodityDataService commodity,String orderNum){
		TransHistoryTrack historyTrack = new TransHistoryTrack();
		try {
			return historyTrack.getTrack(list,commodity,orderNum);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
			return null;
		}
	}

	public SendVO createSendList(ListController listController,DepartmentController departmentController,SendVO baseMessage) {
		SendVO result=baseMessage;
		result.setId(listController.applyListNum(ListType.SEND));
		result.setCreateTime(CommonUtility.getTime());
		result.setPrice(calculateMoney(departmentController,baseMessage));
		result.setTime(NumRound.round(Math.random()*3+1));
		return result;
	}

	public ResultMessage saveSendList(TransportListDataService list,TransportCommodityDataService commodity,SendVO sendList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		System.out.println(sendList.getCreateTime());
		SendPO po=new SendPO(sendList.getExpressNum(),sendList.getState(),sendList.getId(),sendList.getBaseInfor(),sendList.getSenderCity(),sendList.getReceiverCity(),sendList.getInitialNum(),sendList.getWeight(),
				sendList.getVolume(),sendList.getGoodsName(),sendList.getPackingType(),sendList.getMode(),sendList.getPrice(),sendList.getTime(),CommonUtility.String2Cal(sendList.getCreateTime()));
		System.out.println(po.getCreateTime().getTime());
		try {
			result=list.addSend(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		if(result.isSuccess()){
			ArrayList<String> loading=new ArrayList<String>();
			ArrayList<String> arrival=new ArrayList<String>();
			ArrayList<String> checkin=new ArrayList<String>();
			ArrayList<String> checkout=new ArrayList<String>();
			CommodityPO c=new CommodityPO(sendList.getExpressNum(),ShipState.RECEIPIENT,sendList.getId(),loading,arrival,"",checkin,checkout,"");
			try {
				commodity.addCommodity(c);
			} catch (RemoteException e) {
				return RemoteExceptionHandler.handleRemoteException(e);
			}
		}
		return result;
	}

	public SendVO findSendList(TransportListDataService list,String expressNum) {
		SendPO po=null;
		try {
			po=list.findSend(expressNum);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			return new SendVO(po.getExpressNum(),po.getId(),po.getBaseInfor(),po.getSenderCity(),po.getReceiverCity(),po.getInitialNum(),po.getWeight(),
					po.getVolume(),po.getGoodsName(),po.getPackingType(),po.getMode(),po.getPrice(),po.getTime(),CommonUtility.Cal2String(po.getCreateTime()));
		}else return null;
	}

	public LoadVO createLoadList(ListController listController,DepartmentController departmentController,LoadVO baseMessage) {
		LoadVO result=baseMessage;
		result.setId(listController.applyListNum(ListType.LOAD));
		result.setLoadDate(CommonUtility.getTime());
		result.setFreight(calculateFreight(departmentController,result));
		return result;
	}
	
	public ResultMessage saveLoadList(TransportListDataService list,TransportCommodityDataService commodity,LoadVO loadList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		LoadPO po=new LoadPO(loadList.getId(),loadList.getState().toString(),loadList.getLoadType(),CommonUtility.String2Cal(loadList.getLoadDate()),
				loadList.getBusinessHallNum(),loadList.getMotorNum(),loadList.getDestiCity(),loadList.getBusinessHallNum(),
				loadList.getVehicleNum(),loadList.getDriverNum(),loadList.getCommodityNums(),loadList.getFreight());
		try {
			result=list.addLoad(po);
			if(result.isSuccess()){
				ArrayList<String> temp=loadList.getCommodityNums(); 
				for(String num : temp){
					CommodityPO c=commodity.findCommodity(num);
					ArrayList<String> loading=c.getLoad();
					loading.add(loadList.getId());
					c.setLoad(loading);
					commodity.updateCommodity(c);
				}
			}
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public ArrayList<LoadVO> findUnpaidLoad(TransportListDataService list) {
		ArrayList<LoadVO> result=new ArrayList<LoadVO>();
		ArrayList<LoadPO> po=null;
		try {
			po=list.findUnpaidLoad();
		} catch (RemoteException e) {
			return result;
		}
		if(po!=null){
			for(LoadPO temp : po){
				LoadVO vo=new LoadVO(temp.getId(),temp.getLoadType(),CommonUtility.Cal2String(temp.getLoadDate()),
						temp.getBusinessHallNum(),temp.getMotorNum(),temp.getDestiCity(),temp.getBusinessHallNum(),
						temp.getVehicleNum(),temp.getDriverNum(),temp.getCommodityNums(),temp.getFreight());
				result.add(vo);
			}
		}
		return result;
	}
	
	public LoadCarVO createLoadCarList(ListController listController,LoadCarVO baseMessage) {
		LoadCarVO result=baseMessage;
		result.setId(listController.applyListNum(ListType.LOAD));
		result.setLoadDate(CommonUtility.getTime());
		int commodityNum=baseMessage.getCommodityNums().size();
		double freight=30*2*(commodityNum/100.0);
		result.setFreight(freight);
		return result;
	}

	public ResultMessage saveLoadCarList(TransportListDataService list,TransportCommodityDataService commodity,LoadCarVO loadCarList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		LoadcarPO po=new LoadcarPO(loadCarList.getId(),loadCarList.getState().toString(),CommonUtility.String2Cal(loadCarList.getLoadDate()),
				loadCarList.getBusinessHallNum(),loadCarList.getMotorNum(),loadCarList.getDestiBusinessHall(),loadCarList.getVehicleNum(),
				loadCarList.getDriverNum(),loadCarList.getCommodityNums(),loadCarList.getFreight());
		try {
			result=list.addLoadCar(po);
			if(result.isSuccess()){
				ArrayList<String> temp=loadCarList.getCommodityNums(); 
				for(String num : temp){
					CommodityPO c=commodity.findCommodity(num);
					ArrayList<String> loading=c.getLoad();
					loading.add(loadCarList.getId());
					c.setLoad(loading);
					commodity.updateCommodity(c);
				}
			}
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}
	
	public ArrayList<LoadCarVO> findUnpaidLoadCar(TransportListDataService list) {
		ArrayList<LoadCarVO> result=new ArrayList<LoadCarVO>();
		ArrayList<LoadcarPO> po=null;
		try {
			po=list.findUnpaidLoadCar();
		} catch (RemoteException e) {
			return result;
		}
		if(po!=null){
			for(LoadcarPO temp : po){
				LoadCarVO vo=new LoadCarVO(temp.getId(),CommonUtility.Cal2String(temp.getLoadDate()),
				temp.getBusinessHallNum(),temp.getMotorNum(),temp.getBusinessHallNum(),
				temp.getVehicleNum(),temp.getDriverNum(),temp.getCommodityNums(),temp.getFreight());
				result.add(vo);
			}
		}
		return result;
	}
	
	public ArrivalVO createArrivalList(ListController listController,ArrivalVO arrivalList) {
		ArrivalVO result=arrivalList;
		result.setId(listController.applyListNum(ListType.ARRIVAL));
		result.setArrivalDate(CommonUtility.getTime());
		return result;
	}

	public ResultMessage saveArrivalList(TransportListDataService list,TransportCommodityDataService commodity,ArrivalVO arrivalList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		ArrivalPO po=new ArrivalPO(arrivalList.getId(),arrivalList.getState().toString(),arrivalList.getArrivalState(),arrivalList.getExpressNum(),
				arrivalList.getDestination(),arrivalList.getSetOut(),CommonUtility.String2Cal(arrivalList.getArrivalDate()));
		try {
			result=list.addArrival(po);
			if(result.isSuccess()){
				CommodityPO c=commodity.findCommodity(arrivalList.getExpressNum());
				ArrayList<String> arrival=c.getArrival();
				arrival.add(arrivalList.getId());
				c.setArrival(arrival);
				commodity.updateCommodity(c);
			}
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public ArrivalVO findArrivalList(TransportListDataService list,String id) {
		ArrivalPO po=null;
		try {
			po=list.findArrival(id);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			return new ArrivalVO(po.getId(),po.getArrivalState(), po.getExpressNum(), po.getDestination(),po.getSetOut(), CommonUtility.Cal2String(po.getArrivalDate()));
		}else{
			return null;
		}
	}

	public DispatchVO createDispatchList(ListController listController,DispatchVO dispatchList) {
		DispatchVO result=dispatchList;
		result.setId(listController.applyListNum(ListType.DISPATCH));
		result.setArrivalDate(CommonUtility.getTime());
		return result;
	}

	public ResultMessage saveDispatchList(TransportListDataService list,TransportCommodityDataService commodity,DispatchVO dipatchList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		DispatchPO po=new DispatchPO(dipatchList.getId(),dipatchList.getState().toString(),dipatchList.getDispatchPerson(),CommonUtility.String2Cal(dipatchList.getArrivalDate()),dipatchList.getExpressNum());
		try {
			result=list.addDispatch(po);
			if(result.isSuccess()){
				CommodityPO c=commodity.findCommodity(dipatchList.getExpressNum());
				c.setDispatch(dipatchList.getId());
				commodity.updateCommodity(c);
			}
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public DispatchVO findDispatchList(TransportListDataService list,String id) {
		DispatchPO po=null;
		try {
			po=list.findDispatch(id);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			return new DispatchVO(po.getId(),po.getDispatchPerson(),CommonUtility.Cal2String(po.getArrivalDate()),po.getExpressNum());
		}else return null;
	}
	
	public ReceiveVO createReceiveList(ListController listController,ReceiveVO receiveList) {
		ReceiveVO result=receiveList;
		result.setId(listController.applyListNum(ListType.RECEIVE));
		result.setReceiveTime(CommonUtility.getTime());
		return result;
	}
	public ResultMessage saveReceiveList(TransportListDataService list,TransportCommodityDataService commodity,ReceiveVO receiveList) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		ReceivePO po=new ReceivePO(receiveList.getId(),receiveList.getState().toString(),receiveList.getReceiverName(),CommonUtility.String2Cal(receiveList.getReceiveTime()),receiveList.getExpressNum());
		try {
			result=list.addReceive(po);
			if(result.isSuccess()){
				CommodityPO c=commodity.findCommodity(receiveList.getExpressNum());
				c.setReceive(receiveList.getId());
				commodity.updateCommodity(c);
			}
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}
	public ReceiveVO findReceiveList(TransportListDataService list,String id) {
		ReceivePO po=null;
		try {
			po=list.findReceive(id);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			return new ReceiveVO(po.getId(),po.getReceiverName(),CommonUtility.Cal2String(po.getReceiveTime()),po.getExpressNum());
		}else{
			return null;
		}
	}
	
	public double calculateFreight(DepartmentController departmentController,LoadVO load){
		double result=1;
		CityVO current=departmentController.findCity(load.getBusinessHallNum().substring(0, 3));
		
		int temp=City.returnValue(load.getDestiCity());
		double distance=current.getDistance().get(temp-1);
		
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
	
	public double calculateMoney(DepartmentController departmentController,SendVO send){
		double money=0;
		double temp=0;
		CityVO current=departmentController.findCity(CommonUtility.cityNameToNum(send.getSenderCity()));
		int num=City.returnValue(send.getReceiverCity());
		double distance=current.getDistance().get(num-1);
		
		switch(send.getPackingType()){
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
		switch(send.getMode()){
		case CHEAP:
			temp=financeController.findPriceStrategy().getEconomic();
			money+=(distance/1000.0)*temp*send.getWeight();break;
		case NORMAL:
			temp=financeController.findPriceStrategy().getStandard();
			money+=(distance/1000.0)*temp*send.getWeight();break;
		case FAST:
			temp=financeController.findPriceStrategy().getExpress();
			money+=(distance/1000.0)*temp*send.getWeight();
		}
		money=NumRound.round(money);
		return money;
	}

	public LoadVO findLoadList(TransportListDataService list,String id) {
		LoadVO result = null;
		LoadPO po=null;
		try {
			po = list.findLoad(id);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			result = new LoadVO(po.getId(),po.getLoadType(),CommonUtility.Cal2String(po.getLoadDate()),po.getBusinessHallNum(),po.getMotorNum(),po.getDestiCity(),
					po.getDestiBusinessHall(),po.getVehicleNum(),po.getDriverNum(),po.getCommodityNums(),po.getFreight());
		}
		return result;
	}
	
	public LoadCarVO findLoadCarList(TransportListDataService list,String id) {
		LoadCarVO result = null;
		LoadcarPO po=null;
		try {
			po = list.findLoadCar(id);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			result = new LoadCarVO(po.getId(),CommonUtility.Cal2String(po.getLoadDate()),po.getBusinessHallNum(),po.getMotorNum(),
					po.getDestiBusinessHall(),po.getVehicleNum(),po.getDriverNum(),po.getCommodityNums(),po.getFreight());
		}
		return result;
	}

	public SendVO findSendListById(TransportListDataService list,String expressNum) {
		SendPO po=null;
		try {
			po=list.findSendById(expressNum);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			return new SendVO(po.getExpressNum(),po.getId(),po.getBaseInfor(),po.getSenderCity(),po.getReceiverCity(),po.getInitialNum(),po.getWeight(),
					po.getVolume(),po.getGoodsName(),po.getPackingType(),po.getMode(),po.getPrice(),po.getTime(),CommonUtility.Cal2String(po.getCreateTime()));
		}else return null;
	}
	
}
