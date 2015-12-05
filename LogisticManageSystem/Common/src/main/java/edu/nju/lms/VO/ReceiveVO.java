package edu.nju.lms.VO;

import java.util.Calendar;

import edu.nju.lms.data.ListType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ReceiveVO extends ListVO {
	private String receiverName;
	private String receiveTime;
	private String expressNum;
	public ReceiveVO(String id, String receiverName,String receiveTime,String expressNum) {
		super(id);
		this.receiverName=receiverName;
		this.receiveTime=receiveTime;
		this.expressNum = expressNum;
		this.type = ListType.RECEIVE;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getExpressNum() {
		return expressNum;
	}
	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}

	
	
}
