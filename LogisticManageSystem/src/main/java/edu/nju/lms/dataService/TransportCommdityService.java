package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.CommodityPO;

public interface TransportCommdityService {
	
	public boolean addCommodity(CommodityPO commodity) throws RemoteException;
	public CommodityPO findCommodity(long id) throws RemoteException;
	public boolean deleteCommodity(long id) throws RemoteException;
	public boolean updateCommodity(CommodityPO commodity) throws RemoteException;
	
	
}
