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
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.LoadType;
import edu.nju.lms.data.ShipState;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;

/**
 * 
 * @author nians
 *
 */
public class TransHistoryTrack {

	public TransHistoryTrack(){
	}

	public OrderInforVO getTrack(TransportListDataService list,TransportCommodityDataService commodity,String orderNum) throws RemoteException{
		CommodityPO com =commodity.findCommodity(orderNum);
		if(com==null) return null;
		String expressNum = com.getId();
		ArrayList<String> track = new ArrayList<String>();
		ShipState state = ShipState.RECEIPIENT;

		SendPO send = list.findSendById(com.getSend());
		ArrayList<LoadPO> loadList = new ArrayList<LoadPO>();
		for(String s : com.getLoad()){
			LoadPO result1 = list.findLoad(s);
			LoadcarPO result2 = list.findLoadCar(s);
			if(result1==null){
				if(result2!=null){
					loadList.add(new LoadPO(result2.getId(),"WAITING",LoadType.CAR,result2.getLoadDate(),result2.getBusinessHallNum(),result2.getMotorNum(),result2.getBusinessHallNum().substring(0, 3),result2.getDestiBusinessHall(),result2.getVehicleNum(),result2.getDriverNum(),result2.getCommodityNums(),result2.getFreight()));
				}
			}else{
				loadList.add(result1);
			}
		}
		ArrayList<ArrivalPO> arrivalList = new ArrayList<ArrivalPO>();
		for(String s : com.getArrival()){
			arrivalList.add(list.findArrival(s));
		}
		DispatchPO dispatch = list.findDispatch(com.getDispatch());
		ReceivePO receive = list.findReceive(com.getReceive());

		switch(this.getStage(send,loadList,arrivalList,dispatch,receive)){
		case 9 : track.add(CommonUtility.Cal2Str(receive.getReceiveTime())+" "+"快件已签收！");
		case 8: track.add(CommonUtility.Cal2Str(dispatch.getArrivalDate())+" "+"派件中，快递员将很快联系您！");
		case 7: track.add(CommonUtility.Cal2Str(arrivalList.get(2).getArrivalDate())+" "+"目的地营业厅已收入");
		case 6: track.add(CommonUtility.Cal2Str(loadList.get(2).getLoadDate())+" "+"快件发往目的地营业厅");
		case 5: track.add(CommonUtility.Cal2Str(arrivalList.get(1).getArrivalDate())+" "+"目的地中转中心已收入");
		case 4: track.add(CommonUtility.Cal2Str(loadList.get(1).getLoadDate())+" "+"快件已发往目的地中转中心");
		case 3: track.add(CommonUtility.Cal2Str(arrivalList.get(0).getArrivalDate())+" "+"发送地中转中心已收入");
		case 2: track.add(CommonUtility.Cal2Str(loadList.get(0).getLoadDate())+" "+"快件已发往中转中心");
		case 1: track.add(CommonUtility.Cal2Str(send.getCreateTime())+" "+"营业厅收件成功");break;
		case 0: track.add(CommonUtility.getTime()+" "+"暂无物流信息");break;	
		}
		switch(this.getStage(send,loadList,arrivalList,dispatch,receive)){
		case 9 : state = ShipState.DISPATCHING;break;
		case 8: 
		case 7: state = ShipState.RBUSINESSH; break;
		case 6: 
		case 5: state = ShipState.RTRANSIT; break;
		case 4: 
		case 3: state = ShipState.STRANSIT; break;
		case 2: 
		case 1: state = ShipState.SBUSINESSH; break;
		case 0: break;	
		}

		return new OrderInforVO(state,track,expressNum);
	}
	public int getStage(SendPO send,ArrayList<LoadPO> loadList,ArrayList<ArrivalPO> arrivalList, DispatchPO dispatch,ReceivePO receive) throws RemoteException{
		if(send==null) return 0;
		if(send!=null&&loadList.size()==0) return 1;
		if(loadList.size()==1&&arrivalList.size()==0) return 2;
		if(loadList.size()==1&&arrivalList.size()==1) return 3;
		if(loadList.size()==2&&arrivalList.size()==1) return 4;
		if(loadList.size()==2&&arrivalList.size()==2) return 5;
		if(loadList.size()==3&&arrivalList.size()==2) return 6;
		if(loadList.size()==3&&arrivalList.size()==3&&dispatch==null) return 7;
		if(loadList.size()==3&&arrivalList.size()==3&&dispatch!=null&&receive==null) return 8;
		if(loadList.size()==3&&arrivalList.size()==3&&dispatch!=null&&receive!=null) return 9;

		return -1;
	}
}
