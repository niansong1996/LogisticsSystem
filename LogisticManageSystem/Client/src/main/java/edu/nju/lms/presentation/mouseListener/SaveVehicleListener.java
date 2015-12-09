package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.VehicleTable;

/**
 * Save vehicles which have changed.
 * @author cuihao
 * @date 2015-12-06 20:10:22
 */
public class SaveVehicleListener extends ButtonListener{

	VehicleTable table;
	TransportController transport;
	
	public SaveVehicleListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (VehicleTable) units.get(0);
		transport = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(transport==null) {
			return;
		}
		ArrayList<MyTableLabel> labels = table.getDataList();
		ResultMessage result = null;
loop:	for (int i = 0; i < labels.size(); i++) {
			MyTableLabel label = labels.get(i);
			String[] info = new String[4];
			for (int j = 0; j < 4; j++) {
				JTextField f = (JTextField) label.getComponents(j);
				if(!f.isEditable()) continue loop;
				info[j] = f.getText();
			}
			VehicleVO vehicle = new VehicleVO(info[1], info[0], info[3], Integer.parseInt(info[2]));
			result = transport.updateVehicle(vehicle);
			if (!result.isSuccess()) {
				new MyDialog(result.getErrorMessage(), true);
				return;
			}
		}
		new MyDialog("保存成功",true);
	}

}
