package edu.nju.lms.PO;

import java.util.Calendar;

import edu.nju.lms.data.ArrivalState;

/**
 *@author tj
 *@date 2015��10��24��
 */
public class ArrivalPO extends ListPO{
	private ArrivalState arrivalState;
	private String expressNum;
	private String destination;
	//出发地 
	private String setOut;
	private Calendar arrivalDate;
	//optional  中转中心编号,只有在中转中心到达时才有 
    private String transitNum;
	
	public ArrivalPO(String id,ArrivalState arrivalState, String expressNum, String destination,String setOut, Calendar arrivalDate) {
		super(id);
		this.arrivalState = arrivalState;
		this.expressNum = expressNum;
		this.destination = destination;
		this.setOut = setOut;
		this.arrivalDate = arrivalDate;
	}
	
	public ArrivalPO(String id, String expressNum, String destination,String setOut,
			Calendar arrivalDate,
			long shipmentNum) {
		super(id);
		this.arrivalState = ArrivalState.COMPLETE;
		this.expressNum = expressNum;
		this.destination = destination;
		this.setOut = setOut;
		this.arrivalDate = arrivalDate;

	}
	public ArrivalPO(String id,ArrivalState arrivalState, String expressNum, String destination,String setOut, 
			Calendar arrivalDate,String transitNum) {
		super(id);
		this.arrivalState = arrivalState;
		this.expressNum = expressNum;
		this.destination = destination;
		this.setOut = setOut;
		this.arrivalDate = arrivalDate;
		this.transitNum = transitNum;
	}
	public ArrivalPO(String id, String expressNum, String destination,String setOut, Calendar arrivalDate,String shipmentNum
			,String transitNum) {
		super(id);
		this.arrivalState = ArrivalState.COMPLETE;
		this.expressNum = expressNum;
		this.destination = destination;
		this.setOut = setOut;
		this.arrivalDate = arrivalDate;
		this.transitNum = transitNum;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrivalState getArrivalState() {
		return arrivalState;
	}

	public void setArrivalState(ArrivalState arrivalState) {
		this.arrivalState = arrivalState;
	}

	public String getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Calendar getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Calendar arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getSetOut() {
		return setOut;
	}

	public void setSetOut(String setOut) {
		this.setOut = setOut;
	}

	public String getTransitNum() {
		return transitNum;
	}

	public void setTransitNum(String transitNum) {
		this.transitNum = transitNum;
	}
	
	
	
}
