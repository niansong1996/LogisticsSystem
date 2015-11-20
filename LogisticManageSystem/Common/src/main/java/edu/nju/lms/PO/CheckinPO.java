package edu.nju.lms.PO;

import java.util.Calendar;
import java.util.Map;

/**
 *@author tj
 *@date 2015年10月24日
 */

public class CheckinPO extends ListPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 979646609984022653L;
	/**
	 * every express's location:express number and its location in the warehouse
	 */
	private Map<String,Location> expresses;
	private Calendar checkinDate;
	/**
	 * every express's destination :express number , destination name
	 */
	private Map<String,String> exDestination;
	
	public CheckinPO(String id,Map<String, Location> expresses, Calendar checkinDate, Map<String, String> exDestination) {
		super(id);
		this.expresses = expresses;
		this.checkinDate = checkinDate;
		this.exDestination = exDestination;
	}
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Location> getExpresses() {
		return expresses;
	}

	public void setExpresses(Map<String, Location> expresses) {
		this.expresses = expresses;
	}

	public Calendar getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Calendar checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Map<String, String> getExDestination() {
		return exDestination;
	}

	public void setExDestination(Map<String, String> exDestination) {
		this.exDestination = exDestination;
	}
	
}
