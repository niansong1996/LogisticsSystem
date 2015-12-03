package edu.nju.lms.businessLogicService.impl.list;

import java.rmi.RemoteException;

import edu.nju.lms.PO.NumOccupancyPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.ListDataService;
/**
 * 
 * @author nians
 * 
 */
public class ListNumOccupancy {
	public NumOccupancyPO getNumOccupancy(ListDataService listService) {
		try {
			return listService.getNumOccupancy();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage updateNumOccupancy(ListDataService listService,NumOccupancyPO numOccupancyPO) {
		try {
			return listService.updateNumOccupancy(numOccupancyPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}
