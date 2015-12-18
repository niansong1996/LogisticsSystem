package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceReceiptDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinanceReceiptblImpl{
	
	public FinanceReceiptblImpl(){
	}

	/**
	 * create the date and the id automatically
	 */
	public ReceiptVO createReceipt(ReceiptVO debit,ListController listController) {
		ReceiptVO result=debit;
		result.setReceiptDate(CommonUtility.getTime());
		result.setId(listController.applyListNum(ListType.RECEIPT));
		return result;
	}
	
	public ResultMessage checkComplete(ReceiptVO debit){
		ResultMessage result=new ResultMessage(true,"");
		if(debit.getAmount()==0 || debit.getCourierNum().equals("") || debit.getExpressNums()==null){
			result=new ResultMessage(false,"信息填写不完整！");
		}
		return result;
	}

	public ResultMessage addReceipt(ReceiptVO debit,FinanceReceiptDataService service) {
		ReceiptPO po=new ReceiptPO(debit.getId(),debit.getState(),CommonUtility.String2Cal(debit.getReceiptDate()),debit.getAmount(),debit.getCourierNum(),debit.getExpressNums());
		try {
			return service.addReceipt(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
	}

	public ResultMessage deleteReceipt(String id,FinanceReceiptDataService service) {
		ResultMessage result=idCheck(id);
		if(!result.isSuccess()){
			return result;
		}
		try {
			result=service.deleteReceipt(id);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public ResultMessage updateReceipt(ReceiptVO debit,FinanceReceiptDataService service) {
		ResultMessage result=idCheck(debit.getId());
		if(!result.isSuccess()){
			return result;
		}
		ReceiptPO po=new ReceiptPO(debit.getId(),debit.getState(),CommonUtility.String2Cal(debit.getReceiptDate()),debit.getAmount(),debit.getCourierNum(),debit.getExpressNums());
		try {
			result=service.updateReceipt(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public ArrayList<ReceiptVO> showReceiptList(Calendar date, String department,FinanceReceiptDataService service) {
		ArrayList<ReceiptVO> listVO=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> listPO=new ArrayList<ReceiptPO>();
		try {
			listPO=service.findReceipt(date, department);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(listPO!=null){
			for(ReceiptPO po : listPO){
				ReceiptVO temp=new ReceiptVO(po.getId(),CommonUtility.Cal2String(po.getReceiptDate()),po.getAmount(),po.getCourierNum(),po.getExpressNums());
				listVO.add(temp);
			}
		}
		return listVO;
	}

	public ArrayList<ReceiptVO> showReceiptList(Calendar date,FinanceReceiptDataService service) {
		ArrayList<ReceiptVO> listVO=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> listPO=new ArrayList<ReceiptPO>();
		try {
			listPO=service.findReceipt(date);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		
		if(listPO!=null){
			for(ReceiptPO po : listPO){
				ReceiptVO temp=new ReceiptVO(po.getId(),CommonUtility.Cal2String(po.getReceiptDate()),po.getAmount(),po.getCourierNum(),po.getExpressNums());
				listVO.add(temp);
			}
		}
		return listVO;
	}

	public ArrayList<ReceiptVO> showReceiptList(Calendar start, Calendar end,FinanceReceiptDataService service) {
		ArrayList<ReceiptVO> listVO=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> listPO=new ArrayList<ReceiptPO>();
		try {
			listPO=service.findReceipt(start,end);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(listPO!=null){
			for(ReceiptPO po : listPO){
				ReceiptVO temp=new ReceiptVO(po.getId(),CommonUtility.Cal2String(po.getReceiptDate()),po.getAmount(),po.getCourierNum(),po.getExpressNums());
				listVO.add(temp);
			}
		}
		return listVO;
	}
	
	public double getReceiptSum(Calendar date,FinanceReceiptDataService service) {
		ArrayList<ReceiptVO> listVO=showReceiptList(date,service);
		double sum=0;
		if(listVO!=null){
			for(ReceiptVO vo : listVO){
				sum+=vo.getAmount();
			}
		}
		return sum;
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

	public ReceiptVO findReceipt(String id,FinanceReceiptDataService service) {
		ReceiptVO result = null;
		ReceiptPO po=null;
		try {
			po = service.findReceipt(id);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			result = new ReceiptVO(po.getId(),CommonUtility.Cal2String(po.getReceiptDate()),po.getAmount(),po.getCourierNum(),po.getExpressNums());
		}
		return result;
	}
}
