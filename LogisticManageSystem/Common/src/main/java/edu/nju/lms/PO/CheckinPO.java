package edu.nju.lms.PO;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListState;

/**
 *@author nians
 *@date 2015年11月27日
 */

public class CheckinPO extends ListPO{
	/**
	 * have been modified by sql
	 */
	private static final long serialVersionUID = 979646609984022653L;
	/**
	 * every express's location:express number 
	 */
	private ArrayList<String> expresses;
	private Calendar checkinDate;
	private String warehouseNum;
	
	public CheckinPO(String id,String state,String expresses, String checkinDate,String warehouseId) {
		super(id,ListState.valueOf(state));
		this.expresses = new ArrayList<String>();
		this.checkinDate = CommonUtility.String2Cal(checkinDate);
		CommonUtility.String2Array(this.expresses, expresses);
		this.checkinDate = CommonUtility.String2Cal(checkinDate);
		this.warehouseNum = warehouseId;
	}
	
	
	public CheckinPO(String id,ListState state,ArrayList<String> expresses, Calendar checkinDate,String warehouseNum) {
		super(id,state);
		this.expresses = expresses;
		this.checkinDate = checkinDate;
		this.warehouseNum = warehouseNum;
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
	
	public String getWarehouseNum() {
		return warehouseNum;
	}


	public void setWarehouseNum(String warehouseNum) {
		this.warehouseNum = warehouseNum;
	}


	@Override 
	public boolean equals(Object object){
		CheckinPO checkin = (CheckinPO)object;
		if(CommonUtility.Calequals(this.checkinDate,checkin.checkinDate))
			if(this.expresses.equals(checkin.expresses))
				return true;
		return false;
	}
}
