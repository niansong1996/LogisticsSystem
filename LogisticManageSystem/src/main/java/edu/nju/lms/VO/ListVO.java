package edu.nju.lms.VO;

import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ListType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class ListVO {
	protected long id;
	protected ListState state;
	protected ListType type;
	public ListVO(long id,ListType type) {
		super();
		this.id = id;
		this.state = ListState.WAITING;
		this.type = type;
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
	public ListType getType() {
		return type;
	}
	public void setType(ListType type) {
		this.type = type;
	}
	
}
