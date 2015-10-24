package edu.nju.lms.PO;
/**
 *@author tj
 *@date 2015年10月24日
 */
public class Location {
	//partition number
	private PartitionType partitionNum;
	//排号
	private int rowNum;
	//位号
	private int item;
	
	public Location(PartitionType partitionNum, int rowNum, int item) {
		super();
		this.partitionNum = partitionNum;
		this.rowNum = rowNum;
		this.item = item;
	}

	public PartitionType getPartitionNum() {
		return partitionNum;
	}

	public void setPartitionNum(PartitionType partitionNum) {
		this.partitionNum = partitionNum;
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
	
	
}
