package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.nju.lms.PO.CommodityPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.TransportCommodityDataService;

/**
 * @author oppalu
 * 2015/11/18
 *
 */
public class TransportCommodityDataImpl extends UnicastRemoteObject implements TransportCommodityDataService {

	private static final long serialVersionUID = 3191234465459995450L;

	public TransportCommodityDataImpl() throws RemoteException {
	}

	public ResultMessage addCommodity(CommodityPO commodity) throws RemoteException {
		if(findCommodity(commodity.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(commodity, commodity.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The commodity already exists!");
		}
	}

	public CommodityPO findCommodity(String id) throws RemoteException {
		CommodityPO commodity = null;
		ResultSet result = JDBC.ExecuteQuery("select * from commoditypo where id = \""+id+"\";");
		try{
		if(!result.wasNull())
			commodity = (CommodityPO)POGenerator.generateObject(result, CommodityPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return commodity;
	}

	public ResultMessage deleteCommodity(String id) throws RemoteException {
		CommodityPO commodity = findCommodity(id);
		if(!(commodity==null)){
			JDBC.ExecuteData("delete from commoditypo where id = \""+id+"\";");
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the commodity!");
		}
	}

	public ResultMessage updateCommodity(CommodityPO commodity) throws RemoteException {
		CommodityPO tempCommodity = findCommodity(commodity.getId());
		if(!(tempCommodity==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(commodity, commodity.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the commodity!");
		}
	}

}
