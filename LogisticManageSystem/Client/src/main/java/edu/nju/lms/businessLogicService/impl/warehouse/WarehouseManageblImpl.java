package edu.nju.lms.businessLogicService.impl.warehouse;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.InventoryPO;
import edu.nju.lms.PO.WarehousePO;
import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.WarehouseDataService;

public class WarehouseManageblImpl {
	WarehouseDataService warehouseData = null;
	
	public WarehouseManageblImpl(WarehouseDataService warehouseData){
			this.warehouseData = warehouseData;
	}
	
	public InventoryExcelVO checkWarehouseInfor(Calendar start, Calendar end, String warehouseNum) {
		ArrayList<String> expressNums = new ArrayList<String>();
		ArrayList<String> checkinTime = new ArrayList<String>();
		ArrayList<String> destination = new ArrayList<String>();
		ArrayList<String> location = new ArrayList<String>();
		ArrayList<InventoryPO> inventoryList = null;
		try {
			inventoryList = warehouseData.findInventory(start, end, warehouseNum);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for(InventoryPO inventory : inventoryList){
			expressNums.add(inventory.getExpressNum());
			checkinTime.add(inventory.getCheckinTime());
			destination.add(inventory.getDestination());
			location.add(inventory.getLocation());
		}
		return new InventoryExcelVO(expressNums, checkinTime, destination,location);
	}

	public ResultMessage exportExcel(InventoryExcelVO excel, String wareHouseNum) {
		//TODO
		return null;
	}

	public ResultMessage setCordon(double cordon, String warehouseNum) {
		if(cordon>1||cordon<0) return new ResultMessage(false,"The cordon don't lie between 0~1!");
		try {
			WarehousePO warehouse = warehouseData.findWarehouse(warehouseNum);
			if(warehouse==null) return new ResultMessage(false,"Could not find the warehouse!");
			warehouse.setCordon(cordon);
			warehouseData.updateWarehouse(warehouse);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ResultMessage(true,null);
	}
	
	public double getCordon(String warehouseNum){
		try {
			WarehousePO warehouse = warehouseData.findWarehouse(warehouseNum);
			if(warehouse==null) return -1;
			return warehouse.getCordon();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public PartitionVO showPartition(String warehouseNum) {
		ArrayList<Partition> partition = new ArrayList<Partition>();
		WarehousePO warehouse = null;
		try {
			warehouse = warehouseData.findWarehouse(warehouseNum);
			if(warehouse == null) return null;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<String> Spartition = warehouse.getPartitionInfor();
		
		for(String s : Spartition){
			String[] part = s.split(" ");
			Partition partitionTmp = new Partition
					(Integer.parseInt(part[0]),Integer.parseInt(part[1]),Integer.parseInt(part[2]),PartitionType.valueOf(part[3]));
			partition.add(partitionTmp);
		}
		return new PartitionVO(partition);
	}

	public ResultMessage modifyPartition(PartitionVO modified, String warehouseNum) {
		WarehousePO warehouse = null;
		try {
			warehouse = warehouseData.findWarehouse(warehouseNum);
			if(warehouse == null) return new ResultMessage(false,"Could not find the warehouse");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<String> modifiedPartitionInfor = new ArrayList<String>();
		for(Partition p : modified.getPartitionInfor()){
			modifiedPartitionInfor.add(p.getCapacity()+" "+p.getStartRow()+" "+p.getEndRow()+" "+p.getType());
		}
		warehouse.setPartitionInfor(modifiedPartitionInfor);
		try {
			warehouseData.updateWarehouse(warehouse);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ResultMessage(true, null);
	}

	public ResultMessage initialize(PartitionVO partition, double cordon, String warehouseNum) {
		ArrayList<String> modifiedPartitionInfor = new ArrayList<String>();
		for(Partition p : partition.getPartitionInfor()){
			modifiedPartitionInfor.add(p.getCapacity()+" "+p.getStartRow()+" "+p.getEndRow()+" "+p.getType());
		}
		
		ArrayList<String> expressNums = new ArrayList<String>();
		ArrayList<String> checkInlists = new ArrayList<String>();
		ArrayList<String> checkOutlists = new ArrayList<String>();
		
		WarehousePO warehouse = new WarehousePO(warehouseNum,cordon,expressNums,checkInlists,checkOutlists,modifiedPartitionInfor);
		try {
			ResultMessage result = warehouseData.addWarehouse(warehouse);
			if(!result.isSuccess()) return result;
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ResultMessage(true, null);
	}	
}
