package edu.nju.lms.PO;

import java.io.Serializable;

import edu.nju.lms.data.PartitionType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class Location implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1458086638498867870L;
	//partition number
	private PartitionType partitionType;
	//排号
	private int rowNum;
	//位号
	private int item;
	
	public Location(PartitionType partitionNum, int rowNum, int item) {
		super();
		this.partitionType = partitionNum;
		this.rowNum = rowNum;
		this.item = item;
	}

	public PartitionType getPartitionType() {
		return partitionType;
	}

	public void setPartitionType(PartitionType partitionNum) {
		this.partitionType = partitionNum;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}
	@Override
	public String toString(){
		return this.partitionType+" "+rowNum+" "+item;
	}
	
}
