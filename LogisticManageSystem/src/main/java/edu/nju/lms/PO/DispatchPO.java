package edu.nju.lms.PO;
import java.util.Calendar;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class DispatchPO extends ListPO{
	/**
	 * the number of the dispatch person
	 */
	private String dispatchPerson;
	private Calendar arrivalDate;
	private String expressNum;
	
	public DispatchPO(String id,String dispatchPerson, Calendar arrivalDate, String expressNum) {
		super(id);
		this.dispatchPerson = dispatchPerson;
		this.arrivalDate = arrivalDate;
		this.expressNum = expressNum;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDispatchPerson() {
		return dispatchPerson;
	}

	public void setDispatchPerson(String dispatchPerson) {
		this.dispatchPerson = dispatchPerson;
	}

	public Calendar getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Calendar arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}
	
	
	
}
