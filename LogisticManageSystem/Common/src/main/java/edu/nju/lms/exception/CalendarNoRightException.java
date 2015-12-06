package edu.nju.lms.exception;

public class CalendarNoRightException extends Exception{
	private static final long serialVersionUID = 8512913036084637817L;
	@Override
	public void printStackTrace(){
		System.err.println("The Calendar is not right!\n");
		super.printStackTrace();
	}
}
