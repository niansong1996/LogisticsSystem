package edu.nju.lms.businessLogicService.impl.list;

import java.rmi.RemoteException;

import edu.nju.lms.PO.NumOccupancyPO;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.ListType;
import edu.nju.lms.dataService.ListDataService;
/**
 * 
 * @author nians
 * 
 */
public class ListNumOccupancy {
	private NumOccupancyPO numOccupancy;
	private ListDataService listService;
	ListNumOccupancy(ListDataService listService){
		this.listService = listService;
		System.out.println("*****************\ninitialized\n**************");
		try {
			this.numOccupancy = listService.getNumOccupancy();
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		} catch(Exception e){
			System.err.println("can't get list num occupancy!!!");
		}
	}
	String generateListNum(ListType listType){
		String result = "";
		switch(listType){
		case ARRIVAL:numOccupancy.increaseArrivalListNum();result = numOccupancy.getArrivalListNum();break;
		case CHECKIN:numOccupancy.increaseCheckinListNum();result = numOccupancy.getCheckinListNum();break;
		case CHECKOUT:numOccupancy.increaseCheckoutListNum();result = numOccupancy.getCheckoutListNum();break;
		case DISPATCH:numOccupancy.increaseDispatchListNum();result = numOccupancy.getDispatchListNum();break;
		case LOAD:numOccupancy.increaseLoadListNum();result = numOccupancy.getLoadListNum();break;
		case PAYMENT:numOccupancy.increasePaymentListNum();result = numOccupancy.getPaymentListNum();break;
		case RECEIPT:numOccupancy.increaseReceiptListNum();result = numOccupancy.getReceiptListNum();break;
		case RECEIVE:numOccupancy.increaseReceiveListNum();result = numOccupancy.getReceiveListNum();break;
		case SEND:numOccupancy.increaseSendListNum();result = numOccupancy.getSendListNum();break;
		case DRIVER:numOccupancy.increaseDriverNum();result = numOccupancy.getDriverNum();break;
		case CAR:numOccupancy.increaseCarNum();result = numOccupancy.getCarNum();break;
		default:System.err.println("The listType not match!!!");result = "error";break;
		}
		saveNumOccupancy();
		return result;

	}

	public void saveNumOccupancy() {
		try {
			listService.updateNumOccupancy(numOccupancy);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
