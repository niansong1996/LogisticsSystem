package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.PO.Location;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyTextField;

/**
 *@author tj
 *@date 2015年12月7日
 */
public class CheckInTable extends MyTable {
	private static final long serialVersionUID = -5532756998227448564L;
	public CheckInTable(Element element, UIController controller) {
		super(element, controller);
	}

	@Override
	protected void getData() {
		// TODO Auto-generated method stub

	}
	public MyTableLabel createLabel(String expressNum,String partition,String row,String item,String destination){
		MyTextField num = new MyTextField(expressNum);
		num.setSize(100,30);
		MyTextField part = new MyTextField(partition);
		part.setSize(50,30);
		MyTextField r = new MyTextField(row);
		r.setSize(30,30);
		MyTextField ite = new MyTextField(item);
		ite.setSize(30,30);
		MyTextField desti = new MyTextField(destination);
		desti.setSize(80,30);
		
		java.awt.Component[] component = {num,part,r,ite,desti};
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}

	public void addLabel(String expressNum,String partition,String row,String item,String destination) {
		MyTableLabel label = createLabel(expressNum, partition, row, item, destination);
		this.myAddLabel(label);
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		return null;
	}
}
