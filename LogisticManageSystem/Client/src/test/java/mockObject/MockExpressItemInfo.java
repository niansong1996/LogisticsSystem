package mockObject;

import java.util.Calendar;

import edu.nju.lms.PO.CommodityPO;
import edu.nju.lms.PO.Location;

/**
 *@author tj
 *@date 2015年11月16日
 */
public class MockExpressItemInfo {
	/**
	 * 快递单号
	 */
	private String expressNum;
	/**
	 * the time that the express checked in
	 */
	private Calendar checkInTime;
	/**
	 * the express's destination
	 */
	private String destination;
	
	private Location location;

	private CommodityPO expressPO;
	
	public MockExpressItemInfo(String expressNum, Calendar checkInTime, String destination, Location location) {
		super();
		this.expressNum = expressNum;
		this.checkInTime = checkInTime;
		this.destination = destination;
		this.location = location;
	}

	public String getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}

	public Calendar getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Calendar checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}
