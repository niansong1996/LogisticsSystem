package edu.nju.lms.presentation.components.table;

import org.dom4j.Element;

import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.EnumTransformer;
import edu.nju.lms.presentation.components.MyLabel;

/**
 * @author tj
 * @date 2015年12月14日
 */
public class ReceiptTable extends MyTable {
	private static final long serialVersionUID = 2138623379130275838L;

	public ReceiptTable(Element element, UIController controller) {
		super(element, controller);
	}

	@Override
	protected void getData() {
	}

	public MyTableLabel createLabel(ReceiptVO vo) {
		MyLabel idLabel = new MyLabel(vo.getId());
		idLabel.setSize(80, 30);
		MyLabel timeLabel = new MyLabel(vo.getReceiptDate());
		timeLabel.setSize(80, 30);
		MyLabel accountLabel = new MyLabel(vo.getCourierNum());
		accountLabel.setSize(80, 30);
		MyLabel amountLabel = new MyLabel("");
		if (vo.getExpressNums() != null) {
			amountLabel = new MyLabel(vo.getExpressNums().size() + "");
		}
		amountLabel.setSize(80, 30);
		java.awt.Component[] component = { idLabel,  timeLabel,accountLabel, amountLabel };
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		return null;
	}

}
