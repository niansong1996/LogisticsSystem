package edu.nju.lms.PO;

import edu.nju.lms.data.ListState;

public class ListPO {
	private long id;
	private ListState state;
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