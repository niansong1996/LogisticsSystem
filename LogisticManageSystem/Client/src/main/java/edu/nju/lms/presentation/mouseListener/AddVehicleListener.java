package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * add Vehicle
 * @author cuihao
 * @date addVehicle
 */
public class AddVehicleListener extends ButtonListener{

	TransportController transport;
	public AddVehicleListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		transport = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (transport == null)
			return;
		MyTextField plateNum = (MyTextField) units.get(0);
		MyTextField years = (MyTextField) units.get(1);
		MyTextField business = (MyTextField) units.get(2);
		if (plateNum.getText().equals("") || years.getText().equals("") || business.getText().equals("")) {
			new MyDialog("incomplete");
			return;
		}
		VehicleVO vehicle = new VehicleVO("", plateNum.getText(), business.getText(),
				Integer.parseInt(years.getText()));
		VehicleVO finalVehicle = transport.addVehicle(vehicle);
		ResultMessage result = transport.saveVehicleInfor(finalVehicle);
		if (result.isSuccess()) {
			new MyDialog("addSuccess");
		} else {
			new MyDialog(result.getErrorMessage(), true);
		}
	}

}
