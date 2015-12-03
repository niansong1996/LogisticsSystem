package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyCheckBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.MyTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * @author tj
 * @date 2015年11月25日
 */
public class DeleteDepartButtonListener extends ButtonListener {
	private DepartmentController control;
	private MyTable table;

	public DeleteDepartButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.table = (MyTable) units.get(0);
		control = controller.getDepartmentController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ArrayList<MyTableLabel> data = table.getDataList();
		ResultMessage result = null;
		for (int i = 0; i < data.size(); i++) {
			MyTableLabel label = data.get(i);
			MyCheckBox check = (MyCheckBox) label.getComponent(0);
			if (check.isSelected()) {
				JTextField field = (JTextField) label.getComponents(2);
				result = control.deleteDepartment(field.getText());
				if (result.isSuccess()) {
					table.my_remove(i);
					i--;
				}
			}
		}
		if (result.isSuccess()) {
			MyDialog dialog = new MyDialog("删除成功！", true);
		} else {
			MyDialog dialog = new MyDialog(result.getErrorMessage(), true);
		}
	}

}
