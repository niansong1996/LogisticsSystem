package edu.nju.lms.PO;

import java.util.Calendar;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class OperationPO {
	//备注
	private String explain;
	private Calendar time;
	private String user;
	
	public OperationPO(String explain, Calendar time, String user) {
		super();
		this.explain = explain;
		this.time = time;
		this.user = user;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
    
	
}
