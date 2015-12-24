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
import edu.nju.lms.presentation.components.table.DepartmentTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 *@author tj
 *@date 2015年11月25日
 */
public class SaveDepartButtonListener extends ButtonListener {
	private DepartmentTable table;
	public SaveDepartButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (DepartmentTable) units.get(0);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		DepartmentController department = controller.getDepartmentController();
		if (department == null) {
			System.out.println("departmentController is null");
			return;
		}
		ArrayList<MyTableLabel> labels = table.getDataList();
		ResultMessage result = null;
		for (int i = 0; i < labels.size(); i++) {
			MyTableLabel label = labels.get(i);
			JTextField loc = (JTextField) label.getComponents(0);
			String location = loc.getText();
			JTextField num = (JTextField)label.getComponents(2);
			String number = num.getText();
			JComboBox<?> box = (JComboBox<?>) label.getComponents(1);
			String t = box.getSelectedItem().toString();
			DepartmentType type = null;
			if(t.equals("营业厅")){
				type = DepartmentType.BUSINESSHALL;
			}else if(t.equals("中转中心")){
				type = DepartmentType.TRANSITCENTER;
			}
			DepartmentVO vo = new DepartmentVO(type, number, location);
			DepartmentVO find = department.getDepartInfo(number);
			if (find!=null) {
				result = department.updateDepartment(vo);
			}
		}
		if (result.isSuccess()) {
			new MyDialog("保存成功！", true,controller);
		} else {
			new MyDialog(result.getErrorMessage(), true,controller);
		}
		
	}

}
