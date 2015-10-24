package edu.nju.lms.VO;

import java.util.Calendar;

import edu.nju.lms.data.ListType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ReceiveVO extends ListVO {
	private String receiverName;
	private Calendar receiveTime;
	private long expressNum;
	public ReceiveVO(long id, long expressNum) {
		super(id);
		this.expressNum = expressNum;
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
	public long getExpressNum() {
		return expressNum;
	}
	public void setExpressNum(long expressNum) {
		this.expressNum = expressNum;
	}

	
	
}
