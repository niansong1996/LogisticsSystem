package edu.nju.lms.PO;

import java.io.Serializable;
import java.util.ArrayList;

import edu.nju.lms.data.CommonUtility;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class WarehousePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8491739151910976896L;
	private String id;
	/**
	 * the value of the warning line
	 */
	private double cordon;
	private ArrayList<String> expressNums;
	private ArrayList<String> checkInlists;
	private ArrayList<String> checkOutlists;
	//String example:"1000 1 1000 AIRPLANE"
	private ArrayList<String> partitionInfor;
	
	public WarehousePO(String id, String cordon, String expressNums, String checkInlists,
			String checkOutlists,String partitionInfor) {
		this.expressNums = new ArrayList<String>();
		this.checkInlists = new ArrayList<String>();
		this.checkOutlists = new ArrayList<String>();
		this.partitionInfor = new ArrayList<String>();
		this.cordon = Double.parseDouble(cordon);
		this.id = id;
		CommonUtility.String2Array(this.expressNums, expressNums);
		CommonUtility.String2Array(this.checkInlists, checkInlists);
		CommonUtility.String2Array(this.checkOutlists, checkOutlists);
		CommonUtility.String2Array(this.partitionInfor, partitionInfor);
	}
	
	public WarehousePO(String id, double cordon, ArrayList<String> expressNums, ArrayList<String> checkInlists,
			ArrayList<String> checkOutlists, ArrayList<String> partitionInfor) {
		super();
		this.cordon = cordon;
		this.id = id;
		this.expressNums = expressNums;
		this.checkInlists = checkInlists;
		this.checkOutlists = checkOutlists;
		this.partitionInfor = partitionInfor;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public double getCordon() {
		return cordon;
	}


	public void setCordon(double cordon) {
		this.cordon = cordon;
	}


	public ArrayList<String> getExpressNums() {
		return expressNums;
	}


	public void setExpressNums(ArrayList<String> expressNums) {
		this.expressNums = expressNums;
	}


	public ArrayList<String> getCheckInlists() {
		return checkInlists;
	}


	public void setCheckInlists(ArrayList<String> checkInlists) {
		this.checkInlists = checkInlists;
	}


	public ArrayList<String> getCheckOutlists() {
		return checkOutlists;
	}


	public void setCheckOutlists(ArrayList<String> checkOutlists) {
		this.checkOutlists = checkOutlists;
	}

	public ArrayList<String> getPartitionInfor() {
		return partitionInfor;
	}

	public void setPartitionInfor(ArrayList<String> partitionInfor) {
		this.partitionInfor = partitionInfor;
	}
  
}
