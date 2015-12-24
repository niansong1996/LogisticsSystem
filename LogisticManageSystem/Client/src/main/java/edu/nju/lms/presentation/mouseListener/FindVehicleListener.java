package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.VehicleTable;

/**
 * Find vehicle by vehicleNum
 * @author cuihao
 * @date 2015-12-06 20:33:25
 */
public class FindVehicleListener extends ButtonListener{
	
	VehicleTable table;
	TransportController transport;
	
	public FindVehicleListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (VehicleTable) units.get(0);
		transport = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MyTextField id = (MyTextField) units.get(5);
		if(id.getText().isEmpty()){
			new MyDialog("incomplete", controller);
			return;
		}
		VehicleVO vehicle = transport.findVehicle(id.getText());
		id.setText("");
		if(vehicle==null) {
			new MyDialog("notExist", controller);
			return;
		}
		ArrayList<MyTableLabel> labels = new ArrayList<MyTableLabel>(1);
		MyTableLabel label = table.createLabel(vehicle);
		labels.add(label);
		table.setDataList(labels);
	}

}
