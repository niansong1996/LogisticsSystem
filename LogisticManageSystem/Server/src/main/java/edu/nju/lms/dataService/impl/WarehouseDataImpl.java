package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.nju.lms.PO.WarehousePO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.WarehouseDataService;

public class WarehouseDataImpl implements WarehouseDataService{

	private ArrayList<WarehousePO> warehouseList = new ArrayList<WarehousePO>();

	public ResultMessage addWarehouse(WarehousePO warehouse)throws RemoteException {
		if(findWarehouse(warehouse.getId())==null){
			this.warehouseList.add(warehouse);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The warehouse already exists!");
		}
	}

	public WarehousePO findWarehouse(String id) throws RemoteException {
		WarehousePO result = null;
		Iterator<WarehousePO> it = warehouseList.iterator();
		while(it.hasNext()){
			WarehousePO next = it.next();
			if(next.getId().equals(id)){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteWarehouse(String id) throws RemoteException {

		WarehousePO warehouse = findWarehouse(id);
		if(!(warehouse==null)){
			warehouseList.remove(warehouse);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the warehouse!");
		}
	}

	public ResultMessage updateWarehouse(WarehousePO warehouse) throws RemoteException{
		WarehousePO tempWarehouse = findWarehouse(warehouse.getId());
		if(!(tempWarehouse==null)){
			tempWarehouse = warehouse;
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the warehouse!");
		}
	}

	public ArrayList<WarehousePO> showAllWarehouse() throws RemoteException {
		ArrayList<WarehousePO> warehouseList = new ArrayList<WarehousePO>();
		ResultSet result = JDBC.ExecuteQuery("select * from warehousepo;");
		try{
		if(!result.wasNull()){
			POGenerator.generateMultiObject(warehouseList,result, WarehousePO.class.getName());
		}
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return warehouseList;
	}

}
