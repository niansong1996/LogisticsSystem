package edu.nju.lms.businessLogicService.impl.finance;

import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.businessLogicService.FinancePayblService;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinancePayblImpl implements FinancePayblService {

	public RentVO createRent(int sum, int year) {
		// TODO Auto-generated method stub
		return new RentVO(52630,1);
	}

	public ResultMessage saveRent(RentVO rent) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public FreightVO showFreight() {
		// TODO Auto-generated method stub
		return new FreightVO("2015/1/25","工商银行",5680,null);
	}

	public ResultMessage updateFreight(int freight) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ResultMessage saveFreight(FreightVO freight) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public PersonnelVO showSalary(String person) {
		// TODO Auto-generated method stub
		return new PersonnelVO("du","568","521679210",PersonType.MANAGER,52600,0,5000);
	}

	public SalaryVO showSalarySum(int year, int month) {
		// TODO Auto-generated method stub
		return new SalaryVO("2015/8/12","工商银行",2000,null);
	}

	public EarningVO showEarning() {
		// TODO Auto-generated method stub
		return new EarningVO(200000,50000,150000,"2015/3/4","1245789601");
	}

	public boolean exportEarning(EarningVO earnings) {
		// TODO Auto-generated method stub
		return true;
	}

	public ResultMessage createSalary(SalaryVO salaryVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
