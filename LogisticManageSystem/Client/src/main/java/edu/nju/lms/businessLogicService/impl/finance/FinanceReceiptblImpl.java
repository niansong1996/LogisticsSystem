package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceReceiptDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinanceReceiptblImpl{
	private FinanceReceiptDataService service;
	private static int basicNum=0;
	
	public FinanceReceiptblImpl(FinanceReceiptDataService service){
		this.service=service;
	}

	/**
	 * create the date and the id automatically
	 */
	public ReceiptVO createReceipt(ReceiptVO debit) {
		ReceiptVO result=debit;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String time=sdf.format(new Date());
		result.setReceiptDate(time);
		result.setId(createNum());
		
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
		String[] time=debit.getReceiptDate().split("/");
		Calendar c=Calendar.getInstance();
		c.set(Integer.parseInt(time[0]), Integer.parseInt(time[1]),Integer.parseInt(time[2]));
		ReceiptPO po=new ReceiptPO(debit.getId(),c,debit.getAmount(),debit.getCourierNum(),debit.getExpressNums());
		try {
			result=service.addReceipt(po);
		} catch (RemoteException e) {
			// TODO
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
			// TODO
		}
		return result;
	}

	public ResultMessage updateReceipt(ReceiptVO debit) {
		ResultMessage result=idCheck(debit.getId());
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		String[] time=debit.getReceiptDate().split("/");
		Calendar c=Calendar.getInstance();
		c.set(Integer.parseInt(time[0]), Integer.parseInt(time[1]),Integer.parseInt(time[2]));
		ReceiptPO po=new ReceiptPO(debit.getId(),c,debit.getAmount(),debit.getCourierNum(),debit.getExpressNums());
		try {
			result=service.updateReceipt(po);
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public ArrayList<ReceiptVO> showReceiptList(Calendar date, String department) {
		ArrayList<ReceiptVO> listVO=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> listPO=new ArrayList<ReceiptPO>();
		try {
			listPO=service.findReceipt(date, department);
		} catch (RemoteException e) {
			// TODO
		}
		for(ReceiptPO po : listPO){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String time=sdf.format(po.getReceiptDate());
			ReceiptVO temp=new ReceiptVO(po.getId(),time,po.getAmount(),po.getCourierNum(),po.getExpressNums());
			listVO.add(temp);
		}
		return listVO;
	}

	public ArrayList<ReceiptVO> showReceiptList(Calendar date) {
		ArrayList<ReceiptVO> listVO=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> listPO=new ArrayList<ReceiptPO>();
		try {
			listPO=service.findReceipt(date);
		} catch (RemoteException e) {
			// TODO
		}
		for(ReceiptPO po : listPO){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String time=sdf.format(po.getReceiptDate());
			ReceiptVO temp=new ReceiptVO(po.getId(),time,po.getAmount(),po.getCourierNum(),po.getExpressNums());
			listVO.add(temp);
		}
		return listVO;
	}

	public double getReceiptSum(Calendar date) {
		ArrayList<ReceiptVO> listVO=showReceiptList(date);
		double sum=0;
		for(ReceiptVO vo : listVO){
			sum+=vo.getAmount();
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
	
	public String createNum(){
		String result="08";
		String temp=String.valueOf(basicNum);
		while(temp.length()<8){
			temp="0"+temp;
		}
		result+=temp;
		basicNum++;
		return result;
	}
}
