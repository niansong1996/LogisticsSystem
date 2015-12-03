package edu.nju.lms.businessLogicService.impl.finance;

import edu.nju.lms.businessLogicService.FinancePayblService;
import edu.nju.lms.dataService.FinancePaymentDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinancePayblImpl implements FinancePayblService{
	
	private FinancePaymentDataService service;
	
	public FinancePayblImpl(FinancePaymentDataService service){
		this.service=service;
	}

}
