package edu.nju.lms.PO;

import java.io.Serializable;

public class NumOccupancyPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8912809095291881407L;
	private String SendListNum;
	private String ArrivalListNum;
	private String CheckinListNum;
	private String CheckoutListNum;
	private String DispatchListNum;
	private String LoadListNum;
	private String PaymentListNum;
	private String ReceiptListNum;
	private String ReceiveListNum;
	public NumOccupancyPO(String sendListNum, String arrivalListNum, String checkinListNum, String checkoutListNum,
			String dispatchListNum, String loadListNum, String paymentListNum, String receiptListNum,
			String receiveListNum) {
		SendListNum = sendListNum;
		ArrivalListNum = arrivalListNum;
		CheckinListNum = checkinListNum;
		CheckoutListNum = checkoutListNum;
		DispatchListNum = dispatchListNum;
		LoadListNum = loadListNum;
		PaymentListNum = paymentListNum;
		ReceiptListNum = receiptListNum;
		ReceiveListNum = receiveListNum;
	}
	public String getSendListNum() {
		return SendListNum;
	}
	public void setSendListNum(String sendListNum) {
		SendListNum = sendListNum;
	}
	public String getArrivalListNum() {
		return ArrivalListNum;
	}
	public void setArrivalListNum(String arrivalListNum) {
		ArrivalListNum = arrivalListNum;
	}
	public String getCheckinListNum() {
		return CheckinListNum;
	}
	public void setCheckinListNum(String checkinListNum) {
		CheckinListNum = checkinListNum;
	}
	public String getCheckoutListNum() {
		return CheckoutListNum;
	}
	public void setCheckoutListNum(String checkoutListNum) {
		CheckoutListNum = checkoutListNum;
	}
	public String getDispatchListNum() {
		return DispatchListNum;
	}
	public void setDispatchListNum(String dispatchListNum) {
		DispatchListNum = dispatchListNum;
	}
	public String getLoadListNum() {
		return LoadListNum;
	}
	public void setLoadListNum(String loadListNum) {
		LoadListNum = loadListNum;
	}
	public String getPaymentListNum() {
		return PaymentListNum;
	}
	public void setPaymentListNum(String paymentListNum) {
		PaymentListNum = paymentListNum;
	}
	public String getReceiptListNum() {
		return ReceiptListNum;
	}
	public void setReceiptListNum(String receiptListNum) {
		ReceiptListNum = receiptListNum;
	}
	public String getReceiveListNum() {
		return ReceiveListNum;
	}
	public void setReceiveListNum(String receiveListNum) {
		ReceiveListNum = receiveListNum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
