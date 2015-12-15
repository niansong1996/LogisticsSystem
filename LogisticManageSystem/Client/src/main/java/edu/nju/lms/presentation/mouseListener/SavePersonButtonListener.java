package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.PersonnelTable;

/**
 * @author tj
 * @date 2015年11月20日
 */
public class SavePersonButtonListener extends ButtonListener {
	private PersonnelTable table;

	public SavePersonButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (PersonnelTable) units.get(0);
	}

	public void mouseReleased(MouseEvent e) {
		PersonnelController personnel = controller.getPersonnelController();
		if (personnel == null) {
			System.out.println("personnelController is null");
			return;
		}
		ArrayList<MyTableLabel> labels = table.getDataList();
		ResultMessage result = null;
		boolean inComplete = false;
		for (int i = 0; i < labels.size(); i++) {
			MyTableLabel label = labels.get(i);
			//为了创建vo方便把一些信息放在了string数组里
			String[] info = new String[6];
			for (int j = 0; j < 6; j++) {
				JTextField f = (JTextField) label.getComponents(j);
				if (f.getText().isEmpty()) {
					inComplete = true;
				}
				info[j] = f.getText();
			}
			// 这样可以只弹出一个对话框...
			if (inComplete) {
				new MyDialog("incomplete");
				return;
			}
			JComboBox box = (JComboBox) label.getComponents(6);
			String duty = box.getSelectedItem().toString();
			PersonnelVO vo = new PersonnelVO(info[0], info[1], info[2], duty, Double.parseDouble(info[3]),
					Double.parseDouble(info[4]), Double.parseDouble(info[5]));
			ArrayList<PersonnelVO> finds = personnel.findPersonInfo(info[0]);
			PersonnelVO find = finds.get(0);
			if (find != null) {
				result = personnel.updatePersonnel(vo);
			}
		}
		if (result.isSuccess()) {
			new MyDialog("保存成功！", true);
		} else {
			new MyDialog(result.getErrorMessage(), true);
		}
	}
}
