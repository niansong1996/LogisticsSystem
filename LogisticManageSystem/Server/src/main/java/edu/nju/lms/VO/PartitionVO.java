package edu.nju.lms.VO;

import java.util.ArrayList;

import edu.nju.lms.data.Partition;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class PartitionVO {
	private ArrayList<Partition> partitionInfor;

	public PartitionVO(ArrayList<Partition> partitionInfor) {
		super();
		this.partitionInfor = partitionInfor;
	}

	public ArrayList<Partition> getPartitionInfor() {
		return partitionInfor;
	}

	public void setPartitionInfor(ArrayList<Partition> partitionInfor) {
		this.partitionInfor = partitionInfor;
	}
	
}
