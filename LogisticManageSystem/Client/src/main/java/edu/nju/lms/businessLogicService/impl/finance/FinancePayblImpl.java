package edu.nju.lms.businessLogicService.impl.finance;

import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.PaymentPO;
import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.LoadCarVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.PaymentVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
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

	public FinancePayblImpl(){
	}

	public RentVO createRent(RentVO rent,ListController listController) {
		RentVO result = rent;
		result.setId(listController.applyListNum(ListType.PAYMENT));
		result.setPayTime(CommonUtility.getTime());
		return result;
	}

	public ResultMessage saveRent(RentVO rent,FinancePaymentDataService paymentData,FinanceAccountDataService accountService) {
		PaymentPO po = new PaymentPO(rent.getId(), rent.getState(),
				PaymentType.RENT, CommonUtility.String2Cal(rent.getPayTime()),
				rent.getAccount(), rent.getAmount());
		try {
			ResultMessage result = paymentData.addPayment(po);
			if (result.isSuccess()) {
				return payMoney(rent.getAccount(), rent.getAmount(),accountService);
			}else return result;
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
	}

	public FreightVO createFreight(String accountNum,ListController listController,TransportController transportController) {
		FreightVO result = new FreightVO("", "", "", 0);
		result.setId(listController.applyListNum(ListType.PAYMENT));
		result.setAccount(accountNum);
		result.setPayTime(CommonUtility.getTime());
		result.setAmount(calculateFreight(transportController));
		return result;
	}

	public ResultMessage saveFreight(FreightVO freight,FinancePaymentDataService paymentData,FinanceAccountDataService accountService) {
		PaymentPO po = new PaymentPO(freight.getId(), freight.getState(),
				PaymentType.FREIGHT, CommonUtility.String2Cal(freight
						.getPayTime()), freight.getAccount(),
				freight.getAmount());
		try {
			ResultMessage result = paymentData.addPayment(po);
			if (result.isSuccess()) {
				return payMoney(freight.getAccount(), freight.getAmount(),accountService);
			}else return result;
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
	}

	public SalaryVO createSalary(String accountNum,ListController listController,PersonnelController personnelController) {
		SalaryVO result = new SalaryVO("", "", "", 0);
		result.setId(listController.applyListNum(ListType.PAYMENT));
		result.setPayTime(CommonUtility.getTime());
		result.setAccount(accountNum);
		result.setAmount(calculateSalary(personnelController));
		return result;
	}

	public ResultMessage saveSalary(SalaryVO salary,FinancePaymentDataService paymentData,FinanceAccountDataService accountService) {
		PaymentPO po = new PaymentPO(salary.getId(), salary.getState(),
				PaymentType.SALARY, CommonUtility.String2Cal(salary
						.getPayTime()), salary.getAccount(), salary.getAmount());
		try {
			ResultMessage result = paymentData.addPayment(po);
			if (result.isSuccess()) {
				result = payMoney(salary.getAccount(), salary.getAmount(),accountService);
			}return result;
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
	}

	public ArrayList<PaymentVO> showAllPayment(Calendar start, Calendar end,FinancePaymentDataService paymentData) {
		ArrayList<PaymentVO> result = new ArrayList<PaymentVO>();
		ArrayList<PaymentPO> po = null;
		try {
			po = paymentData.showAllPayment(start, end);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
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

	public EarningVO showEarnings(Calendar start,Calendar end) {
		EarningVO result=new EarningVO(0,0,0,CommonUtility.getTime());
		FinanceController finance=null;
		double payment=0;
		double earning=0;
		try {
			finance=BusinessLogicFactory.getFinanceController();
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
		ArrayList<PaymentVO> paymentList=finance.showAllPayment(start, end);
		if(paymentList!=null){
			for(PaymentVO vo : paymentList){
				payment+=vo.getAmount();
			}
		}
		ArrayList<ReceiptVO> receiptList=finance.showReceiptList(start, end);
		if(receiptList!=null){
			for(ReceiptVO vo : receiptList){
				earning+=vo.getAmount();
			}
		}
		result.setPayment(payment);
		result.setEarnings(earning);
		result.setProfit(earning-payment);
		return null;
	}

	@SuppressWarnings("resource")
	public ResultMessage exportEarning(EarningVO excel,PersonnelController personnelController) {
		ArrayList<String> rowArguments = new ArrayList<String>();
		String s = "[日期, 收益, 成本, 利润]";
		CommonUtility.String2Array(rowArguments, s);

		HSSFWorkbook wb = new HSSFWorkbook();   
		HSSFSheet sheet = wb.createSheet("成本收益表");   
		HSSFRow row = sheet.createRow(0);   
		HSSFCellStyle style = wb.createCellStyle();  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  

		HSSFCell cell;
		for(int i=0;i<rowArguments.size();i++){
			cell = row.createCell(i);  
			cell.setCellValue(rowArguments.get(i));  
			cell.setCellStyle(style);  
		} 
 
			row = sheet.createRow(1);   
			// 第四步，创建单元格，并设置值  
			row.createCell(0).setCellValue(excel.getDate());  
			row.createCell(1).setCellValue(excel.getEarnings());  
			row.createCell(2).setCellValue(excel.getPayment());
			row.createCell(3).setCellValue(excel.getProfit());
		
		// 第六步，将文件存到指定位置  
		try{  
			FileOutputStream fout = new FileOutputStream("target/"+"Earnings_"+CommonUtility.getDate()+".xls");  
			wb.write(fout);  
			fout.close();  
		}  
		catch (Exception e){  
			System.err.println("Export Excel Failed!!!");
			e.printStackTrace();
		}   
		return new ResultMessage(true,"success");

	}

	public double calculateSalary(PersonnelController personnelController) {
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

	public double calculateFreight(TransportController transportController) {
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

	public ResultMessage payMoney(String accountNum, double money,FinanceAccountDataService accountService) {
		AccountPO account = null;
		try {
			account = accountService.findAccount(accountNum);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		if (account == null) {
			return new ResultMessage(false, "未找到对应账户！");

		}

		double currentMoney = account.getAmount();
		if (currentMoney < money) {
			return new ResultMessage(false, "该账户余额不足！");

		}
		currentMoney -= money;
		account.setAmount(currentMoney);
		try {
			return accountService.updateAccount(account);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
	}

	public PaymentVO findPayment(String id,FinancePaymentDataService paymentData) {
		PaymentVO result = null;
		try {
			PaymentPO po = paymentData.findPayment(id);
			result = new PaymentVO(po.getId(),po.getPaymentType(),CommonUtility.Cal2String(po.getPayTime()),po.getAccount(),po.getAmount());
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}
}
