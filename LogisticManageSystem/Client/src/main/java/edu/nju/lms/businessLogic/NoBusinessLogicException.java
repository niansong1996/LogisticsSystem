package edu.nju.lms.businessLogic;

public class NoBusinessLogicException extends Exception{
	private static final long serialVersionUID = 2675308148746274987L;
	
	@Override
	public void printStackTrace(){
		System.err.println("The Business Logic Not Initialized!!!");
	}
}
