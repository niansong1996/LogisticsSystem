package edu.nju.lms.data;

import java.io.Serializable;

public class ResultMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4731092890367678593L;
	boolean success;
	String errorMessage;

	public ResultMessage(boolean success, String errorMessage) {
		super();
		this.success = success;
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public boolean equals(Object o){
		ResultMessage result = (ResultMessage)o;
		if((this.success==result.success)&&this.success)
			return true;
		else if(this.success==result.success&&this.errorMessage.equals(result.errorMessage))
			return true;
		else	
			return false;
	}


}
