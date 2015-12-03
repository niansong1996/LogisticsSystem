package edu.nju.lms.businessLogicService;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public interface FinanceReceiptblService {
	
	public ReceiptVO createReceipt(ReceiptVO debit);
	
	public ResultMessage addReceipt(ReceiptVO debit);
	
	public ResultMessage deleteReceipt(String id);
	
	public ResultMessage updateReceipt(ReceiptVO debit);

	public ArrayList<ReceiptVO> showReceiptList (Calendar date, String department);
	
	public ArrayList<ReceiptVO> showReceiptList (Calendar date);
	
	public ArrayList<ReceiptVO> showReceiptList(Calendar start,Calendar end);
	
	public double getReceiptSum(Calendar date);
	
}
