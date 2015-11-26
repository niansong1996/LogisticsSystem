package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.Naming;
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
import edu.nju.lms.dataService.FinanceAccountDataService;
import edu.nju.lms.dataService.FinancePaymentDataService;
import edu.nju.lms.dataService.FinanceReceiptDataService;
import edu.nju.lms.dataService.FinanceStrategyDataService;

public class FinanceController
		implements FinanceAccountblService, FinancePayblService, FinanceReceiptblService, FinanceStrategyblService {

	FinanceAccountblImpl accountf;
	FinancePayblImpl pay;
	FinanceReceiptblImpl receipt;
	FinanceStrategyblImpl strategy;
	
	FinanceAccountDataService accountData;
	FinancePaymentDataService payData;
	FinanceReceiptDataService receiptData;
	FinanceStrategyDataService strategyData;
	
	private String logID;
	
	public FinanceController(){
		try {
			accountData=(FinanceAccountDataService) Naming.lookup("//127.0.0.1:1099/FinanceAccountDataService");
			accountf=new FinanceAccountblImpl(accountData);
			payData=(FinancePaymentDataService) Naming.lookup("//127.0.0.1:1099/FinancePaymentDataService");
			pay=new FinancePayblImpl(payData);
			receiptData=(FinanceReceiptDataService) Naming.lookup("//127.0.0.1:1099/FinanceReceiptDataService");
			receipt=new FinanceReceiptblImpl(receiptData);
			strategyData=(FinanceStrategyDataService) Naming.lookup("//127.0.0.1:1099/FinanceStrategyDataService");
			strategy=new FinanceStrategyblImpl(strategyData);
		} catch (Exception e) {
			System.out.println("网络未连接");
	    	System.exit(0);
		}
	}
	public FinanceController(String id){
		this.logID=id;
	}
	
	public ResultMessage addPriceStrategy(double std) {
		return strategy.addPriceStrategy(std);
	}

	public ResultMessage updatePriceStrategy(double std) {
		return strategy.updatePriceStrategy(std);
	}

	public PriceStrategyVO findPriceStrategy() {
		return strategy.findPriceStrategy();
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		return strategy.addSalaryStrategy(salaryStrategy);
	}

	public SalaryStrategyVO findSalaryStrategy(String type) {
		return strategy.findSalaryStrategy(type);
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		return strategy.updateSalaryStrategy(salaryStrategy);
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
	
	public ResultMessage updateAccount(AccountVO account) {
		return accountf.updateAccount(account);
	}
	
	public ResultMessage addInitialInfo(InitialInfoVO initial) {
		return accountf.addInitialInfo(initial);
	}

	public ResultMessage createSalary(SalaryVO salaryVO) {
		return pay.createSalary(salaryVO);
	}
	public ReceiptVO createReceipt(ReceiptVO debit) {
		return receipt.createReceipt(debit);
	}
	public ResultMessage addReceipt(ReceiptVO debit) {
		return receipt.addReceipt(debit);
	}
	public ResultMessage deleteReceipt(String id) {
		return receipt.deleteReceipt(id);
	}
	public ResultMessage updateReceipt(ReceiptVO debit) {
		return receipt.updateReceipt(debit);
	}
	public ArrayList<ReceiptVO> showReceiptList(Calendar date, String department) {
		return receipt.showReceiptList(date, department);
	}
	public ArrayList<ReceiptVO> showReceiptList(Calendar date) {
		return receipt.showReceiptList(date);
	}
	public double getReceiptSum(Calendar date) {
		return receipt.getReceiptSum(date);
	}
	public ResultMessage checkComplete(ReceiptVO debit) {
		return receipt.checkComplete(debit);
	}
	
}
