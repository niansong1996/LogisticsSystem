package edu.nju.lms.driver;

import java.util.ArrayList;

import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.businessLogicService.FinancePayblService;
import edu.nju.lms.businessLogicService.FinanceReceiptblService;
import edu.nju.lms.businessLogicService.FinanceStrategyblService;
import edu.nju.lms.businessLogicService.impl.finance.FinancePayblImpl;
import edu.nju.lms.businessLogicService.impl.finance.FinanceReceiptblImpl;
import edu.nju.lms.businessLogicService.impl.finance.FinanceStrategyblImpl;
import edu.nju.lms.data.ResultMessage;

public class FinanceblService_Driver {
	public static void main(String[] args) {
		FinancePayblService financePay=null/*=new FinancePayblImpl()*/;
		FinanceReceiptblService financeReceipt=null;/*=new FinanceReceiptblImpl()*/;
		FinanceStrategyblService financeStrategy=null;/*=new FinanceStrategyblImpl()*/;
		
		ResultMessage result;
		PriceStrategyVO priceStrategy=new PriceStrategyVO(10.1,20.1,30.1);
		SalaryStrategyVO salaryStrategy=new SalaryStrategyVO("aa",1000,3,300);
		//运费add
		result=financeStrategy.addPriceStrategy(null);
		if(result==new ResultMessage(true,"")){
			System.out.println("add successfully!");
		}else{
			System.out.println(result.getErrorMessage());
		}
		//运费update
		result=financeStrategy.updatePriceStrategy(priceStrategy);
		if(result==new ResultMessage(true,"")){
			System.out.println("update successfully!");
		}else{
			System.out.println(result.getErrorMessage());
		}
		//find
		PriceStrategyVO vo=financeStrategy.findPriceStrategy();
		System.out.println(vo);
		//薪水add
		result=financeStrategy.addSalaryStrategy(null);
		if(result==new ResultMessage(true,"")){
			System.out.println("add successfully");
		}else{
			System.out.println(result.getErrorMessage());
		}
		//update
		result=financeStrategy.updateSalaryStrategy(salaryStrategy);
		if(result==new ResultMessage(true,"")){
			System.out.println("update successfully");
		}else{
			System.out.println(result.getErrorMessage());
		}
		//find
		SalaryStrategyVO svo=financeStrategy.findSalaryStrategy();
		System.out.println(svo);
		
		
		ReceiptVO receipt=financeReceipt.createReceipt(null);
		System.out.println(receipt);
		
		result=financeReceipt.saveReceipt(null);
		if(result==new ResultMessage(true,"")){
			System.out.println("save successfully!");
		}else{
			System.out.println(result.getErrorMessage());
		}
		
		ArrayList<ReceiptVO> arr=financeReceipt.showReceiptVO(null, null);
		System.out.println(arr);
				
		System.out.println(financeReceipt.getReceiptSum(null));
		
		ArrayList<ReceiptVO> list=financeReceipt.showReceiptList(null);
		System.out.println(list);
		
		RentVO rentVO = financePay.createRent(2530, 253);
		System.out.println(rentVO.getAmount());
		
		result = financePay.saveRent(null);
		if(result.isSuccess()){
			System.out.println("Save rent successfully");
		}else{
			System.out.println(result.getErrorMessage());
		}
		
		FreightVO freight = financePay.showFreight();
		System.out.println(freight.getAmount());
		
		result = financePay.updateFreight(50);
		if(result.isSuccess()){
			System.out.println("Update Freight successfully");
		}else{
			System.out.println(result.getErrorMessage());
		}
		
		result = financePay.saveFreight(null);
		if(result.isSuccess()){
			System.out.println("Save Freight successfully");
		}else{
			System.out.println(result.getErrorMessage());
		}
		
		PersonnelVO person = financePay.showSalary("010");
		System.out.println(person.getBonus()+" "+person.getSalary());
		
		SalaryVO salary = financePay.showSalarySum(21,2);
		System.out.println(salary.getAmount());
		
		EarningVO earning = financePay.showEarning();
		System.out.println(earning.getProfit());
		
		System.out.println(financePay.exportEarning(null));
	}

}
