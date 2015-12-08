package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;

public class SetWarningListener extends ButtonListener{

	public SetWarningListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MyTextField warning  = (MyTextField) units.get(0);
		MyTextField num = (MyTextField) units.get(1);
		WarehouseController warehouse = controller.getWarehouseController();
		ResultMessage result = warehouse.setCordon(Integer.parseInt(warning.getText())/100.0, num.getText());
		if(result.isSuccess()) {
			new MyDialog("addSuccess");
		}else{
			new MyDialog(result.getErrorMessage(),true);
		}
	}

}
