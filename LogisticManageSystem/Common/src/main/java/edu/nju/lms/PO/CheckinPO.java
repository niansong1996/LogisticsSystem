package edu.nju.lms.PO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import edu.nju.lms.data.ListState;

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
	 * every express's location:express number 
	 */
	private ArrayList<String> expresses;
	private Calendar checkinDate;
	/**
	 * every express's destination :express number , destination name
	 */
	private Map<String,String> exDestination;
	
	public CheckinPO(String id,String state,ArrayList<String> expresses, Calendar checkinDate, Map<String, String> exDestination) {
		super(id,ListState.valueOf(state));
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

	public ArrayList<String> getExpresses() {
		return expresses;
	}

	public void setExpresses(ArrayList<String> expresses) {
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
