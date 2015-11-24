package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MainTable;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.tableModel.PersonnelTableModel;

/**
 *@author tj
 *@date 2015年11月20日
 */
public class FindPersonButtonListener extends ButtonListener {
	private PersonnelController personControl;
	public FindPersonButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		personControl = controller.getPersonnelController();
	}
	public void mouseReleased(MouseEvent e) {
		JTextField idField = (JTextField) units.get(14);
		String id = "";
		id = idField.getText();
		idField.setText("");
		if(id!=""&&personControl!=null){
			ArrayList<PersonnelVO> person = personControl.findPersonInfo(id);
			if(person.isEmpty()){
				MyDialog error = new MyDialog("notExist");
				return;
			}
//			ArrayList<PersonnelVO> person = new ArrayList<PersonnelVO>();
//			PersonnelVO p1 = new PersonnelVO("123457", "cuiods", "01", "总经理", 20000, 0, 100000);
//			PersonnelVO p2 = new PersonnelVO("12345724", "goulu", "01", "总经理", 20000, 0, 100000);
//			person.add(p1);
//			person.add(p2);
			MainTable table = (MainTable)units.get(9);
			PersonnelTableModel model = (PersonnelTableModel) table.getModel();
			model.setPersonnel(person);
			table.repaint();
		}
	}
}
