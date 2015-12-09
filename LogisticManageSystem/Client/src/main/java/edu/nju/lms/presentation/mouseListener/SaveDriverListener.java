package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.DriverTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * save driver
 * @author cuihao
 * @date 2015-12-06 21:45:19
 */
public class SaveDriverListener extends ButtonListener {

	DriverTable table;
	TransportController transport;

	public SaveDriverListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (DriverTable) units.get(0);
		transport = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (transport == null) {
			return;
		}
		ArrayList<MyTableLabel> labels = table.getDataList();
		ResultMessage result = null;
		loop: for (int i = 0; i < labels.size(); i++) {
			MyTableLabel label = labels.get(i);
			String[] info = new String[8];
			for (int j = 0; j < 8; j++) {
				if (j == 5)
					continue;
				JTextField f = (JTextField) label.getComponents(j);
				if (!f.isEditable())
					continue loop;
				info[j] = f.getText();
			}
			@SuppressWarnings("unchecked")
			MyComboBox<String> sex = (MyComboBox<String>) label.getComponents(5);
			if (sex.getSelectedItem().equals("男")) {
				info[5] = "0";
			} else {
				info[5] = "1";
			}
			DriverVO driver = new DriverVO(info[0], info[1], info[2], info[3], info[4], Integer.parseInt(info[5]),
					info[6], info[7]);
			result = transport.updateDriver(driver);
			if (!result.isSuccess()) {
				new MyDialog(result.getErrorMessage(), true);
				return;
			}
		}
		new MyDialog("保存成功", true);
	}

}
