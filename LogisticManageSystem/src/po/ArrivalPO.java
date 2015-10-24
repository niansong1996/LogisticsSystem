package po;

import java.util.Calendar;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ArrivalPO {
	private ArrivalState arrivalState;
	private long expressNum;
	private String destination;
	private Calendar arrivalDate;
	//中转单编号
	private long shipmentNum;
	
	public ArrivalPO(ArrivalState arrivalState, long expressNum, String destination, Calendar arrivalDate,
			long shipmentNum) {
		super();
		this.arrivalState = arrivalState;
		this.expressNum = expressNum;
		this.destination = destination;
		this.arrivalDate = arrivalDate;
		this.shipmentNum = shipmentNum;
	}
	
	public ArrivalPO( long expressNum, String destination, Calendar arrivalDate,
			long shipmentNum) {
		super();
		this.arrivalState = ArrivalState.COMPLETE;
		this.expressNum = expressNum;
		this.destination = destination;
		this.arrivalDate = arrivalDate;
		this.shipmentNum = shipmentNum;
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
