package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.InventoryPO;
import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.PO.SendPO;
import edu.nju.lms.PO.WarehousePO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.DataUtility;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.WarehouseDataService;

public class WarehouseDataImpl extends UnicastRemoteObject implements WarehouseDataService{	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7919445550659045026L;

	public WarehouseDataImpl() throws RemoteException {
	}

	public ResultMessage addWarehouse(WarehousePO warehouse)throws RemoteException {
		if(findWarehouse(warehouse.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(warehouse, warehouse.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The warehouse already exists!");
		}
	}

	public WarehousePO findWarehouse(String id) throws RemoteException {
		WarehousePO warehouse = null;
		ResultSet result = JDBC.ExecuteQuery("select * from warehousepo where id = "+id+";");
		try{
		if(!result.wasNull())
			warehouse = (WarehousePO)POGenerator.generateObject(result, WarehousePO.class.getName());
		}catch (SQLException  e) {
			e.printStackTrace();
		};
		return warehouse;
	}

	public ResultMessage deleteWarehouse(String id) throws RemoteException {
		WarehousePO warehouse = findWarehouse(id);
		if(!(warehouse==null)){
			JDBC.ExecuteData("delete from warehousepo where id = "+id+";");
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the warehouse!");
		}
	}

	public ResultMessage updateWarehouse(WarehousePO warehouse) throws RemoteException{
		WarehousePO tempWarehouse = findWarehouse(warehouse.getId());
		if(!(tempWarehouse==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(warehouse, warehouse.getClass().getName()));
			return new ResultMessage(true,"success");
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

	public ResultMessage addInventory(InventoryPO Inventory) throws RemoteException {
		if(findInventory(Inventory.getExpressNum(),Inventory.getWarehouseId())!=null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(Inventory, Inventory.getClass().getName()));
			return new ResultMessage(true,"success");
	}else{
		return new ResultMessage(false,"The inventory already exists!");
	}
	}

	public InventoryPO findInventory(String expressNum,String warehouseId) throws RemoteException {
		InventoryPO Inventory = null;
		ResultSet result = JDBC.ExecuteQuery("select * from Inventorypo where expressNum = "+expressNum+" and warehouseId = "+warehouseId+";");
		try{
		if(!result.wasNull())
			Inventory = (InventoryPO)POGenerator.generateObject(result, InventoryPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return Inventory;
	}
	
	public ArrayList<InventoryPO> findInventory(Calendar start,Calendar end,String warehouseId){
		ArrayList<InventoryPO> inventoryList = new ArrayList<InventoryPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from inventorypo where checkinTime between \""
				+ DataUtility.Cal2String(start)+" 00:00:00\" and \""+DataUtility.Cal2String(end)+" 23:59:59\""+
				" and warehouseId = "+warehouseId+" ;" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(inventoryList,result, InventoryPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return inventoryList;
	}

	public ArrayList<InventoryPO> findInventory(String warehouseId){
		ArrayList<InventoryPO> inventoryList = new ArrayList<InventoryPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from inventorypo where warehouseId = "+warehouseId+" ;" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(inventoryList,result, ReceiptPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return inventoryList;
	}
	
	public ResultMessage deleteInventory(String expressNum,String warehouseId) throws RemoteException {
		InventoryPO Inventory = findInventory(expressNum,warehouseId);
		if(!(Inventory==null)){
			JDBC.ExecuteData("delete from Inventorypo where expressNum = "+expressNum+" and warehouseId = "+warehouseId+";");
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the Inventory!");
		}
	}

	public ResultMessage updateInventory(InventoryPO Inventory) throws RemoteException {
		InventoryPO tempInventory = findInventory(Inventory.getExpressNum(),Inventory.getWarehouseId());
		if(!(tempInventory==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(Inventory, Inventory.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"Could not find the Inventory!");
		}
	}

	public SendPO findSend(String expressNum)throws RemoteException{
		SendPO send = null;
		ResultSet result = JDBC.ExecuteQuery("select * from sendpo where id = "+expressNum+";");
		try{
		if(!result.wasNull())
			send = (SendPO)POGenerator.generateObject(result, SendPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return send;
	}
}
