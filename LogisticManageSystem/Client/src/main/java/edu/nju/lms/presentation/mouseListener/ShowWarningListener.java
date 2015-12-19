package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 *@author tj
 *@date 2015年12月8日
 */
public class ShowWarningListener extends ButtonListener {
	private WarehouseController control;
	public ShowWarningListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getWarehouseController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTextField field = (JTextField)units.get(0);
		if(field.getText().isEmpty()){
			new MyDialog("incomplete");
			return;
		}
		String warehouseNum = field.getText();
		if(warehouseNum.isEmpty()){
			return;
		}
		String warning = control.getCordon(warehouseNum)+"";
		JTextField wa = (JTextField)units.get(1);
		wa.setText(warning);
	}

}
