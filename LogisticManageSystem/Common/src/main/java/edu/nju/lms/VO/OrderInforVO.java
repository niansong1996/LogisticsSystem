package edu.nju.lms.VO;

import java.util.ArrayList;

import edu.nju.lms.data.ShipState;

/**
 *@author nians	
 *@date 2015/12/02
 *@use serve as an property of commodity, used to demonstrate the current state of the
 *     commodity and the history track of the commodity
 */
public class OrderInforVO  {
	//current state of the commodity
	private ShipState shipState;
	//time+space+location
	private ArrayList<String> track;
	//the expressNum of the orderInforVO is identical to the commodity it belongs
	private String expressNum;
	
	public OrderInforVO(ShipState shipState, ArrayList<String> track, String expressNum) {
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
