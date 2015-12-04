package edu.nju.lms.VO;

import edu.nju.lms.data.PaymentType;

/**
 * payment of freight
 * @author Cui
 * 2015-10-24 23:55:57
 */
public class FreightVO extends PaymentVO{

	public FreightVO(String id,String payTime,String accountNum,double amount) {
		super(id,PaymentType.FREIGHT,payTime,accountNum,amount);
	}
	
}
