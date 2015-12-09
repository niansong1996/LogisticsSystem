package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyTextField;

/**
 *@author tj cuihao
 *@date 2015年12月7日
 */
public class WarehouseStoreTable extends MyTable {

	private static final long serialVersionUID = -2997760458693115259L;

	public WarehouseStoreTable(Element element, UIController controller) {
		super(element, controller);
		
	}

	@Override
	protected void getData() {
	}
	
	public ArrayList<MyTableLabel> createLabels(InventoryExcelVO inventoryvo) {
		ArrayList<MyTableLabel> labels = new ArrayList<MyTableLabel>();
		for(int i = 0; i < inventoryvo.getExpressNums().size(); i++) {
			MyTextField expressNum = new MyTextField(inventoryvo.getExpressNums().get(i));
			expressNum.setSize(100,30);
			MyTextField checkinTime = new MyTextField(inventoryvo.getCheckinTime().get(i));
			checkinTime.setSize(100,30);
			MyTextField destination = new MyTextField(inventoryvo.getDestination().get(i));
			destination.setSize(60,30);
			MyTextField location = new MyTextField(inventoryvo.getLocation().get(i));
			location.setSize(150,30);
			java.awt.Component components[] = {expressNum, checkinTime, destination, location};
			MyTableLabel label = new MyTableLabel(element, controller, 50, components, this);
			labels.add(label);
		}
		return labels;
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		return null;
	}

}
