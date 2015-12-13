package edu.nju.lms.VO;

import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ListType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ListVO {
	protected String id;
	protected ListState state;
	protected ListType type;
	public ListVO(String id) {
		super();
		this.id = id;
		this.state = ListState.WAITING;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ListState getState() {
		return state;
	}
	public void setState(ListState state) {
		this.state = state;
	}
	public ListType getType() {
		return type;
	}
	public void setType(ListType type){
		this.type = type;
	}
	
}
