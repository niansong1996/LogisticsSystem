package edu.nju.lms.PO;

import java.util.Calendar;

import edu.nju.lms.data.ArrivalState;

/**
 *@author tj
 *@date 2015��10��24��
 */
public class ArrivalPO extends ListPO{
	private ArrivalState arrivalState;
	private long expressNum;
	private String destination;
	private Calendar arrivalDate;
	//��ת�����
	private long shipmentNum;
	
	public ArrivalPO(long id,ArrivalState arrivalState, long expressNum, String destination, Calendar arrivalDate,
			long shipmentNum) {
		super(id);
		this.arrivalState = arrivalState;
		this.expressNum = expressNum;
		this.destination = destination;
		this.arrivalDate = arrivalDate;
		this.shipmentNum = shipmentNum;
	}
	
	public ArrivalPO(long id, long expressNum, String destination, Calendar arrivalDate,
			long shipmentNum) {
		super(id);
		this.arrivalState = ArrivalState.COMPLETE;
		this.expressNum = expressNum;
		this.destination = destination;
		this.arrivalDate = arrivalDate;
		this.shipmentNum = shipmentNum;
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

	public long getShipmentNum() {
		return shipmentNum;
	}

	public void setShipmentNum(long shipmentNum) {
		this.shipmentNum = shipmentNum;
	}
	
	
}
