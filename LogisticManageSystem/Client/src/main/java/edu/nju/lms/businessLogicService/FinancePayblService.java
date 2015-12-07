package edu.nju.lms.businessLogicService;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.PaymentVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public interface FinancePayblService {
	
	public RentVO createRent(RentVO rent);
	
	public ResultMessage saveRent(RentVO rent);
	
	public FreightVO createFreight(String accountName);
	
	public ResultMessage saveFreight(FreightVO freight);
	
	public SalaryVO createSalary(String accountName);
	
	public ResultMessage saveSalary(SalaryVO salary);
	
	public ArrayList<PaymentVO> showAllPayment(Calendar start,Calendar end);
	
	public EarningVO showEarnings(Calendar start,Calendar end);
	
	public ResultMessage exportEarning(EarningVO earnings);

}
