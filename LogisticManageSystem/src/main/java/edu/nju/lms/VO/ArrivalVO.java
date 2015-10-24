package edu.nju.lms.VO;

import java.util.Calendar;

import edu.nju.lms.data.ArrivalState;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ArrivalVO extends ListVO{
	private ArrivalState arrivalState;
	private long expressNum;
	private String destination;
	//出发地 
	private String setOut;
	private Calendar arrivalDate;
	//optional  中转中心编号,只有在中转中心到达时才有 
    private long transitNum;
	
	public ArrivalVO(long id,ArrivalState arrivalState, long expressNum, String destination,String setOut, Calendar arrivalDate) {
		super(id);
		this.arrivalState = arrivalState;
		this.expressNum = expressNum;
		this.destination = destination;
		this.setOut = setOut;
		this.arrivalDate = arrivalDate;
	}
	
	public ArrivalVO(long id, long expressNum, String destination,String setOut,
			Calendar arrivalDate,
			long shipmentNum) {
		super(id);
		this.arrivalState = ArrivalState.COMPLETE;
		this.expressNum = expressNum;
		this.destination = destination;
		this.setOut = setOut;
		this.arrivalDate = arrivalDate;

	}
	public ArrivalVO(long id,ArrivalState arrivalState, long expressNum, String destination,String setOut, 
			Calendar arrivalDate,long transitNum) {
		super(id);
		this.arrivalState = arrivalState;
		this.expressNum = expressNum;
		this.destination = destination;
		this.setOut = setOut;
		this.arrivalDate = arrivalDate;
		this.transitNum = transitNum;
	}
	public ArrivalVO(long id, long expressNum, String destination,String setOut, Calendar arrivalDate,long shipmentNum
			,long transitNum) {
		super(id);
		this.arrivalState = ArrivalState.COMPLETE;
		this.expressNum = expressNum;
		this.destination = destination;
		this.setOut = setOut;
		this.arrivalDate = arrivalDate;
		this.transitNum = transitNum;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrivalState getArrivalState() {
		return arrivalState;
	}

	public void setArrivalState(ArrivalState arrivalState) {
		this.arrivalState = arrivalState;
	}

	public long getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(long expressNum) {
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

	public long getTransitNum() {
		return transitNum;
	}

	public void setTransitNum(long transitNum) {
		this.transitNum = transitNum;
	}
	
	
}
