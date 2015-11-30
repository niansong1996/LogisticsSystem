package edu.nju.lms.PO;

import java.io.Serializable;

import edu.nju.lms.data.ListState;

public abstract class ListPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5697602870723648981L;
	public String id;
	public ListState state;
	
	public ListPO(String id,ListState state) {
		this.state = state;
		this.id = id;
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
	
}