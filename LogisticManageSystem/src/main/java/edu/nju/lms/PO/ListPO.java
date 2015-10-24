package edu.nju.lms.PO;

import edu.nju.lms.data.ListState;

public class ListPO {
	protected long id;
	protected ListState state;
	
	public ListPO(long id) {
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