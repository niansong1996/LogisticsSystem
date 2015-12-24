package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 *@author tj
 *@date 2015年12月7日
 */
public class SavePartitionListener extends ButtonListener {
	public SavePartitionListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		controller.getWarehouseController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		new MyDialog("修改成功",true,controller);
	}

}
