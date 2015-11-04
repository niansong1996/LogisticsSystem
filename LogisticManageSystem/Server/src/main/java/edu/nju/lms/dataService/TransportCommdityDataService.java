package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.CommodityPO;
import edu.nju.lms.data.ResultMessage;

public interface TransportCommdityDataService {
	
	public ResultMessage addCommodity(CommodityPO commodity) throws RemoteException;
	public CommodityPO findCommodity(String id) throws RemoteException;
	public ResultMessage deleteCommodity(String id) throws RemoteException;
	public ResultMessage updateCommodity(CommodityPO commodity) throws RemoteException;
	
	
}
