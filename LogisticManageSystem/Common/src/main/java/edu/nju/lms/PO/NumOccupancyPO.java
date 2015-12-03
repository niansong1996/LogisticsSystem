package edu.nju.lms.PO;

import java.io.Serializable;

public class NumOccupancyPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8912809095291881407L;
	String SendListNum;
	String ArrivalListNum;
	String CheckinListNum;
	String CheckoutListNum;
	String DispatchListNum;
	String LoadListNum;
	String PaymentListNum;
	String ReceiptListNum;
	String ReceiveListNum;
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
	
	
}
