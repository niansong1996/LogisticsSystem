package edu.nju.lms.PO;

import java.util.Calendar;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ReceivePo {
	private String receiverName;
	private Calendar receiveTime;
	
	public ReceivePo(String receiverName, Calendar receiveTime) {
		super();
		this.receiverName = receiverName;
		this.receiveTime = receiveTime;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public Calendar getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Calendar receiveTime) {
		this.receiveTime = receiveTime;
	}
	
}
