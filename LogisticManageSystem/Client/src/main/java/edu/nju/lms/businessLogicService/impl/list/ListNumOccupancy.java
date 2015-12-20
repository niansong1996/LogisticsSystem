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
		case ARRIVAL:numOccupancy.increaseArrivalListNum();result = numOccupancy.getArrivalListNum();
		case CHECKIN:numOccupancy.increaseCheckinListNum();result = numOccupancy.getCheckinListNum();
		case CHECKOUT:numOccupancy.increaseCheckoutListNum();result = numOccupancy.getCheckoutListNum();
		case DISPATCH:numOccupancy.increaseDispatchListNum();result = numOccupancy.getDispatchListNum();
		case LOAD:numOccupancy.increaseLoadListNum();result = numOccupancy.getLoadListNum();
		case PAYMENT:numOccupancy.increasePaymentListNum();result = numOccupancy.getPaymentListNum();
		case RECEIPT:numOccupancy.increaseReceiptListNum();result = numOccupancy.getReceiptListNum();
		case RECEIVE:numOccupancy.increaseReceiveListNum();result = numOccupancy.getReceiveListNum();
		case SEND:numOccupancy.increaseSendListNum();result = numOccupancy.getSendListNum();
		case DRIVER:numOccupancy.increaseDriverNum();result = numOccupancy.getDriverNum();
		case CAR:numOccupancy.increaseCarNum();result = numOccupancy.getCarNum();
		default:System.err.println("The listType not match!!!");result = "error";
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
