package edu.nju.lms.presentation.components.table;

import org.dom4j.Element;

import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyTextField;

public class CommodityTable extends MyTable{

	private static final long serialVersionUID = 1380293244986696457L;

	public CommodityTable(Element element, UIController controller) {
		super(element, controller);
	}

	@Override
	protected void getData() {
	}
	
	public void addCommodity(String commodityNum) {
		MyTextField commodity = new MyTextField(commodityNum);
		commodity.setSize(150,30);
		java.awt.Component components[] = {commodity};
		MyTableLabel label = new MyTableLabel(element, controller, 50, components, this);
		addData(label);
		setView();
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		// TODO Auto-generated method stub
		return null;
	}
}
