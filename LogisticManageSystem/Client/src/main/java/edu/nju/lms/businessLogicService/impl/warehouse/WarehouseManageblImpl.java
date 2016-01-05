package edu.nju.lms.businessLogicService.impl.warehouse;

import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import edu.nju.lms.PO.InventoryPO;
import edu.nju.lms.PO.WarehousePO;
import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.WarehouseDataService;

public class WarehouseManageblImpl {

	public WarehouseManageblImpl(){
	}

	public InventoryExcelVO checkWarehouseInfor(WarehouseDataService warehouseData,Calendar start, Calendar end, String warehouseNum) {
		ArrayList<String> expressNums = new ArrayList<String>();
		ArrayList<String> checkinTime = new ArrayList<String>();
		ArrayList<String> destination = new ArrayList<String>();
		ArrayList<String> location = new ArrayList<String>();
		ArrayList<InventoryPO> inventoryList = null;
		try {
			inventoryList = warehouseData.findInventory(start, end, warehouseNum);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(inventoryList!=null){
			for(InventoryPO inventory : inventoryList){
				expressNums.add(inventory.getExpressNum());
				checkinTime.add(inventory.getCheckinTime());
				destination.add(inventory.getDestination());
				location.add(inventory.getLocation());
			}
		}
		return new InventoryExcelVO(expressNums, checkinTime, destination,location);
	}

	@SuppressWarnings("resource")
	public ResultMessage exportExcel(InventoryExcelVO excel, String warehouseNum) {
		ArrayList<String> rowArguments = new ArrayList<String>();
		String s = "[快递编号, 入库时间, 目的地, 仓库位置]";
		CommonUtility.String2Array(rowArguments, s);

		HSSFWorkbook wb = new HSSFWorkbook();   
		HSSFSheet sheet = wb.createSheet("库存信息");   
		HSSFRow row = sheet.createRow(0);   
		HSSFCellStyle style = wb.createCellStyle();  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  

		HSSFCell cell;
		for(int i=0;i<rowArguments.size();i++){
			cell = row.createCell(i);  
			cell.setCellValue(rowArguments.get(i));  
			cell.setCellStyle(style);  
		} 

		for(int i = 0; i < excel.getExpressNums().size(); i++){  
			row = sheet.createRow(i+1);   
			// 第四步，创建单元格，并设置值  
			row.createCell(0).setCellValue(excel.getExpressNums().get(i));  
			row.createCell(1).setCellValue(excel.getCheckinTime().get(i));  
			row.createCell(2).setCellValue(excel.getDestination().get(i));
			row.createCell(3).setCellValue(excel.getLocation().get(i));
		}  
		// 第六步，将文件存到指定位置  
		try{  
			FileOutputStream fout = new FileOutputStream("target/"+warehouseNum+"_"+CommonUtility.getDate()+".xls");  
			wb.write(fout);  
			fout.close();  
		}  
		catch (Exception e){  
			System.err.println("Export Excel Failed!!!");
		}   
		return new ResultMessage(true,"success");
	}

	public ResultMessage setCordon(WarehouseDataService warehouseData,double cordon, String warehouseNum) {
		if(cordon>1||cordon<0) return new ResultMessage(false,"The cordon don't lie between 0~1!");
		try {
			WarehousePO warehouse = warehouseData.findWarehouse(warehouseNum);
			if(warehouse==null) return new ResultMessage(false,"Could not find the warehouse!");
			warehouse.setCordon(cordon);
			warehouseData.updateWarehouse(warehouse);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return new ResultMessage(true,null);
	}

	public double getCordon(WarehouseDataService warehouseData,String warehouseNum){
		try {
			WarehousePO warehouse = warehouseData.findWarehouse(warehouseNum);
			if(warehouse==null) return -1;
			return warehouse.getCordon();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public PartitionVO showPartition(WarehouseDataService warehouseData,String warehouseNum) {
		ArrayList<Partition> partition = new ArrayList<Partition>();
		WarehousePO warehouse = null;
		try {
			warehouse = warehouseData.findWarehouse(warehouseNum);
			if(warehouse == null) return null;
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
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

	public ResultMessage modifyPartition(WarehouseDataService warehouseData,PartitionVO modified, String warehouseNum) {
		WarehousePO warehouse = null;
		try {
			warehouse = warehouseData.findWarehouse(warehouseNum);
			if(warehouse == null) return new ResultMessage(false,"Could not find the warehouse");
			ArrayList<String> modifiedPartitionInfor = new ArrayList<String>();
			for(Partition p : modified.getPartitionInfor()){
				modifiedPartitionInfor.add(p.getCapacity()+" "+p.getStartRow()+" "+p.getEndRow()+" "+p.getType());
			}
			warehouse.setPartitionInfor(modifiedPartitionInfor);
			warehouseData.updateWarehouse(warehouse);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return new ResultMessage(true, null);
	}

	public ResultMessage initialize(WarehouseDataService warehouseData,PartitionVO partition, double cordon, String warehouseNum) {
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
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return new ResultMessage(true, null);
	}	
}
