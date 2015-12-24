package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.PersonnelTable;

/**
 * @author tj
 * @date 2015年11月20日
 */
public class FindPersonButtonListener extends ButtonListener {
	private PersonnelController personControl;

	public FindPersonButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		personControl = controller.getPersonnelController();
	}

	public void mouseReleased(MouseEvent e) {
		JTextField idField = (JTextField) units.get(5);
		String id = "";
		id = idField.getText();
		if(id.isEmpty()){
			new MyDialog("incomplete", controller);
			return;
		}
		idField.setText("");
		if (id != "" && personControl != null) {
			ArrayList<PersonnelVO> found = personControl.findPersonInfo(id);
			if (found.isEmpty()) {
				new MyDialog("notExist", controller);
				return;
			}
			ArrayList<MyTableLabel> labels = new ArrayList<MyTableLabel>();
			PersonnelTable table = (PersonnelTable)units.get(0);
			for (int i = 0; i < found.size(); i++) {
				PersonnelVO person = found.get(i);
				MyTableLabel label = table.createLabel(person);
				labels.add(label);
			}
			table.setDataList(labels);
		}
	}
}
