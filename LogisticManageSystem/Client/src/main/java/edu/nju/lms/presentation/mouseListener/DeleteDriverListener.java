package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyCheckBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.DriverTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * delete driver
 * @author cuihao
 * @date 2015-12-06 21:32:20
 */
public class DeleteDriverListener extends ButtonListener{

	private TransportController manage;
	private DriverTable table;
	
	public DeleteDriverListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (DriverTable) units.get(0);
		manage = controller.getTransportController();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ArrayList<MyTableLabel> data = table.getDataList();
		ResultMessage result = null;
		for (int i = 0; i < data.size(); i++) {
			MyTableLabel label = data.get(i);
			MyCheckBox check = (MyCheckBox) label.getComponent(0);
			if (check.isSelected()) {
				JTextField field = (JTextField) label.getComponents(0);
				result = manage.deleteDriver(field.getText());
				if (result.isSuccess()) {
					table.my_remove(i);
					i--;
				}
			}
		}
		if (result.isSuccess()) {
			new MyDialog("删除成功！", true);
		} else {
			new MyDialog(result.getErrorMessage(), true);
		}
	}

}
