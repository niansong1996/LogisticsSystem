package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.PaymentPO;
import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.LoadCarVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.PaymentVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.PaymentType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;
import edu.nju.lms.dataService.FinancePaymentDataService;

/**
 * @author tj
 * @date 2015年10月25日
 */
public class FinancePayblImpl {

	ListController listController;
	PersonnelController personnelController;
	TransportController transportController;
	FinancePaymentDataService service;
	FinanceAccountDataService accountService;

	public FinancePayblImpl(ListController listController,
			PersonnelController personnelController,
			TransportController transportController,
			FinanceAccountDataService account, FinancePaymentDataService service) {
		this.listController = listController;
		this.personnelController = personnelController;
		this.transportController = transportController;
		this.accountService = account;
		this.service = service;
	}

	public RentVO createRent(RentVO rent) {
		RentVO result = rent;
		result.setId(listController.applyListNum(ListType.PAYMENT));
		result.setPayTime(CommonUtility.getTime());
		return result;
	}

	public ResultMessage saveRent(RentVO rent) {
		ResultMessage result = new ResultMessage(false, "网络未连接");
		PaymentPO po = new PaymentPO(rent.getId(), rent.getState(),
				PaymentType.RENT, CommonUtility.String2Cal(rent.getPayTime()),
				rent.getAccount(), rent.getAmount());
		try {
			result = service.addPayment(po);
		} catch (RemoteException e) {
			return result;
		}

		if (result.isSuccess()) {
			result = payMoney(rent.getAccount(), rent.getAmount());
		}
		return result;
	}

	public FreightVO createFreight(String accountNum) {
		FreightVO result = new FreightVO("", "", "", 0);
		result.setId(listController.applyListNum(ListType.PAYMENT));
		result.setAccount(accountNum);
		result.setPayTime(CommonUtility.getTime());
		result.setAmount(calculateFreight());
		return result;
	}

	public ResultMessage saveFreight(FreightVO freight) {
		ResultMessage result = new ResultMessage(false, "网络未连接");
		PaymentPO po = new PaymentPO(freight.getId(), freight.getState(),
				PaymentType.FREIGHT, CommonUtility.String2Cal(freight
						.getPayTime()), freight.getAccount(),
				freight.getAmount());
		try {
			result = service.addPayment(po);
		} catch (RemoteException e) {
			return result;
		}

		if (result.isSuccess()) {
			result = payMoney(freight.getAccount(), freight.getAmount());
		}
		return result;
	}

	public SalaryVO createSalary(String accountNum) {
		SalaryVO result = new SalaryVO("", "", "", 0);
		result.setId(listController.applyListNum(ListType.PAYMENT));
		result.setPayTime(CommonUtility.getTime());
		result.setAccount(accountNum);
		result.setAmount(calculateSalary());
		return result;
	}

	public ResultMessage saveSalary(SalaryVO salary) {
		ResultMessage result = new ResultMessage(false, "网络未连接");
		PaymentPO po = new PaymentPO(salary.getId(), salary.getState(),
				PaymentType.SALARY, CommonUtility.String2Cal(salary
						.getPayTime()), salary.getAccount(), salary.getAmount());
		try {
			result = service.addPayment(po);
		} catch (RemoteException e) {
			return result;
		}

		if (result.isSuccess()) {
			result = payMoney(salary.getAccount(), salary.getAmount());
		}

		return result;
	}

	public ArrayList<PaymentVO> showAllPayment(Calendar start, Calendar end) {
		ArrayList<PaymentVO> result = new ArrayList<PaymentVO>();
		ArrayList<PaymentPO> po = null;
		try {
			po = service.showAllPayment(start, end);
		} catch (RemoteException e) {
			return result;
		}
		if (po != null) {
			for (PaymentPO temp : po) {
				PaymentVO vo = new PaymentVO(temp.getId(),
						temp.getPaymentType(), CommonUtility.Cal2String(temp
								.getPayTime()), temp.getAccount(),
						temp.getAmount());
				result.add(vo);
			}
		}
		return result;
	}

	public EarningVO showEarnings() {
		return null;
	}

	public ResultMessage exportEarning(EarningVO earnings) {
		// TODO Auto-generated method stub
		return null;
	}

	public double calculateSalary() {
		double amount = 0;
		double each = 0;
		ArrayList<PersonnelVO> persons = personnelController.showAllPersonnel();
		for (PersonnelVO person : persons) {
			each = person.getBonus() + person.getPerTime() + person.getSalary();
			amount += each;
			person.setBonus(0);
			person.setPerTime(0);
			personnelController.updatePersonnel(person);
		}
		return amount;
	}

	public double calculateFreight() {
		double result = 0;
		ArrayList<LoadVO> load = transportController.findUnpaidLoad();
		ArrayList<LoadCarVO> loadCar = transportController.findUnpaidLoadCar();
		for (LoadVO vo : load) {
			result += vo.getFreight();
			vo.setState(ListState.PAID);
		}
		for (LoadCarVO vo : loadCar) {
			result += vo.getFreight();
			vo.setState(ListState.PAID);
		}
		return result;
	}

	public ResultMessage payMoney(String accountNum, double money) {
		ResultMessage result = new ResultMessage(false, "网络未连接");
		AccountPO account = null;
		try {
			account = accountService.findAccount(accountNum);
		} catch (RemoteException e) {
			return result;
		}
		if (account == null) {
			result = new ResultMessage(false, "未找到对应账户！");
			return result;
		}

		double currentMoney = account.getAmount();
		if (currentMoney < money) {
			result = new ResultMessage(false, "该账户余额不足！");
			return result;
		}
		currentMoney -= money;
		account.setAmount(currentMoney);
		try {
			result = accountService.updateAccount(account);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}
}
