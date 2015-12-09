package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.data.DepartmentType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * Add a department to database
 * @author tj
 * @date 2015年11月25日
 */
public class AddDepartConfirmListener extends ButtonListener {

	public AddDepartConfirmListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}

	public void mouseReleased(MouseEvent e) {
		/*
		 * get text field
		 */
		JTextField num = (JTextField) units.get(0);
		String departmentNum = num.getText();
		JTextField loc = (JTextField) units.get(1);
		String location = loc.getText();
		/*
		 * check empty
		 */
		if (location.isEmpty() || departmentNum.isEmpty()) {
			new MyDialog("incomplete");
			return;
		}
		JComboBox<?> box = (JComboBox<?>) units.get(2);
		String t = (String) box.getSelectedItem();
		DepartmentType type = null;
		/*
		 * convert department type
		 */
		if (t.equals("营业厅")) {
			type = DepartmentType.BUSINESSHALL;
		} else if (t.equals("中转中心")) {
			type = DepartmentType.TRANSITCENTER;
		}
		//根据界面得到的信息创建vo
		DepartmentVO depart = new DepartmentVO(type, departmentNum, location);
		DepartmentController control = controller.getDepartmentController();
		if (control != null) {
			ResultMessage re = control.addDepartment(depart);
			if (re.isSuccess()) {
				num.setText("");
				loc.setText("");
				new MyDialog("addSuccess");
			} else {
				new MyDialog(re.getErrorMessage(),true);
			}
		}
	}

}
