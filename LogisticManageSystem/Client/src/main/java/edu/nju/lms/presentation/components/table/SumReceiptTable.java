package edu.nju.lms.presentation.components.table;

import org.dom4j.Element;

import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyLabel;

/**
 *@author tj
 *@date 2015年12月7日
 */
public class SumReceiptTable extends MyTable {
	private static final long serialVersionUID = 1544150409125862734L;
	public SumReceiptTable(Element element, UIController controller) {
		super(element, controller);
	}

	@Override
	protected void getData() {
	}
	public MyTableLabel createLabel(ReceiptVO vo,String businesshallNum){
		MyLabel courierNum = new MyLabel(vo.getCourierNum());
		MyLabel amount = new MyLabel(vo.getAmount()+"");
		MyLabel business = new MyLabel(businesshallNum);
		courierNum.setSize(100,30);
		amount.setSize(30,30);
		business.setSize(100,30);
		java.awt.Component[] component = { business, courierNum, amount};
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		return null;
	}
}
