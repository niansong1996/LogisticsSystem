package edu.nju.lms.presentation.setText;

import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月13日
 */
public class ReceiptText extends Text {
	private String id;
	private FinanceController control;
	public ReceiptText(String id){
		this.id = id;
	}
	@Override
	public String get(UIController controller) {
		this.control = controller.getFinanceController();
		String result="\n";
		ReceiptVO vo = control.findReceipt(id);
		if(vo!=null){
			result+="  单据编号："+vo.getId()+"\n";
			result+="  收款日期："+vo.getReceiptDate()+"\n";
			result+="  数目："+vo.getAmount()+"\n";
			result+="  快递员编号："+vo.getCourierNum()+"\n";
			if(vo.getExpressNums()!=null)
			result+="  快递件数："+vo.getExpressNums().size()+"\n";
		}
		return result;
	}

}
