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
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.FinanceAccountblService;
import edu.nju.lms.businessLogicService.FinanceMoneyblService;
import edu.nju.lms.businessLogicService.FinancePayblService;
import edu.nju.lms.businessLogicService.FinanceReceiptblService;
import edu.nju.lms.businessLogicService.FinanceStrategyblService;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;
import edu.nju.lms.dataService.FinancePaymentDataService;
import edu.nju.lms.dataService.FinanceReceiptDataService;
import edu.nju.lms.dataService.FinanceStrategyDataService;

public class FinanceController
		implements FinanceAccountblService, FinancePayblService, FinanceReceiptblService, FinanceStrategyblService ,FinanceMoneyblService{

	FinanceAccountblImpl accountf;
	FinancePayblImpl pay;
	FinanceReceiptblImpl receipt;
	FinanceStrategyblImpl strategy;
	FinanceMoneyblImpl moneyImpl;
	
	FinanceAccountDataService accountData;
	FinancePaymentDataService payData;
	FinanceReceiptDataService receiptData;
	FinanceStrategyDataService strategyData;
	
	LogController logController;
	
	public FinanceController(){
		try {
			accountData=(FinanceAccountDataService) Naming.lookup("//127.0.0.1:1099/FinanceAccountDataService");
			accountf=new FinanceAccountblImpl(accountData);
			moneyImpl=new FinanceMoneyblImpl(accountData);
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
	
	public ResultMessage addPriceStrategy(double std) {
		ResultMessage result=strategy.addPriceStrategy(std);
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("增加运费策略");
		}
		return result;
	}

	public ResultMessage updatePriceStrategy(double std) {
		ResultMessage result=strategy.updatePriceStrategy(std);
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("更新运费策略");
		}
		return result;
	}

	public PriceStrategyVO findPriceStrategy() {
		PriceStrategyVO result=strategy.findPriceStrategy();
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		logController.addLog("查看运费策略");
		return result;
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result=strategy.addSalaryStrategy(salaryStrategy);
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("增加薪水策略");
		}
		return result;
	}

	public SalaryStrategyVO findSalaryStrategy(String type) {
		SalaryStrategyVO result=strategy.findSalaryStrategy(type);
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		logController.addLog("查看薪水策略");
		return result;
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result=strategy.updateSalaryStrategy(salaryStrategy);
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("更新薪水策略");
		}
		return result;
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
		ResultMessage result=accountf.addAccount(account);
		
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("增加账户"+account.getID()+"的信息");
		}
		
		return result;
	}
	
	public AccountVO showAccount(String id) {
		AccountVO result=accountf.showAccount(id);
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		logController.addLog("查看账户"+id+"的信息");
		return result;
	}
	
	public ResultMessage deleteAccount(String id) {
		ResultMessage result=accountf.deleteAccount(id);
		
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("删除账户"+id+"的信息");
		}
		
		return result;
	}
	
	public ResultMessage updateAccount(AccountVO account) {
		ResultMessage result=accountf.updateAccount(account);
		
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("更新账户"+account.getID()+"的信息");
		}
		
		return result;
	}
	
	public ResultMessage addInitialInfo(InitialInfoVO initial) {
		ResultMessage result=accountf.addInitialInfo(initial);
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("系统初期初始化成功！");
		}
		return result;
	}

	public ResultMessage initialInfo() {
		ResultMessage result=accountf.initialInfo();
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("期初建账成功！");
		}
		return result;
	}

	public ArrayList<InitialInfoVO> findInitialInfo() {
		ArrayList<InitialInfoVO> result=accountf.findInitialInfo();
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		logController.addLog("查看期初建账的信息");
		return result;
	}

	public ResultMessage createSalary(SalaryVO salaryVO) {
		return pay.createSalary(salaryVO);
	}
	public ReceiptVO createReceipt(ReceiptVO debit) {
		return receipt.createReceipt(debit);
	}
	public ResultMessage addReceipt(ReceiptVO debit) {
		ResultMessage result=receipt.addReceipt(debit);
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("增加收款单"+debit.getId()+"的信息");
		}
		return result;
	}
	public ResultMessage deleteReceipt(String id) {
		ResultMessage result=receipt.deleteReceipt(id);
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("删除收款单"+id+"的信息");
		}
		return result;
	}
	public ResultMessage updateReceipt(ReceiptVO debit) {
		ResultMessage result=receipt.updateReceipt(debit);
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("更新收款单"+debit.getId()+"的信息");
		}
		return result;
	}
	public ArrayList<ReceiptVO> showReceiptList(Calendar date, String department) {
		ArrayList<ReceiptVO> result=receipt.showReceiptList(date, department);
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		logController.addLog("查看收款单信息");
		return result;
	}
	public ArrayList<ReceiptVO> showReceiptList(Calendar date) {
		ArrayList<ReceiptVO> result=receipt.showReceiptList(date);
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		logController.addLog("查看收款单信息");
		return result;
	}
	public double getReceiptSum(Calendar date) {
		double result=receipt.getReceiptSum(date);
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		logController.addLog("计算收款总额");
		return result;
	}
	public ResultMessage payMoney(String accountNum,double money) {
		ResultMessage result=moneyImpl.payMoney(accountNum,money);
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("账户"+accountNum+"进行付款");
		}
		return result;
	}
	public ResultMessage addMoney(String accountNum,double money) {
		ResultMessage result=moneyImpl.addMoney(accountNum, money);
		if(result.isSuccess()){
			try {
				logController=BusinessLogicFactory.getLogController();
			} catch (NoBusinessLogicException e) {
			}
			logController.addLog("账户"+accountNum+"进行收款");
		}
		return result;
	}

	public ArrayList<AccountVO> showAllAccount() {
		ArrayList<AccountVO> result=accountf.showAllAccount();
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		logController.addLog("显示所有账户信息");
		return result;
	}
	
}
