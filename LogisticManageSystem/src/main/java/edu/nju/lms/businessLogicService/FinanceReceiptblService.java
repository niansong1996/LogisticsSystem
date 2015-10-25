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
	
	public ResultMessage saveReceipt(ReceiptVO debit);
	
	public ArrayList<ReceiptVO>  showReceiptVO (Calendar date, long department);
	
	public long getReceiptSum(Calendar date);
	
	public ArrayList<ReceiptVO>  showReceiptList (Calendar date);
	
}
