package edu.nju.lms.PO;
/**
 *@author tj
 *@date ����5:12:31
 */
public class CommodityPO {
	// commodity number
	private long expressNum;
	//sender list
	private SendPO send;
	private LoadPO load;
	private ArrivalPO arrival;
	private DispatchPO dispatch;
	private CheckinPO checkin;
	private CheckoutPO checkout;
	private ReceivePo Receive;
	
	public CommodityPO(SendPO send){
		this.expressNum = send.get();
		this.send = send;
	}

	public SendPO getSend() {
		return send;
	}

	public void setSend(SendPO send) {
		this.send = send;
	}

	public LoadPO getLoad() {
		return load;
	}

	public void setLoad(LoadPO load) {
		this.load = load;
	}

	public ArrivalPO getArrival() {
		return arrival;
	}

	public void setArrival(ArrivalPO arrival) {
		this.arrival = arrival;
	}

	public DispatchPO getDispatch() {
		return dispatch;
	}

	public void setDispatch(DispatchPO dispatch) {
		this.dispatch = dispatch;
	}

	public CheckinPO getCheckin() {
		return checkin;
	}

	public void setCheckin(CheckinPO checkin) {
		this.checkin = checkin;
	}

	public CheckoutPO getCheckout() {
		return checkout;
	}

	public void setCheckout(CheckoutPO checkout) {
		this.checkout = checkout;
	}

	public ReceivePo getReceive() {
		return Receive;
	}

	public void setReceive(ReceivePo receive) {
		Receive = receive;
	}
	
	

}
