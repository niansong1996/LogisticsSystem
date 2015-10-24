package edu.nju.lms.PO;

import java.util.Calendar;
import java.util.Map;

/**
 *@author tj
 *@date 2015年10月24日
 */

public class CheckinPO {
	//every express's location
	private Map<Long,Location> expresses;
	private Calendar checkinDate;
	//every express's destination
	private Map<Long,String> exDestination;
	
	public CheckinPO(Map<Long, Location> expresses, Calendar checkinDate, Map<Long, String> exDestination) {
		super();
		this.expresses = expresses;
		this.checkinDate = checkinDate;
		this.exDestination = exDestination;
	}

	public Map<Long, Location> getExpresses() {
		return expresses;
	}

	public void setExpresses(Map<Long, Location> expresses) {
		this.expresses = expresses;
	}

	public Calendar getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Calendar checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Map<Long, String> getExDestination() {
		return exDestination;
	}

	public void setExDestination(Map<Long, String> exDestination) {
		this.exDestination = exDestination;
	}
	
}
