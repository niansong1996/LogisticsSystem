package edu.nju.lms.data;
/**
 *@author tj
 *@date 2015年10月25日
 */

//分区信息
public class Partition{
	//分区大小
	int capacity;
	int startRow;
	int endRow;
	PartitionType type;
	
	public Partition(int capacity, int startRow, int endRow,PartitionType type) {
		super();
		this.capacity = capacity;
		this.startRow = startRow;
		this.endRow = endRow;
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public PartitionType getType() {
		return type;
	}

	public void setType(PartitionType type) {
		this.type = type;
	}
	@Override
	public String toString(){
		return this.capacity+" "+this.startRow+" "+this.endRow+" "+this.type;
	}
	

}