package IntegrateTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceReceiptblImpl;
import edu.nju.lms.data.ResultMessage;
import junit.framework.Assert;

/**
 *@author tj
 *@date 2015年11月16日
 */
public class FinanceReceiptblImplTest {
	FinanceReceiptblImpl receiptbl/* = new FinanceReceiptblImpl()*/;
	@Test
	public void testCreateReceipt() {
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("7896315610");
		ReceiptVO debit = new ReceiptVO("0845789630","",250,"0250000458",expressNums);
	//	ReceiptVO re = receiptbl.createReceipt(debit,"1234567");
	//	Assert.assertEquals(re.getAmount(),250);
	}

	@Test
	public void testSaveReceipt() {
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("7896315610");
		ReceiptVO debit = new ReceiptVO("0845789630","",250,"0250000458",expressNums);
	//	ReceiptVO re = receiptbl.createReceipt(debit,"1234567");
	//	ResultMessage mess = receiptbl.saveReceipt(re);
	//	Assert.assertEquals(true, mess.isSuccess());
	}

	@Test
	public void testShowReceiptVO() {
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("7896315610");
		ReceiptVO debit = new ReceiptVO("0845789630","",250,"0250000458",expressNums);
	//	ReceiptVO re = receiptbl.createReceipt(debit,"1234567");
//		ResultMessage mess = receiptbl.saveReceipt(re);
		Calendar da = Calendar.getInstance();
	//	ArrayList<ReceiptVO> tempt = receiptbl.showReceiptVO(da,"025000");
		
	//	Assert.assertEquals(tempt.get(tempt.size()-1).getAmount(),debit.getAmount());
	}

	@Test
	public void testGetReceiptSum() {
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("7896315610");
		ReceiptVO debit = new ReceiptVO("0845789630","",250,"0250000458",expressNums);
	//	ReceiptVO re = receiptbl.createReceipt(debit,"1234567");
	//	ResultMessage mess = receiptbl.saveReceipt(re);
		Calendar c = Calendar.getInstance();
		double res = receiptbl.getReceiptSum(c);
		Assert.assertEquals(res,250);
	}

	@Test
	public void testShowReceiptList() {
		ArrayList<String> expressNums = new ArrayList<String>();
		expressNums.add("7896315610");
		ReceiptVO debit = new ReceiptVO("0845789630","",250,"0250000458",expressNums);
	//	ReceiptVO re = receiptbl.createReceipt(debit,"1234567");
	//	ResultMessage mess = receiptbl.saveReceipt(re);
		Calendar da = Calendar.getInstance();
		ArrayList<ReceiptVO> tempt = receiptbl.showReceiptList(da);
		
		Assert.assertEquals(tempt.get(tempt.size()-1).getAmount(),debit.getAmount());
	}

}
