package edu.nju.lms.PO;
import java.util.Calendar;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class DispatchPO extends ListPO{
	private long dispatchPerson;
	private Calendar arrivalDate;
	private long expressNum;
	
	public DispatchPO(long id,long dispatchPerson, Calendar arrivalDate, long expressNum) {
		super(id);
		this.dispatchPerson = dispatchPerson;
		this.arrivalDate = arrivalDate;
		this.expressNum = expressNum;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDispatchPerson() {
		return dispatchPerson;
	}

	public void setDispatchPerson(long dispatchPerson) {
		this.dispatchPerson = dispatchPerson;
	}

	public Calendar getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Calendar arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public long getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(long expressNum) {
		this.expressNum = expressNum;
	}
	
	
	
}
