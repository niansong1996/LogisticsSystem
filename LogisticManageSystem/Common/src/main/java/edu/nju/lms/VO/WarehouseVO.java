package edu.nju.lms.VO;

import java.util.ArrayList;
import java.util.Map;

import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.PO.Location;
import edu.nju.lms.data.Partition;

public class WarehouseVO {
	private String id;
	private ArrayList<CheckinPO> checkInlists;
	private ArrayList<CheckoutPO> checkOutlists;
	private double cordon;
	private  ArrayList<Partition> partitionInfor;
	private Map<Long,Location> expressNums;
	
	public WarehouseVO(String id,ArrayList<CheckinPO> checkInlists,
			ArrayList<CheckoutPO> checkOutlists, double cordon,
			ArrayList<Partition> partitionInfor,Map<Long,Location> expressNums) {
		super();
		this.id = id;
		this.checkInlists = checkInlists;
		this.checkOutlists = checkOutlists;
		this.cordon = cordon;
		this.partitionInfor = partitionInfor;
		this.expressNums = expressNums;
	}
	
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
	public ArrayList<CheckinPO> getCheckInlists() {
		return checkInlists;
	}
	public void setCheckInlists(ArrayList<CheckinPO> checkInlists) {
		this.checkInlists = checkInlists;
	}
	public ArrayList<CheckoutPO> getCheckOutlists() {
		return checkOutlists;
	}
	public void setCheckOutlists(ArrayList<CheckoutPO> checkOutlists) {
		this.checkOutlists = checkOutlists;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
