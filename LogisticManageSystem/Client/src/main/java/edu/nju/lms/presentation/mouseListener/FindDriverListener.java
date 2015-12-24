package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;
import edu.nju.lms.presentation.components.table.DriverTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * find driver by id
 * @author cuihao
 * @date 2015-12-06 21:56:28
 */
public class FindDriverListener extends ButtonListener{

	DriverTable table;
	TransportController transport;
	
	public FindDriverListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (DriverTable) units.get(0);
		transport = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MyTextField id = (MyTextField) units.get(1);
		if(id.getText().isEmpty()){
			new MyDialog("incomplete", controller);
			return;
		}
		DriverVO driver = transport.findDriver(id.getText());
		id.setText("");
		if(driver==null) {
			new MyDialog("notExist", controller);
			return;
		}
		ArrayList<MyTableLabel> labels = new ArrayList<MyTableLabel>(1);
		MyTableLabel label = table.createLabel(driver);
		labels.add(label);
		table.setDataList(labels);
	}

}
