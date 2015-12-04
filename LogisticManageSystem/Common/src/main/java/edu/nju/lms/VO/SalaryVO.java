package edu.nju.lms.VO;

import edu.nju.lms.data.PaymentType;

/**
 * payment of salary
 * @author Cui
 * 2015-10-25 00:02:11
 */
public class SalaryVO extends PaymentVO{

	public SalaryVO(String id,String payTime,String accountNum,double amount) {
		super(id,PaymentType.SALARY,payTime,accountNum,amount);
	}
	
}
