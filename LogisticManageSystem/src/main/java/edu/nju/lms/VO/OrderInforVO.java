package edu.nju.lms.VO;

import java.util.ArrayList;

import edu.nju.lms.data.ShipState;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class OrderInforVO  {
	private ShipState shipState;
	//每个字符串包含时间+空格+xx营业厅或xx中转中心
	private ArrayList<String> track;
	private long expressNum;
	
	public OrderInforVO(ShipState shipState, ArrayList<String> track, long expressNum) {
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

	public long getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(long expressNum) {
		this.expressNum = expressNum;
	}
	
	
	
}
