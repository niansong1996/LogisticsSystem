package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JTextField;

import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyCheckBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.MyTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * @author tj
 * @date 2015年11月20日
 */
public class DeletePersonButtonListener extends ButtonListener {
	private PersonnelController control;
	MyTable table;

	public DeletePersonButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.table = (MyTable) units.get(0);
		control = controller.getPersonnelController();
	}

	public void mouseReleased(MouseEvent e) {
		// PersonnelTableModel model = (PersonnelTableModel) table.getModel();
		// for(int i = 0; i < model.getRowCount(); i++) {
		// if(model.getValueAt(i, 0).equals(true)){
		// String id = (String) model.getValueAt(i, 1);
		// PersonnelController control = controller.getPersonnelController();
		// control.deletePersonnel(id);
		// model.removeRow(i);
		// i--;
		// }
		// }
		// table.repaint();
		ArrayList<MyTableLabel> data = table.getDataList();
		ResultMessage result = null;
		for (int i = 0; i < data.size(); i++) {
			MyTableLabel label = data.get(i);
			MyCheckBox check = (MyCheckBox) label.getComponent(0);
			if (check.isSelected()) {
				JTextField field = (JTextField) label.getComponents(0);
				result = control.deletePersonnel(field.getText());
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
