package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;

import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * @author tj
 * @date 2015年11月25日
 */
public class FindDepartButtonListener extends ButtonListener {

	public FindDepartButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		// TODO Auto-generated constructor stub
	}

	public void mouseReleased(MouseEvent e) {
		DepartmentController departControl = controller.getDepartmentController();
		JTextField idField = (JTextField) units.get(5);
		String id = "";
		id = idField.getText();
		idField.setText("");
		if (id != "" && departControl != null) {
			DepartmentVO found = departControl.getDepartInfo(id);
			if (found == null) {
				MyDialog error = new MyDialog("notExist");
				return;
			}
			//TODO

		}
	}
}
