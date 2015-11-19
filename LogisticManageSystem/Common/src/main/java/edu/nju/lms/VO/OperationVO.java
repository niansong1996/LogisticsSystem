package edu.nju.lms.VO;

/**
 * show an operation record
 * @author Cui
 * 2015-10-24 23:14:38
 */
public class OperationVO {
	
	private String explain;
	private String time;
	private String user;
	public OperationVO(String time,String user,String explain) {
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

}
