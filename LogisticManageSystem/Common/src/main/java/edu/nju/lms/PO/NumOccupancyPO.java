package edu.nju.lms.PO;

import java.io.Serializable;

public class NumOccupancyPO implements Serializable{
	/**
	 * no need to modify for sql
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
	private String DriverNum;
	private String CarNum;
	public NumOccupancyPO(String sendListNum, String arrivalListNum, String checkinListNum, String checkoutListNum,
			String dispatchListNum,String loadListNum, String paymentListNum,String receiptListNum, 
			String receiveListNum,String driverNum,String carNum) {
		super();
		SendListNum = sendListNum;
		ArrivalListNum = arrivalListNum;
		CheckinListNum = checkinListNum;
		CheckoutListNum = checkoutListNum;
		DispatchListNum = dispatchListNum;
		LoadListNum = loadListNum;
		PaymentListNum = paymentListNum;
		ReceiptListNum = receiptListNum;
		ReceiveListNum = receiveListNum;
		DriverNum=driverNum;
		CarNum=carNum;
	}
	public String getSendListNum() {
		return SendListNum;
	}
	public void increaseSendListNum() {
		SendListNum = ensureDigit(String.valueOf(Long.parseLong(SendListNum)+1L),10);
	}
	public String getArrivalListNum() {
		return ArrivalListNum;
	}
	public void increaseArrivalListNum() {
		ArrivalListNum = ensureDigit(String.valueOf(Long.parseLong(ArrivalListNum)+1L),10);
	}
	public String getCheckinListNum() {
		return CheckinListNum;
	}
	public void increaseCheckinListNum() {
		CheckinListNum = ensureDigit(String.valueOf(Long.parseLong(CheckinListNum)+1L),10);
	}
	public String getCheckoutListNum() {
		return CheckoutListNum;
	}
	public void increaseCheckoutListNum() {
		CheckoutListNum = ensureDigit(String.valueOf(Long.parseLong(CheckoutListNum)+1L),10);
	}
	public String getDispatchListNum() {
		return DispatchListNum;
	}
	public void increaseDispatchListNum() {
		DispatchListNum = ensureDigit(String.valueOf(Long.parseLong(DispatchListNum)+1L),10);
	}
	public String getLoadListNum() {
		return LoadListNum;
	}
	public void increaseLoadListNum() {
		LoadListNum = ensureDigit(String.valueOf(Long.parseLong(LoadListNum)+1L),10);
	}
	public String getPaymentListNum() {
		return PaymentListNum;
	}
	public void increasePaymentListNum() {
		PaymentListNum = ensureDigit(String.valueOf(Long.parseLong(PaymentListNum)+1L), 10);
	}
	public String getReceiptListNum() {
		return ReceiptListNum;
	}
	public void increaseReceiptListNum() {
		ReceiptListNum = ensureDigit(String.valueOf(Long.parseLong(ReceiptListNum)+1L), 10);
	}
	public String getReceiveListNum() {
		return ReceiveListNum;
	}
	public void increaseReceiveListNum() {
		ReceiveListNum = ensureDigit(String.valueOf(Long.parseLong(ReceiveListNum)+1L), 10);
	}
	public String getDriverNum() {
		return DriverNum;
	}
	public void increaseDriverNum() {
		DriverNum = ensureDigit(String.valueOf(Long.parseLong(DriverNum)+1L), 3);
	}
	public String getCarNum() {
		return CarNum;
	}
	public void increaseCarNum() {
		CarNum = ensureDigit(String.valueOf(Long.parseLong(CarNum)+1L), 3);
	}
	public String ensureDigit(String s,int num){
		while(s.length()<num){
			s = "0"+s;
		}
		return s;
	}
}
