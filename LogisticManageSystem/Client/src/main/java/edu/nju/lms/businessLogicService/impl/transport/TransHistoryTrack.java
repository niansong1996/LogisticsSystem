package edu.nju.lms.businessLogicService.impl.transport;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.CommodityPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.ReceivePO;
import edu.nju.lms.PO.SendPO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ShipState;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;

public class TransHistoryTrack {
	TransportCommodityDataService commodity;
	TransportListDataService list;
	public TransHistoryTrack(TransportCommodityDataService commodity, TransportListDataService list){
		this.commodity = commodity;
		this.list = list;
	}
	
	public OrderInforVO getTrack(String orderNum) throws RemoteException{
			CommodityPO com =commodity.findCommodity(orderNum);
			String expressNum = com.getId();
			ArrayList<String> track = new ArrayList<String>();
			
			SendPO send = list.findSend(com.getSend());
			ArrayList<LoadPO> loadList = new ArrayList<LoadPO>();
			ArrayList<ArrivalPO> arrivalList = new ArrayList<ArrivalPO>();
			DispatchPO dispatch = list.findDispatch(com.getDispatch());
			ReceivePO receive = list.findReceive(com.getReceive());
			
			switch(this.getStage(send,loadList,arrivalList,dispatch,receive)){
			case 1: track.add(CommonUtility.getTime()+" "+"暂无物流信息");
			case 2: track.add(CommonUtility.getTime()+" "+"营业厅收件成功");
			case 3: track.add(CommonUtility.Cal2String(loadList.get(0).getLoadDate())+" "+"快件已发往中转中心");
			}
			
			OrderInforVO order = new OrderInforVO(ShipState.RECEIPIENT,track,com.getId());
			
		return null;
	}
	public int getStage(SendPO send,ArrayList<LoadPO> loadList,ArrayList<ArrivalPO> arrivalList, DispatchPO dispatch,ReceivePO receive) throws RemoteException{
		if(send==null) return 0;
		if(send!=null&&loadList.size()==0) return 1;
		if(loadList.size()==1&&arrivalList.size()==0) return 2;
		if(loadList.size()==1&&arrivalList.size()==1) return 3;

		
		return 0;
	}
}
