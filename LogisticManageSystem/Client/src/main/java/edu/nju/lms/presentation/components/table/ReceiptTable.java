package edu.nju.lms.presentation.components.table;

import org.dom4j.Element;

import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class ReceiptTable extends MyTable {

	public ReceiptTable(Element element, UIController controller) {
		super(element, controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void getData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		// TODO Auto-generated method stub
		return null;
	}

}
