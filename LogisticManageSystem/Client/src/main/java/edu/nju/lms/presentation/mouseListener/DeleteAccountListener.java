package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyCheckBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyLabel;
import edu.nju.lms.presentation.components.table.AccountTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 *@author tj
 *@date 2015年12月7日
 */
public class DeleteAccountListener extends ButtonListener {
	private AccountTable table;
	private FinanceController control;
	public DeleteAccountListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.table = (AccountTable) units.get(0);
		this.control = controller.getFinanceController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ArrayList<MyTableLabel> data = table.getDataList();
		ResultMessage result = null;
		for (int i = 0; i < data.size(); i++) {
			MyTableLabel label = data.get(i);
			MyCheckBox check = (MyCheckBox) label.getComponent(0);
			if (check.isSelected()) {
				MyLabel field = (MyLabel) label.getComponents(0);
				result = control.deleteAccount((field.getText()));
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
