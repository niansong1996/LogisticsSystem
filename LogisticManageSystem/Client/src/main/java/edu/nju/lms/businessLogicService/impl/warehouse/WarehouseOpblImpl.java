package edu.nju.lms.businessLogicService.impl.warehouse;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.PO.InventoryPO;
import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.VO.WarehouseInfoVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.WarehouseCheckinDataService;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;
import edu.nju.lms.dataService.WarehouseDataService;

public class WarehouseOpblImpl {
	
	public WarehouseOpblImpl(){
	}
	
	public CheckinVO createCheckinList(CheckinVO baseMessage, String warehouseNum) {
		baseMessage.setCheckinDate(CommonUtility.getTime());
		return baseMessage;
	}

	public ResultMessage saveCheckinList(WarehouseDataService warehouseData,WarehouseCheckinDataService checkinData,CheckinVO checkinList, String warehouseNum,ListController listController) {
		try{
		for(int i=0;i<checkinList.getExpresses().size();i++){
			if(warehouseData.findSend(checkinList.getExpresses().get(i))==null) return new ResultMessage(false,"快递编号不存在!");
			InventoryPO inventory = new InventoryPO(warehouseNum,checkinList.getExpresses().get(i),checkinList.getCheckinDate(),
					checkinList.getExDestination().get(i),checkinList.getLocation().get(i).toString());
				ResultMessage result = warehouseData.addInventory(inventory);
				if(result.isSuccess()==false) return result;
		}
		String listNum = listController.applyListNum(ListType.CHECKIN);
		CheckinPO checkin = new CheckinPO(listNum,ListState.WAITING,checkinList.getExpresses(),CommonUtility.String2Cal(checkinList.getCheckinDate()),warehouseNum);
		checkinData.addCheckin(checkin);
		
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return new ResultMessage(true,"success");
	}

	public CheckoutVO createCheckoutList(CheckoutVO baseMessage, String warehouseNum) {
		baseMessage.setCheckoutDate(CommonUtility.getTime());
		return baseMessage;
	}

	public ResultMessage saveCheckoutList(WarehouseDataService warehouseData,WarehouseCheckoutDataService checkoutData,CheckoutVO checkoutList, String warehouseNum,ListController listController){
		try{
			for(int i=0;i<checkoutList.getExpressNums().size();i++){
					ResultMessage result = warehouseData.deleteInventory(checkoutList.getExpressNums().get(i), warehouseNum);
					if(result.isSuccess()==false) return result;
			}
			CheckoutPO checkout = new CheckoutPO(listController.applyListNum
					(ListType.CHECKOUT),ListState.WAITING,checkoutList.getExpressNums(),
					CommonUtility.String2Cal(checkoutList.getCheckoutDate()),
					checkoutList.getDestination(),checkoutList.getLoadType(),
					checkoutList.getArrivalNum(),warehouseNum,checkoutList.getMotorNum());
			checkoutData.addCheckout(checkout);
			} catch (RemoteException e) {
				return RemoteExceptionHandler.handleRemoteException(e);
			}
			return new ResultMessage(true,null);
	}
	
	public WarehouseInfoVO showWarehouseInfo(WarehouseDataService warehouseData,WarehouseCheckinDataService checkinData,WarehouseCheckoutDataService checkoutData,Calendar start,Calendar end,String warehouseNum){
		int checkinNum=0;
		int checkoutNum=0;
		int totalNum=0;
		try {
			ArrayList<CheckinPO> checkinList = checkinData.findCheckin(start,end,warehouseNum);
			ArrayList<CheckoutPO> checkoutList = checkoutData.findCheckout(start, end, warehouseNum);
			checkinNum = checkinList.size();
			checkoutNum = checkoutList.size();
			totalNum = warehouseData.findInventory(warehouseNum).size();
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		return new WarehouseInfoVO(checkinNum,checkoutNum,totalNum);
	}

	
	public CheckinVO findCheckinList(WarehouseCheckinDataService checkinData,String id) {
		CheckinVO result = null;
		try {
			CheckinPO po = checkinData.findCheckin(id);
			//TODO can't actually pass null here
			result = new CheckinVO(po.getId(),null,po.getExpresses(),CommonUtility.Cal2String(po.getCheckinDate()),null);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	
	public CheckoutVO findCheckoutList(WarehouseCheckoutDataService checkoutData,String id) {
		CheckoutVO result = null;
		try {
			CheckoutPO po = checkoutData.findCheckout(id);
			result = new CheckoutVO(po.getId(),po.getExpressNums(),CommonUtility.Cal2String(po.getCheckoutDate()),po.getDestination(),po.getLoadType(),po.getArrivalNum(),po.getMotorNum());
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		
		return result;
	}
}
