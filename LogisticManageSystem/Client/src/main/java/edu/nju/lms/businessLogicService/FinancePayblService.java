package edu.nju.lms.businessLogicService;

import java.util.Calendar;

import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.ListVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public interface FinancePayblService {
	
	public RentVO createRent(double amount,int year,String accountNum);
	
	public ResultMessage saveRent(RentVO rent);
	
	public FreightVO createFreight();
	
	public ResultMessage saveFreight(FreightVO freight);
	
	public SalaryVO createSalary();
	
	public ResultMessage saveSalary(SalaryVO salary);
	
	public ListVO showAllPayment(Calendar start,Calendar end);
	
	public EarningVO showEarnings();
	
	public ResultMessage exportEarning(EarningVO earnings);

}
