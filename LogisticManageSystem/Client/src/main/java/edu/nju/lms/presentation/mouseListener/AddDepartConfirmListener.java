package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.data.DepartmentType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * @author tj
 * @date 2015年11月25日
 */
public class AddDepartConfirmListener extends ButtonListener {

	public AddDepartConfirmListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		// TODO Auto-generated constructor stub
	}

	public void mouseReleased(MouseEvent e) {
		JTextField num = (JTextField) units.get(0);
		String departmentNum = num.getText();
		JTextField loc = (JTextField) units.get(1);
		String location = loc.getText();
		if (location.isEmpty() || departmentNum.isEmpty()) {
			MyDialog error = new MyDialog("incomplete");
			return;
		}
		JComboBox box = (JComboBox) units.get(2);
		String t = (String) box.getSelectedItem();
		DepartmentType type = null;
		switch (t) {
		case "营业厅":
			type = DepartmentType.BUSINESSHALL;
			break;

		case "中转中心":
			type = DepartmentType.TRANSITCENTER;
		}
		DepartmentVO depart = new DepartmentVO(type, departmentNum, location);
		DepartmentController control = controller.getDepartmentController();
		if (control != null) {
			ResultMessage re = control.addDepartment(depart);
			if (re.isSuccess()) {
				num.setText("");
				loc.setText("");
				MyDialog error = new MyDialog("addSuccess");
			} else {
				MyDialog error = new MyDialog(re.getErrorMessage());
			}
		}
	}

}
