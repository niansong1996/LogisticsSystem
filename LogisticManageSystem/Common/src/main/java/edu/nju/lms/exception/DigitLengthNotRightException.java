package edu.nju.lms.exception;

public class DigitLengthNotRightException extends Exception{
	private static final long serialVersionUID = 2961535119023687041L;
	@Override
	public void printStackTrace(){
		System.err.println("The length of the digits don't match!\n");
		super.printStackTrace();
	}
}
