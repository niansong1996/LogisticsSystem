package edu.nju.lms.businessLogicService.impl.finance;

import java.util.Calendar;

import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.PaymentVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;
import edu.nju.lms.dataService.FinancePaymentDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinancePayblImpl{
	
	ListController listController;
	FinancePaymentDataService service;
	FinanceAccountDataService account;
	
	public FinancePayblImpl(ListController listController,FinanceAccountDataService account,FinancePaymentDataService service){
		this.listController=listController;
		this.account=account;
		this.service=service;
	}

	public RentVO createRent(RentVO rent) {
		RentVO result=rent;
		return result;
	}

	public ResultMessage saveRent(RentVO rent) {
		// TODO Auto-generated method stub
		return null;
	}

	public FreightVO createFreight() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage saveFreight(FreightVO freight) {
		// TODO Auto-generated method stub
		return null;
	}

	public SalaryVO createSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage saveSalary(SalaryVO salary) {
		// TODO Auto-generated method stub
		return null;
	}

	public PaymentVO showAllPayment(Calendar start, Calendar end) {
		// TODO Auto-generated method stub
		return null;
	}

	public EarningVO showEarnings() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage exportEarning(EarningVO earnings) {
		// TODO Auto-generated method stub
		return null;
	}

}
