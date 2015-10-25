package edu.nju.lms.businessLogicService.impl;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.businessLogicService.FinanceReceiptblService;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinanceReceiptblImpl implements FinanceReceiptblService {

	public ReceiptVO createReceipt(ReceiptVO debit) {
		// TODO Auto-generated method stub
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("789631561");
		return new ReceiptVO("1245789630","2015/02/04",250,"2014567890",expressNums);
	}

	public ResultMessage saveReceipt(ReceiptVO debit) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ArrayList<ReceiptVO> showReceiptVO(Calendar date, String department) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> receipts = new ArrayList<ReceiptVO>();
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("567952149");
		receipts.add(new ReceiptVO("879630126","2015/6/8",526,"789632184",expressNums));
		return receipts;
	}

	public double getReceiptSum(Calendar date) {
		// TODO Auto-generated method stub
		return 520;
	}

	public ArrayList<ReceiptVO> showReceiptList(Calendar date) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> receipts = new ArrayList<ReceiptVO>();
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("567952149");
		receipts.add(new ReceiptVO("879630126","2015/6/8",526,"789632184",expressNums));
		return receipts;
	}

}
