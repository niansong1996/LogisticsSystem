package edu.nju.lms.PO;

import java.util.ArrayList;
import java.util.Map;

import edu.nju.lms.data.Partition;
import edu.nju.lms.data.PartitionType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class WarehousePO {
	//警戒线的值
	private double cordon;
	//key is the express's number, object is its location
	private Map<Long,Location> expressNums;
	private ArrayList<CheckinPO> checkInlists;
	private ArrayList<CheckoutPO> checkOutlists;
	private ArrayList<Partition> partitionInfor;
	
	
	public WarehousePO(double cordon, Map<Long,Location> expressNums, ArrayList<CheckinPO> checkInlists,
			ArrayList<CheckoutPO> checkOutlists, ArrayList<Partition> partitionInfor) {
		super();
		this.cordon = cordon;
		this.expressNums = expressNums;
		this.checkInlists = checkInlists;
		this.checkOutlists = checkOutlists;
		this.partitionInfor = partitionInfor;
	}

    
	public double getCordon() {
		return cordon;
	}


	public void setCordon(double cordon) {
		this.cordon = cordon;
	}


	public Map<Long,Location> getExpressNums() {
		return expressNums;
	}


	public void setExpressNums(Map<Long,Location> expressNums) {
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
    
	

	public ArrayList<Partition> getPartitionInfor() {
		return partitionInfor;
	}


	public void setPartitionInfor(ArrayList<Partition> partitionInfor) {
		this.partitionInfor = partitionInfor;
	}
}
