package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.nju.lms.PO.CommodityPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.TransportCommdityDataService;

/**
 * @author oppalu
 * 2015/11/18
 *
 */
public class TransportCommodityDataImpl implements TransportCommdityDataService {
	
	private ArrayList<CommodityPO> commodityList = new ArrayList<CommodityPO>();

	public ResultMessage addCommodity(CommodityPO commodity) throws RemoteException {
		if(findCommodity(commodity.getId())==null){
			this.commodityList.add(commodity);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The commodity already exists!");
		}
	}

	public CommodityPO findCommodity(String id) throws RemoteException {
		CommodityPO result = null;
		Iterator<CommodityPO> it = commodityList.iterator();
		while(it.hasNext()){
			CommodityPO next = it.next();
			if(next.getId().equals(id)){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteCommodity(String id) throws RemoteException {
		CommodityPO commodity=findCommodity(id);
		if(!(commodity==null)){
			commodityList.remove(commodity);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the commodity!");
		}
	}

	public ResultMessage updateCommodity(CommodityPO commodity) throws RemoteException {
		CommodityPO tempCommodity = findCommodity(commodity.getId());
		if(!(tempCommodity==null)){
			deleteCommodity(tempCommodity.getId());
			addCommodity(commodity);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the commodity!");
		}
	}

}
