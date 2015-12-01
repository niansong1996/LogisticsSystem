package edu.nju.lms.businessLogicService;

import edu.nju.lms.data.ResultMessage;

public interface FinanceMoneyblService {
	
	public ResultMessage payMoney(String accountNum,double money);
	
	public ResultMessage addMoney(String accountNum,double money);
}
