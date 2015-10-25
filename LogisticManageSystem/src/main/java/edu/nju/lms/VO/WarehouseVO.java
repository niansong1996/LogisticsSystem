package edu.nju.lms.VO;

import java.util.ArrayList;
import java.util.Map;

import edu.nju.lms.PO.Location;
import edu.nju.lms.data.Partition;

public class WarehouseVO {

	//按时间时间段显示还没写,感觉有的还有问题
	private double cordon;
	private  ArrayList<Partition> partitionInfor;
	private Map<Long,Location> expressNums;
	
	
	public double getCordon() {
		return cordon;
	}
	public void setCordon(double cordon) {
		this.cordon = cordon;
	}
	public ArrayList<Partition> getPartitionInfor() {
		return partitionInfor;
	}
	public void setPartitionInfor(ArrayList<Partition> partitionInfor) {
		this.partitionInfor = partitionInfor;
	}
	public Map<Long, Location> getExpressNums() {
		return expressNums;
	}
	public void setExpressNums(Map<Long, Location> expressNums) {
		this.expressNums = expressNums;
	}
	
	
}
