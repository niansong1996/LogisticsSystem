package edu.nju.lms.PO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.PaymentType;

/**
 *@author nians
 *@date 2015年11月27日
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
	
	public CheckinPO(String id,String state,String expresses, String checkinDate) {
		super(id,ListState.valueOf(state));
		this.checkinDate = CommonUtility.String2Cal(checkinDate);
		CommonUtility.String2Array(this.expresses, expresses);;
		this.checkinDate = CommonUtility.String2Cal(checkinDate);
	}
	
	
	public CheckinPO(String id,String state,ArrayList<String> expresses, Calendar checkinDate) {
		super(id,ListState.valueOf(state));
		this.expresses = expresses;
		this.checkinDate = checkinDate;
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
	
}
