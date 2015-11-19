package edu.nju.lms.PO;


/**
 *@author tj
 *@date 2015年10月24日
 */
public class OperationPO {
	//备注
	private String explain;
	private String time;
	private String user;
	
	public OperationPO(String time,String user,String explain) {
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
