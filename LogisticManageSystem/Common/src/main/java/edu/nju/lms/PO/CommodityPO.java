package edu.nju.lms.PO;

import java.io.Serializable;
import java.util.ArrayList;

import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ShipState;

/**
 *@author tj
 *@date ����5:12:31
 */

//TODO the member variables need to be switched to be their ids 
public class CommodityPO implements Serializable{
	/**
	 * have been modified by sql
	 */
	private static final long serialVersionUID = -3226666377697831921L;
	// commodity number
	private String id;
	private ShipState shipState;

	//sender list
	private String send;
	private ArrayList<String> loading;
	private ArrayList<String> arrival;
	private String dispatch;
	private ArrayList<String> checkin;
	private ArrayList<String> checkout;
	private String receive;
	public CommodityPO(String id, String shipState, String send, String loading, String arrival, String dispatch,
			String checkin, String checkout, String receive) {
		this.loading = new ArrayList<String>();
		this.arrival = new ArrayList<String>();
		this.checkin = new ArrayList<String>();
		this.checkout = new ArrayList<String>();
		this.id = id;
		this.shipState = ShipState.valueOf(shipState);
		this.send = send;
		CommonUtility.String2Array(this.loading, loading);
		CommonUtility.String2Array(this.arrival,arrival	);
		this.dispatch = dispatch;
		CommonUtility.String2Array(this.checkin,checkin);
		CommonUtility.String2Array(this.checkout, checkout);
		this.receive = receive;
	}
	
	public CommodityPO(String id, ShipState shipState, String send, ArrayList<String> loading, ArrayList<String> arrival, String dispatch,
			ArrayList<String> checkin, ArrayList<String> checkout, String receive) {
		super();
		this.id = id;
		this.shipState = shipState;
		this.send = send;
		this.loading = loading;
		this.arrival = arrival;
		this.dispatch = dispatch;
		this.checkin = checkin;
		this.checkout = checkout;
		this.receive = receive;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ShipState getShipState() {
		return shipState;
	}
	public void setShipState(ShipState shipState) {
		this.shipState = shipState;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public ArrayList<String> getLoad() {
		return loading;
	}
	public void setLoad(ArrayList<String> loading) {
		this.loading = loading;
	}
	public ArrayList<String> getArrival() {
		return arrival;
	}
	public void setArrival(ArrayList<String> arrival) {
		this.arrival = arrival;
	}
	public String getDispatch() {
		return dispatch;
	}
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	public ArrayList<String> getCheckin() {
		return checkin;
	}
	public void setCheckin(ArrayList<String> checkin) {
		this.checkin = checkin;
	}
	public ArrayList<String> getCheckout() {
		return checkout;
	}
	public void setCheckout(ArrayList<String> checkout) {
		this.checkout = checkout;
	}
	public String getReceive() {
		return receive;
	}
	public void setReceive(String receive) {
		this.receive = receive;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object object){
		CommodityPO commodity = (CommodityPO)object;
		if(this.arrival.equals(commodity.arrival))
			if(this.checkin.equals(commodity.checkin))
				if(this.checkout.equals(commodity.checkout))
					if(this.dispatch.equals(commodity.dispatch))
						if(this.id.equals(commodity.id))
							if(this.loading.equals(commodity.loading))
								if(this.receive.equals(commodity.receive))
									if(this.send.equals(commodity.send))
										if(this.shipState==commodity.shipState)
											return true;
		return false;
	}
	



	
}
