package edu.nju.lms.presentation.components.table;

import java.awt.event.MouseListener;

import org.dom4j.Element;

import edu.nju.lms.VO.PaymentVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.EnumTransformer;
import edu.nju.lms.presentation.components.MyLabel;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class PayListTable extends MyTable implements MouseListener{
	private static final long serialVersionUID = -6884113488119627648L;
	public PayListTable(Element element, UIController controller) {
		super(element, controller);
	}

	@Override
	protected void getData() {
	}

	public MyTableLabel createLabel(PaymentVO pay) {
		String type = EnumTransformer.payment2Str(pay.getPaymentType());
		MyLabel typeLabel = new MyLabel(type);
		typeLabel.setSize(30,30);
		MyLabel idLabel = new MyLabel(pay.getId());
		idLabel.setSize(80,30);
		MyLabel timeLabel = new MyLabel(pay.getPayTime());
		timeLabel.setSize(80,30);
		MyLabel accountLabel = new MyLabel(pay.getAccount());
		accountLabel.setSize(80,30);
		MyLabel amountLabel = new MyLabel(pay.getAmount()+"");
		amountLabel.setSize(80,30);
		
		java.awt.Component[] component = { typeLabel, idLabel, timeLabel,accountLabel,amountLabel};
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		return null;
	}

}
