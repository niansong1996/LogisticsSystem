package edu.nju.lms.VO;

import edu.nju.lms.data.ListState;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ListVO {
	protected long id;
	protected ListState state;
	
	public ListVO(long id) {
		super();
		this.id = id;
		this.state = ListState.WAITING;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ListState getState() {
		return state;
	}
	public void setState(ListState state) {
		this.state = state;
	}
}
