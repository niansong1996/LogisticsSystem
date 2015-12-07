package edu.nju.lms.presentation.components.table;

import org.dom4j.Element;

import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyLabel;

/**
 *@author tj
 *@date 2015年12月7日
 */
public class SumReceiptTable extends MyTable {
	private static final long serialVersionUID = 1544150409125862734L;
	private FinanceController control;
	public SumReceiptTable(Element element, UIController controller) {
		super(element, controller);
		control = controller.getFinanceController();
	}

	@Override
	protected void getData() {
	}
	public MyTableLabel createLabel(ReceiptVO vo,String businesshallNum){
		MyLabel courierNum = new MyLabel(vo.getCourierNum());
		MyLabel amount = new MyLabel(vo.getAmount()+"");
		MyLabel business = new MyLabel(businesshallNum);
		java.awt.Component[] component = { business, courierNum, amount};
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}
}
