package edu.nju.lms.VO;

import java.util.Calendar;
import java.util.Map;

import edu.nju.lms.PO.Location;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class InventoryExcelVO {
	
	private Map<Long,Location> expressNums;
	private Map<Long,Calendar> checkinTime;
	private Map<Long,String> destination;
	
	public InventoryExcelVO(Map<Long, Location> expressNums, Map<Long, Calendar> checkinTime,
			Map<Long, String> destination) {
		super();
		this.expressNums = expressNums;
		this.checkinTime = checkinTime;
		this.destination = destination;
	}

	public Map<Long, Location> getExpressNums() {
		return expressNums;
	}

	public void setExpressNums(Map<Long, Location> expressNums) {
		this.expressNums = expressNums;
	}

	public Map<Long, Calendar> getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(Map<Long, Calendar> checkinTime) {
		this.checkinTime = checkinTime;
	}

	public Map<Long, String> getDestination() {
		return destination;
	}

	public void setDestination(Map<Long, String> destination) {
		this.destination = destination;
	}
	
	
}
