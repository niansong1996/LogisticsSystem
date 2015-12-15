package edu.nju.lms.presentation.setText;

import edu.nju.lms.VO.PaymentVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月13日
 */
public class PaymentText extends Text {
	private String id;
	private FinanceController control;
	public PaymentText(String id){
		this.id = id;
	}
	@Override
	public String get(UIController controller) {
		this.control = controller.getFinanceController();
		String result="\n";
		PaymentVO vo = control.findPayment(id);
		if(vo!=null){
			result+="  单据编号："+vo.getId()+"\n";
			result+="  付款单类型："+vo.getPaymentType()+"\n";
			result+="  付款时间："+vo.getPayTime()+"\n";
			result+="  付款账户："+vo.getAccount()+"\n";
			result+="  付款金额："+vo.getAmount()+"\n";
		}
		return result;
	}

}
