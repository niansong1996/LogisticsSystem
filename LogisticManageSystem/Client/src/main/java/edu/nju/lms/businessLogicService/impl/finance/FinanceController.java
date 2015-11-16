package edu.nju.lms.businessLogicService.impl.finance;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.InitialInfoVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.businessLogicService.FinanceAccountblService;
import edu.nju.lms.businessLogicService.FinancePayblService;
import edu.nju.lms.businessLogicService.FinanceReceiptblService;
import edu.nju.lms.businessLogicService.FinanceStrategyblService;
import edu.nju.lms.data.ResultMessage;

public class FinanceController
		implements FinanceAccountblService, FinancePayblService, FinanceReceiptblService, FinanceStrategyblService {

	FinanceAccountblImpl accountf;
	FinancePayblImpl pay;
	FinanceReceiptblImpl receipt;
	FinanceStrategyblImpl strategy;

	public ResultMessage addPriceStrategy(PriceStrategyVO priceStrategy) {
		return strategy.addPriceStrategy(priceStrategy);
	}

	public ResultMessage updatePriceStrategy(PriceStrategyVO priceStrategy) {
		return strategy.updatePriceStrategy(priceStrategy);
	}

	public PriceStrategyVO findPriceStrategy() {
		return strategy.findPriceStrategy();
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		return strategy.addSalaryStrategy(salaryStrategy);
	}

	public SalaryStrategyVO findSalaryStrategy() {
		return strategy.findSalaryStrategy();
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		return strategy.updateSalaryStrategy(salaryStrategy);
	}

	public ReceiptVO createReceipt(ReceiptVO debit) {
		return receipt.createReceipt(debit);
	}

	public ResultMessage saveReceipt(ReceiptVO debit) {
		return receipt.saveReceipt(debit);
	}
	public ArrayList<ReceiptVO> showReceiptVO(Calendar date, String department) {
		return receipt.showReceiptVO(date, department);
	}
	public double getReceiptSum(Calendar date) {
		return receipt.getReceiptSum(date);
	}
	public ArrayList<ReceiptVO> showReceiptList(Calendar date) {
		return receipt.showReceiptList(date);
	}
	public RentVO createRent(int sum, int year) {
		return pay.createRent(sum, year);
	}
	public ResultMessage saveRent(RentVO rent) {
		return pay.saveRent(rent);
	}
	public FreightVO showFreight() {
		return pay.showFreight();
	}
	public ResultMessage updateFreight(int freight) {
		return pay.updateFreight(freight);
	}
	public ResultMessage saveFreight(FreightVO freight) {
		return pay.saveFreight(freight);
	}
	public PersonnelVO showSalary(String person) {
		return pay.showSalary(person);
	}
	public SalaryVO showSalarySum(int year, int month) {
		return pay.showSalarySum(year, month);
	}
	public EarningVO showEarning() {
		return pay.showEarning();
	}
	public boolean exportEarning(EarningVO earnings) {
		return pay.exportEarning(earnings);
	}
	public ResultMessage addAccount(AccountVO account) {
		return accountf.addAccount(account);
	}
	public AccountVO showAccount(String id) {
		return accountf.showAccount(id);
	}
	public ResultMessage deleteAccount(String id) {
		return accountf.deleteAccount(id);
	}
	public ResultMessage addInitialInfo(InitialInfoVO initial) {
		return accountf.addInitialInfo(initial);
	}

	public ResultMessage createSalary(SalaryVO salaryVO) {
		return pay.createSalary(salaryVO);
	}
}
