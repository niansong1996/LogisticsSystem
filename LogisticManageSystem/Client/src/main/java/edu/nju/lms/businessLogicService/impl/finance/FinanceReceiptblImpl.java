package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceAccountDataService;
import edu.nju.lms.dataService.FinanceReceiptDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinanceReceiptblImpl{
	private FinanceReceiptDataService service;
	ListController listController;
	FinanceAccountDataService accountService;
	
	public FinanceReceiptblImpl(ListController listController,FinanceAccountDataService account,FinanceReceiptDataService service){
		this.listController=listController;
		this.accountService=account;
		this.service=service;
	}

	/**
	 * create the date and the id automatically
	 */
	public ReceiptVO createReceipt(ReceiptVO debit,String account) {
		ReceiptVO result=debit;
		result.setReceiptDate(CommonUtility.getTime());
		result.setId(listController.applyListNum(ListType.RECEIPT));
		result.setAccount(account);
		return result;
	}
	
	public ResultMessage checkComplete(ReceiptVO debit){
		ResultMessage result=new ResultMessage(true,"");
		if(debit.getAmount()==0 || debit.getCourierNum().equals("") || debit.getExpressNums()==null){
			result=new ResultMessage(false,"信息填写不完整！");
		}
		return result;
	}

	public ResultMessage addReceipt(ReceiptVO debit) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		ReceiptPO po=new ReceiptPO(debit.getId(),debit.getState(),CommonUtility.String2Cal(debit.getReceiptDate()),debit.getAmount(),debit.getCourierNum(),debit.getExpressNums());
		try {
			result=service.addReceipt(po);
		} catch (RemoteException e) {
			return result;
		}
		
		if(result.isSuccess()){
			result=addMoney(debit.getAccount(),debit.getAmount());
		}
		return result;
	}

	public ResultMessage deleteReceipt(String id) {
		ResultMessage result=idCheck(id);
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		try {
			result=service.deleteReceipt(id);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public ResultMessage updateReceipt(ReceiptVO debit) {
		ResultMessage result=idCheck(debit.getId());
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		ReceiptPO po=new ReceiptPO(debit.getId(),debit.getState(),CommonUtility.String2Cal(debit.getReceiptDate()),debit.getAmount(),debit.getCourierNum(),debit.getExpressNums());
		try {
			result=service.updateReceipt(po);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}

	public ArrayList<ReceiptVO> showReceiptList(Calendar date, String department) {
		ArrayList<ReceiptVO> listVO=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> listPO=new ArrayList<ReceiptPO>();
		try {
			listPO=service.findReceipt(date, department);
		} catch (RemoteException e) {
		}
		if(listPO!=null){
			for(ReceiptPO po : listPO){
				ReceiptVO temp=new ReceiptVO(po.getId(),CommonUtility.Cal2String(po.getReceiptDate()),po.getAmount(),po.getCourierNum(),po.getExpressNums());
				listVO.add(temp);
			}
		}
		return listVO;
	}

	public ArrayList<ReceiptVO> showReceiptList(Calendar date) {
		ArrayList<ReceiptVO> listVO=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> listPO=new ArrayList<ReceiptPO>();
		try {
			listPO=service.findReceipt(date);
		} catch (RemoteException e) {
		}
		
		if(listPO!=null){
			for(ReceiptPO po : listPO){
				ReceiptVO temp=new ReceiptVO(po.getId(),CommonUtility.Cal2String(po.getReceiptDate()),po.getAmount(),po.getCourierNum(),po.getExpressNums());
				listVO.add(temp);
			}
		}
		return listVO;
	}

	public ArrayList<ReceiptVO> showReceiptList(Calendar start, Calendar end) {
		ArrayList<ReceiptVO> listVO=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> listPO=new ArrayList<ReceiptPO>();
		try {
			listPO=service.findReceipt(start,end);
		} catch (RemoteException e) {
		}
		if(listPO!=null){
			for(ReceiptPO po : listPO){
				ReceiptVO temp=new ReceiptVO(po.getId(),CommonUtility.Cal2String(po.getReceiptDate()),po.getAmount(),po.getCourierNum(),po.getExpressNums());
				listVO.add(temp);
			}
		}
		return listVO;
	}
	
	public double getReceiptSum(Calendar date) {
		ArrayList<ReceiptVO> listVO=showReceiptList(date);
		double sum=0;
		if(listVO!=null){
			for(ReceiptVO vo : listVO){
				sum+=vo.getAmount();
			}
		}
		return sum;
	}

	public ResultMessage addMoney(String accountNum,double money) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		AccountPO account=null;
		try {
			account=accountService.findAccount(accountNum);
		} catch (RemoteException e) {
			return result;
		}
		if(account==null){
			result=new ResultMessage(false,"未找到对应账户！");
			return result;
		}
		double currentMoney=account.getAmount();
		currentMoney+=money;
		account.setAmount(currentMoney);
		try {
			result=accountService.updateAccount(account);
		} catch (RemoteException e) {
			return result;
		}
		return result;
	}
	
	public ResultMessage idCheck(String id){
		ResultMessage result=new ResultMessage(true,"");
		if(id.length()!=10){
			result.setSuccess(false);
			result.setErrorMessage("输入编号位数不正确！");
			return result;
		}
		if(!(id.substring(0, 2).equals("08"))){
			result.setSuccess(false);
			result.setErrorMessage("输入编号格式不正确！");
		}
		return result;
	}
}
