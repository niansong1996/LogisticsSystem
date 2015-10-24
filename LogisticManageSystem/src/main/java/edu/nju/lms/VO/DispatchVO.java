package edu.nju.lms.VO;

import java.util.Calendar;

public class DispatchVO extends ListVO{

	private long dispatchPerson;
	private Calendar arrivalDate;
	private long expressNum;
	
	
	public DispatchVO(long id, long dispatchPerson, Calendar arrivalDate,long expressNum) {
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
