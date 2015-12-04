package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.InitialInfoVO;
import edu.nju.lms.VO.PaymentVO;
import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogicService.FinanceAccountblService;
import edu.nju.lms.businessLogicService.FinancePayblService;
import edu.nju.lms.businessLogicService.FinanceReceiptblService;
import edu.nju.lms.businessLogicService.FinanceStrategyblService;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
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
	
	ListController listController;
	LogController logController;
	PersonnelController personnelController;
	TransportController transportController;
	
	public FinanceController(){
		try {
			listController=BusinessLogicFactory.getListController();
			logController=BusinessLogicFactory.getLogController();
			personnelController=BusinessLogicFactory.getPersonnelController();
			transportController=BusinessLogicFactory.getTransportController();
			
			accountData=(FinanceAccountDataService) Naming.lookup("//127.0.0.1:1099/FinanceAccountDataService");
			accountf=new FinanceAccountblImpl(accountData);
			payData=(FinancePaymentDataService) Naming.lookup("//127.0.0.1:1099/FinancePaymentDataService");
			pay=new FinancePayblImpl(listController,personnelController,transportController,accountData,payData);
			receiptData=(FinanceReceiptDataService) Naming.lookup("//127.0.0.1:1099/FinanceReceiptDataService");
			receipt=new FinanceReceiptblImpl(listController,accountData,receiptData);
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
			logController.addLog("增加运费策略");
		}
		return result;
	}

	public ResultMessage updatePriceStrategy(double std) {
		ResultMessage result=strategy.updatePriceStrategy(std);
		if(result.isSuccess()){
			logController.addLog("更新运费策略");
		}
		return result;
	}

	public PriceStrategyVO findPriceStrategy() {
		PriceStrategyVO result=strategy.findPriceStrategy();
		logController.addLog("查看运费策略");
		return result;
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result=strategy.addSalaryStrategy(salaryStrategy);
		if(result.isSuccess()){
			logController.addLog("增加薪水策略");
		}
		return result;
	}

	public SalaryStrategyVO findSalaryStrategy(String type) {
		SalaryStrategyVO result=strategy.findSalaryStrategy(type);
		logController.addLog("查看薪水策略");
		return result;
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result=strategy.updateSalaryStrategy(salaryStrategy);
		if(result.isSuccess()){
			logController.addLog("更新薪水策略");
		}
		return result;
	}

	public ResultMessage addAccount(AccountVO account) {
		ResultMessage result=accountf.addAccount(account);
		
		if(result.isSuccess()){
			logController.addLog("增加账户"+account.getID()+"的信息");
		}
		
		return result;
	}
	
	public AccountVO showAccount(String id) {
		AccountVO result=accountf.showAccount(id);
		logController.addLog("查看账户"+id+"的信息");
		return result;
	}
	
	public ResultMessage deleteAccount(String id) {
		ResultMessage result=accountf.deleteAccount(id);
		
		if(result.isSuccess()){
			logController.addLog("删除账户"+id+"的信息");
		}
		
		return result;
	}
	
	public ResultMessage updateAccount(AccountVO account) {
		ResultMessage result=accountf.updateAccount(account);
		
		if(result.isSuccess()){
			logController.addLog("更新账户"+account.getID()+"的信息");
		}
		
		return result;
	}
	
	public ArrayList<AccountVO> showAllAccount() {
		ArrayList<AccountVO> result=accountf.showAllAccount();
		logController.addLog("显示所有账户信息");
		return result;
	}
	
	public ResultMessage addInitialInfo(InitialInfoVO initial) {
		ResultMessage result=accountf.addInitialInfo(initial);
		if(result.isSuccess()){
			logController.addLog("系统初期初始化成功！");
		}
		return result;
	}

	public ResultMessage initialInfo() {
		ResultMessage result=accountf.initialInfo();
		if(result.isSuccess()){
			logController.addLog("期初建账成功！");
		}
		return result;
	}

	public ArrayList<InitialInfoVO> findInitialInfo() {
		ArrayList<InitialInfoVO> result=accountf.findInitialInfo();
		logController.addLog("查看期初建账的信息");
		return result;
	}

	public ReceiptVO createReceipt(ReceiptVO debit,String account) {
		return receipt.createReceipt(debit,account);
	}
	public ResultMessage addReceipt(ReceiptVO debit) {
		ResultMessage result=receipt.addReceipt(debit);
		if(result.isSuccess()){
			logController.addLog("增加收款单"+debit.getId()+"的信息");
		}
		return result;
	}
	public ResultMessage deleteReceipt(String id) {
		ResultMessage result=receipt.deleteReceipt(id);
		if(result.isSuccess()){
			logController.addLog("删除收款单"+id+"的信息");
		}
		return result;
	}
	public ResultMessage updateReceipt(ReceiptVO debit) {
		ResultMessage result=receipt.updateReceipt(debit);
		if(result.isSuccess()){
			logController.addLog("更新收款单"+debit.getId()+"的信息");
		}
		return result;
	}
	public ArrayList<ReceiptVO> showReceiptList(Calendar date, String department) {
		ArrayList<ReceiptVO> result=receipt.showReceiptList(date, department);
		logController.addLog("查看收款单信息");
		return result;
	}
	public ArrayList<ReceiptVO> showReceiptList(Calendar date) {
		ArrayList<ReceiptVO> result=receipt.showReceiptList(date);
		logController.addLog("查看收款单信息");
		return result;
	}
	public ArrayList<ReceiptVO> showReceiptList(Calendar start, Calendar end) {
		ArrayList<ReceiptVO> result=receipt.showReceiptList(start,end);
		logController.addLog("查看收款单信息");
		return result;
	}
	
	public double getReceiptSum(Calendar date) {
		double result=receipt.getReceiptSum(date);
		logController.addLog("计算收款总额");
		return result;
	}

	public RentVO createRent(RentVO rent) {
		return pay.createRent(rent);
	}
	
	public ResultMessage saveRent(RentVO rent) {
		ResultMessage result=pay.saveRent(rent);
		if(result.isSuccess()){
			logController.addLog("新建租金付款单");
		}
		return result;
	}

	public FreightVO createFreight(String accountNum) {
		return pay.createFreight(accountNum);
	}

	public ResultMessage saveFreight(FreightVO freight) {
		ResultMessage result=pay.saveFreight(freight);
		if(result.isSuccess()){
			logController.addLog("新建运费付款单");
		}
		return result;
	}

	public SalaryVO createSalary(String accountNum) {
		return pay.createSalary(accountNum);
	}

	public ResultMessage saveSalary(SalaryVO salary) {
		ResultMessage result=pay.saveSalary(salary);
		if(result.isSuccess()){
			logController.addLog("新建工资付款单");
		}
		return result;
	}

	public ArrayList<PaymentVO> showAllPayment(Calendar start, Calendar end) {
		return pay.showAllPayment(start, end);
	}

	public EarningVO showEarnings() {
		EarningVO result=pay.showEarnings();
		logController.addLog("查看成本收益表");
		return result;
	}

	public ResultMessage exportEarning(EarningVO earnings) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
