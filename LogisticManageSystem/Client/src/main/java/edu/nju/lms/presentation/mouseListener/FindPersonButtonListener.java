package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MainTable;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.PersonnelTable;
import edu.nju.lms.presentation.tableModel.PersonnelTableModel;

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
		idField.setText("");
		if (id != "" && personControl != null) {
			ArrayList<PersonnelVO> found = personControl.findPersonInfo(id);
			if (found.isEmpty()) {
				MyDialog error = new MyDialog("notExist");
				return;
			}
			ArrayList<MyTableLabel> labels = new ArrayList<MyTableLabel>();
			PersonnelTable table = (PersonnelTable)units.get(0);
			for (int i = 0; i < found.size(); i++) {
				PersonnelVO person = found.get(i);
				String type = person.getDuty();
				MyComboBox box = new MyComboBox(table.getElement(),controller);
				box.setSelectedItem(type);
				java.awt.Component[] components = { new MyTextField(person.getId()), new MyTextField(person.getName()),
						new MyTextField(person.getDepartmentNum()),new MyTextField(person.getSalary() + ""),
						new MyTextField(person.getPerTime() + ""),new MyTextField(person.getBonus() + "") ,box};
				MyTableLabel label = new MyTableLabel(button.getElement(),controller,50,components,table);
				labels.add(label);
			}
			table.setDataList(labels);
				// Vector<Object[]> persons = new Vector<Object[]>();
			
			// PersonnelVO p = new PersonnelVO("123457", "cuiods", "01", "总经理",
			// 20000, 0, 100000);
			// PersonnelVO p1 = new PersonnelVO("12345724", "goulu", "01",
			// "总经理", 20000, 0, 100000);
			// for (PersonnelVO p1 : found) {
			// Object[] rowData = { new Boolean(false), p1.getId(),
			// p1.getName(), p1.getDepartmentNum(), p1.getDuty(),
			// new Double(p1.getSalary()), new Double(p1.getPerTime()), new
			// Double(p1.getBonus()), "", "" };
			// persons.add(rowData);
			// PersonnelTable table = (PersonnelTable) units.get(0);
			// PersonnelTableModel model = (PersonnelTableModel)
			// table.getModel();
			// model.setData(persons);
			// table.repaint();
			// }
		}
	}
}
