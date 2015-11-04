package edu.nju.lms.VO;

public class DispatchVO extends ListVO{

	private String dispatchPerson;
	private String arrivalDate;
	private String expressNum;
	
	
	public DispatchVO(String id, String dispatchPerson, String arrivalDate,String expressNum) {
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

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}
	
	
	

}
