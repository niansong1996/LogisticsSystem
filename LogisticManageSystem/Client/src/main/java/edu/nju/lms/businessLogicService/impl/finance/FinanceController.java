package edu.nju.lms.businessLogicService.impl.finance;

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
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.FinanceAccountblService;
import edu.nju.lms.businessLogicService.FinancePayblService;
import edu.nju.lms.businessLogicService.FinanceReceiptblService;
import edu.nju.lms.businessLogicService.FinanceStrategyblService;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.businessLogicService.impl.utility.DataServiceFactory;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;
import edu.nju.lms.dataService.FinancePaymentDataService;
import edu.nju.lms.dataService.FinanceReceiptDataService;
import edu.nju.lms.dataService.FinanceStrategyDataService;

public class FinanceController
		implements FinanceAccountblService, FinancePayblService, FinanceReceiptblService, FinanceStrategyblService {

	FinanceAccountblImpl account;
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
	DepartmentController departmentController;
	WarehouseController warehouseController;
	
	public FinanceController(){
		try {
			listController=BusinessLogicFactory.getListController();
			logController=BusinessLogicFactory.getLogController();
			personnelController=BusinessLogicFactory.getPersonnelController();
			transportController=BusinessLogicFactory.getTransportController();
			departmentController=BusinessLogicFactory.getDepartmentController();
			warehouseController=BusinessLogicFactory.getWarehouseController();
			
			accountData=DataServiceFactory.getFinanceAccountDataService();
			account=new FinanceAccountblImpl();
			payData=DataServiceFactory.getFinancePaymentDataService();
			pay=new FinancePayblImpl();
			receiptData=DataServiceFactory.getFinanceReceiptDataService();
			receipt=new FinanceReceiptblImpl();
			strategyData=DataServiceFactory.getFinanceStrategyDataService();
			strategy=new FinanceStrategyblImpl();
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
	}
	
	public ResultMessage addPriceStrategy(double std) {
		ResultMessage result=strategy.addPriceStrategy(std, strategyData);
		if(result.isSuccess()){
			logController.addLog("增加运费策略");
		}
		return result;
	}

	public ResultMessage updatePriceStrategy(double std) {
		ResultMessage result=strategy.updatePriceStrategy(std, strategyData);
		if(result.isSuccess()){
			logController.addLog("更新运费策略");
		}
		return result;
	}

	public PriceStrategyVO findPriceStrategy() {
		PriceStrategyVO result=strategy.findPriceStrategy(strategyData);
		logController.addLog("查看运费策略");
		return result;
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result=strategy.addSalaryStrategy(salaryStrategy, strategyData);
		if(result.isSuccess()){
			logController.addLog("增加薪水策略");
		}
		return result;
	}

	public SalaryStrategyVO findSalaryStrategy(PersonType personType) {
		SalaryStrategyVO result=strategy.findSalaryStrategy(personType, strategyData);
		logController.addLog("查看薪水策略");
		return result;
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result=strategy.updateSalaryStrategy(salaryStrategy, strategyData);
		if(result.isSuccess()){
			logController.addLog("更新薪水策略");
		}
		return result;
	}

	public ResultMessage addAccount(AccountVO accountvo) {
		ResultMessage result=account.addAccount(accountvo, accountData);
		
		if(result.isSuccess()){
			logController.addLog("增加账户"+accountvo.getID()+"的信息");
		}
		
		return result;
	}
	
	public AccountVO showAccount(String id) {
		AccountVO result=account.showAccount(id, accountData);
		logController.addLog("查看账户"+id+"的信息");
		return result;
	}
	
	public ResultMessage deleteAccount(String id) {
		ResultMessage result=account.deleteAccount(id, accountData);
		
		if(result.isSuccess()){
			logController.addLog("删除账户"+id+"的信息");
		}
		
		return result;
	}
	
	public ResultMessage updateAccount(AccountVO accountvo) {
		ResultMessage result=account.updateAccount(accountvo, accountData);
		
		if(result.isSuccess()){
			logController.addLog("更新账户"+accountvo.getID()+"的信息");
		}
		
		return result;
	}
	
	public ArrayList<AccountVO> showAllAccount() {
		ArrayList<AccountVO> result=account.showAllAccount(accountData);
		logController.addLog("显示所有账户信息");
		return result;
	}
	
	public ResultMessage addMoney(String accountName, double amount) {
		ResultMessage result=account.addMoney(accountName, amount, accountData);
		if(result.isSuccess()){
			logController.addLog("账户"+accountName+"收款"+amount+"元");
		}
		return result;
	}
	
	public ResultMessage addInitialInfo(InitialInfoVO initial) {
		ResultMessage result=account.addInitialInfo(initial, accountData);
		if(result.isSuccess()){
			logController.addLog("系统初期初始化成功！");
		}
		return result;
	}

	public ArrayList<InitialInfoVO> findInitialInfo() {
		ArrayList<InitialInfoVO> result=account.findInitialInfo(accountData);
		logController.addLog("查看期初建账的信息");
		return result;
	}

	public ReceiptVO createReceipt(ReceiptVO debit) {
		return receipt.createReceipt(debit, listController);
	}
	public ResultMessage addReceipt(ReceiptVO debit) {
		ResultMessage result=receipt.addReceipt(debit, receiptData);
		if(result.isSuccess()){
			logController.addLog("增加收款单"+debit.getId()+"的信息");
		}
		return result;
	}
	public ResultMessage deleteReceipt(String id) {
		ResultMessage result=receipt.deleteReceipt(id, receiptData);
		if(result.isSuccess()){
			logController.addLog("删除收款单"+id+"的信息");
		}
		return result;
	}
	public ResultMessage updateReceipt(ReceiptVO debit) {
		ResultMessage result=receipt.updateReceipt(debit, receiptData);
		if(result.isSuccess()){
			logController.addLog("更新收款单"+debit.getId()+"的信息");
		}
		return result;
	}
	public ArrayList<ReceiptVO> showReceiptList(Calendar date, String department) {
		ArrayList<ReceiptVO> result=receipt.showReceiptList(date, department, receiptData);
		logController.addLog("查看收款单信息");
		return result;
	}
	public ArrayList<ReceiptVO> showReceiptList(Calendar date) {
		ArrayList<ReceiptVO> result=receipt.showReceiptList(date, receiptData);
		logController.addLog("查看收款单信息");
		return result;
	}
	public ArrayList<ReceiptVO> showReceiptList(Calendar start, Calendar end) {
		ArrayList<ReceiptVO> result=receipt.showReceiptList(start,end,receiptData);
		logController.addLog("查看收款单信息");
		return result;
	}
	
	public double getReceiptSum(Calendar date) {
		double result=receipt.getReceiptSum(date, receiptData);
		logController.addLog("计算收款总额");
		return result;
	}

	public RentVO createRent(RentVO rent) {
		return pay.createRent(rent, listController);
	}
	
	public ResultMessage saveRent(RentVO rent) {
		ResultMessage result=pay.saveRent(rent, payData, accountData);
		if(result.isSuccess()){
			logController.addLog("新建租金付款单");
		}
		return result;
	}

	public FreightVO createFreight(String accountNum) {
		return pay.createFreight(accountNum, listController, transportController);
	}

	public ResultMessage saveFreight(FreightVO freight) {
		ResultMessage result=pay.saveFreight(freight, payData, accountData);
		if(result.isSuccess()){
			logController.addLog("新建运费付款单");
		}
		return result;
	}

	public SalaryVO createSalary(String accountNum) {
		return pay.createSalary(accountNum, listController, personnelController);
	}

	public ResultMessage saveSalary(SalaryVO salary) {
		ResultMessage result=pay.saveSalary(salary, payData, accountData);
		if(result.isSuccess()){
			logController.addLog("新建工资付款单");
		}
		return result;
	}

	public ArrayList<PaymentVO> showAllPayment(Calendar start, Calendar end) {
		return pay.showAllPayment(start, end, payData);
	}

	public EarningVO showEarnings(Calendar start,Calendar end) {
		EarningVO result=pay.showEarnings(start,end);
		logController.addLog("查看成本收益表");
		return result;
	}

	public ResultMessage exportEarning(EarningVO earnings) {
		return pay.exportEarning(earnings, personnelController);
	}

	public ReceiptVO findReceipt(String id) {
		return receipt.findReceipt(id, receiptData);
	}

	public PaymentVO findPayment(String id) {
		return pay.findPayment(id, payData);
	}

}
