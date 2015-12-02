package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * Personnel table
 * 
 * @author cuihao
 * @date 2015-11-29 23:40:23
 */
public class PersonnelTable extends MyTable {

	private static final long serialVersionUID = -1092472707437508188L;

	private ArrayList<PersonnelVO> persons;
	private PersonnelController personnel;

	public PersonnelTable(Element element, UIController controller) {
		super(element, controller);
		persons = new ArrayList<PersonnelVO>();
		personnel = controller.getPersonnelController();
	}

	@Override
	protected void getData() {
		personnel = controller.getPersonnelController();
		persons = personnel.showAllPersonnel();
		for (int i = 0; i < persons.size(); i++) {
			MyTableLabel label = createLabel(persons.get(i));
			addData(label);
		}
	}

	public MyTableLabel createLabel(PersonnelVO person) {
		String type = person.getDuty();
		MyComboBox box = new MyComboBox(element, controller);
		box.setSize(150, 30);
		box.setSelectedItem(type);
		MyTextField personID = new MyTextField(person.getId());
		personID.setSize(100, 30);
		MyTextField personName = new MyTextField(person.getName());
		personName.setSize(80, 30);
		MyTextField personDepartment = new MyTextField(person.getDepartmentNum());
		personDepartment.setSize(100, 30);
		MyTextField personSalary = new MyTextField(person.getSalary() + "");
		personSalary.setSize(80, 30);
		MyTextField personPertime = new MyTextField(person.getPerTime() + "");
		personPertime.setSize(60, 30);
		MyTextField personBounus = new MyTextField(person.getBonus() + "");
		personBounus.setSize(80, 30);
		java.awt.Component[] component = { personID, personName, personDepartment, personSalary, personPertime,
				personBounus, box };
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);

		return label;

	}
}
