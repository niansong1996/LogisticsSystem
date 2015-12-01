package edu.nju.lms.PO;

import java.io.Serializable;

/**
 *@author nians
 *@date 2015/12/01
 */
public class OperationPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8886437067330282800L;
	//modified the name of member variables to mismatch key word in sql
	private String explanation;
	private String timing;
	private String username;
	public OperationPO(String explanation, String timing, String username) {
		super();
		this.explanation = explanation;
		this.timing = timing;
		this.username = username;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
