package edu.nju.lms.businessLogicService;

import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public interface FinancePayblService {
	//rent payment
	public RentVO createRent(int sum, int year);
	
	public ResultMessage saveRent(RentVO rent);
	
	//freight payment
	public FreightVO showFreight();
	
	public ResultMessage updateFreight(int freight);
	
	public ResultMessage saveFreight(FreightVO freight);
	
	//salary payment
	public PersonnelVO showSalary(String person);
	
	//return the salary payment list in this month
	public SalaryVO showSalarySum(int year, int month);
	
	//list of financial operation
	public EarningVO showEarning();
	
	//export earning list as excel
	public boolean exportEarning(EarningVO earnings);
	
	public ResultMessage createSalary(SalaryVO salaryVO);
}
