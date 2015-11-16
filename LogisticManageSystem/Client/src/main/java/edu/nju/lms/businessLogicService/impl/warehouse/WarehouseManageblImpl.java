package edu.nju.lms.businessLogicService.impl.warehouse;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;

public class WarehouseManageblImpl {
	private ExpressList expressList;
	private Partition airline;
	private Partition train;
	private Partition car;
	private Partition flexible;
	public InventoryExcelVO checkWarehouseInfor(Calendar start, Calendar end, String warehouseNum) {
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("0000000000");
		expressNums.add("0000000001");
		ArrayList<String> checkinTime = new ArrayList<String>();
		checkinTime.add("2015/01/01");
		checkinTime.add("2015/01/02");
		ArrayList<String> destination = new ArrayList<String>();
		destination.add("北京");
		destination.add("南京");
		ArrayList<String> location = new ArrayList<String>();
		destination.add("航空区1排1号");
		destination.add("汽运区3排2号");
		return new InventoryExcelVO(expressNums, checkinTime, destination,location);
	}

	public ResultMessage exportExcel(InventoryExcelVO excel, String wareHouseNum) {
		return new ResultMessage(true, "");
	}

	public ResultMessage setCordon(double cordon, String warehouseNum) {
		return new ResultMessage(true, "");
	}

	public PartitionVO showPartition(String warehouseNum) {
		ArrayList<Partition> partition = new ArrayList<Partition>();
		Partition partition1 = new Partition(1000, 1, 200, PartitionType.AIRPLANE);
		Partition partition2 = new Partition(1000, 201, 400, PartitionType.AIRPLANE);
		Partition partition3 = new Partition(1000, 401, 600, PartitionType.AIRPLANE);
		Partition partition4 = new Partition(1000, 601, 800, PartitionType.AIRPLANE);
		partition.add(partition1);
		partition.add(partition2);
		partition.add(partition3);
		partition.add(partition4);
		return new PartitionVO(partition);
	}

	public ResultMessage modifyPartition(PartitionVO modified, String warehouseNum) {
		return new ResultMessage(true, "");
	}

	public ResultMessage initialize(PartitionVO partition, double cordon, String warehouseNum) {
		return new ResultMessage(true, "");
	}

	public ExpressList getExpressList() {
		return expressList;
	}

	public void setExpressList(ExpressList expressList) {
		this.expressList = expressList;
	}
	
}
