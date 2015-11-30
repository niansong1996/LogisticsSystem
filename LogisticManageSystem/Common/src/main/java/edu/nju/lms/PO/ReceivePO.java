package edu.nju.lms.PO;

import java.util.Calendar;

import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListState;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ReceivePO extends ListPO{
	/**
	 * have been modified for sql
	 */
	private static final long serialVersionUID = 3682064715190520949L;
	private String receiverName;
	private Calendar receiveTime;
	private String expressNum;
	
	public ReceivePO(String id,String state,String receiverName, String receiveTime,String expressNum) {
		super(id,ListState.valueOf(state));
		this.receiverName = receiverName;
		this.receiveTime = CommonUtility.String2Cal(receiveTime);
		this.expressNum = expressNum;
	}
	
	public ReceivePO(String id,String state,String receiverName, Calendar receiveTime,String expressNum) {
		super(id,ListState.valueOf(state));
		this.receiverName = receiverName;
		this.receiveTime = receiveTime;
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
	public String getExpressNum() {
		return expressNum;
	}
	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}
	
}
