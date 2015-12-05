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
		SendListNum = String.valueOf(Long.parseLong(SendListNum)+1L);
	}
	public String getArrivalListNum() {
		return ArrivalListNum;
	}
	public void increaseArrivalListNum() {
		ArrivalListNum = String.valueOf(Long.parseLong(ArrivalListNum)+1L);
	}
	public String getCheckinListNum() {
		return CheckinListNum;
	}
	public void increaseCheckinListNum() {
		CheckinListNum = String.valueOf(Long.parseLong(CheckinListNum)+1L);
	}
	public String getCheckoutListNum() {
		return CheckoutListNum;
	}
	public void increaseCheckoutListNum() {
		CheckoutListNum = String.valueOf(Long.parseLong(CheckoutListNum)+1L);
	}
	public String getDispatchListNum() {
		return DispatchListNum;
	}
	public void increaseDispatchListNum() {
		DispatchListNum = String.valueOf(Long.parseLong(DispatchListNum)+1L);
	}
	public String getLoadListNum() {
		return LoadListNum;
	}
	public void increaseLoadListNum() {
		LoadListNum = String.valueOf(Long.parseLong(LoadListNum)+1L);
	}
	public String getPaymentListNum() {
		return PaymentListNum;
	}
	public void increasePaymentListNum() {
		PaymentListNum = String.valueOf(Long.parseLong(PaymentListNum)+1L);
	}
	public String getReceiptListNum() {
		return ReceiptListNum;
	}
	public void increaseReceiptListNum() {
		ReceiptListNum = String.valueOf(Long.parseLong(ReceiptListNum)+1L);
	}
	public String getReceiveListNum() {
		return ReceiveListNum;
	}
	public void increaseReceiveListNum() {
		ReceiveListNum = String.valueOf(Long.parseLong(ReceiveListNum)+1L);
	}
	public String getDriverNum() {
		return DriverNum;
	}
	public void increaseDriverNum() {
		ReceiveListNum = String.valueOf(Long.parseLong(DriverNum)+1L);
	}
	public String getCarNum() {
		return CarNum;
	}
	public void increaseCarNum() {
		CarNum = String.valueOf(Long.parseLong(CarNum)+1L);
	}
}
