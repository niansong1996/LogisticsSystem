package edu.nju.lms.businessLogicService.impl.list;

import java.rmi.RemoteException;

import edu.nju.lms.PO.NumOccupancyPO;
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
	public ListNumOccupancy(ListDataService listService){
		numOccupancy = this.getNumOccupancy(listService);
		this.listService = listService;
	}
	public String generateListNum(ListType listType){
		switch(listType){
		case ARRIVAL:numOccupancy.increaseArrivalListNum();return numOccupancy.getArrivalListNum();
		case CHECKIN:numOccupancy.increaseCheckinListNum();return numOccupancy.getCheckinListNum();
		case CHECKOUT:numOccupancy.increaseCheckoutListNum();return numOccupancy.getCheckoutListNum();
		case DISPATCH:numOccupancy.increaseDispatchListNum();return numOccupancy.getDispatchListNum();
		case LOAD:numOccupancy.increaseLoadListNum();return numOccupancy.getLoadListNum();
		case LOADCAR:numOccupancy.increaseLoadCarListNum();return numOccupancy.getLoadCarListNum();
		case PAYMENT:numOccupancy.increasePaymentListNum();return numOccupancy.getPaymentListNum();
		case RECEIPT:numOccupancy.increaseReceiptListNum();return numOccupancy.getReceiptListNum();
		case RECEIVE:numOccupancy.increaseReceiveListNum();return numOccupancy.getReceiveListNum();
		case SEND:numOccupancy.increaseSendListNum();return numOccupancy.getSendListNum();
		default:System.err.println("The listType not match!!!");return "error";
		}
		
	}
	public NumOccupancyPO getNumOccupancy(ListDataService listService) {
		try {
			return listService.getNumOccupancy();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveNumOccupancy() {
		try {
			listService.updateNumOccupancy(numOccupancy);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
