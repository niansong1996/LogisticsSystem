package edu.nju.lms.PO;

import java.util.ArrayList;

import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ShipState;

public class OrderInforPO {
	private ShipState shipState;
	//每个字符串包含时间+空格+xx营业厅或xx中转中心
	private ArrayList<String> track;
	private String expressNum;
	
	public OrderInforPO(String shipState, String track, String expressNum) {
		super();
		this.shipState = ShipState.valueOf(shipState);
		CommonUtility.String2Array(this.track, track);
		this.expressNum = expressNum;
	}
	
	public OrderInforPO(ShipState shipState, ArrayList<String> track, String expressNum) {
		super();
		this.shipState = shipState;
		this.track = track;
		this.expressNum = expressNum;
	}

	public ShipState getShipState() {
		return shipState;
	}

	public void setShipState(ShipState shipState) {
		this.shipState = shipState;
	}

	public ArrayList<String> getTrack() {
		return track;
	}

	public void setTrack(ArrayList<String> track) {
		this.track = track;
	}

	public String getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}
	
}
