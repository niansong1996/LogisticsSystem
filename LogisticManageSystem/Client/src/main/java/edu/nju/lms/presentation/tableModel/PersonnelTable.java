package edu.nju.lms.presentation.tableModel;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyTable;
import edu.nju.lms.presentation.components.MyTableLabel;
import edu.nju.lms.presentation.components.MyTextField;

public class PersonnelTable extends MyTable{

	private static final long serialVersionUID = -1092472707437508188L;
	
	private ArrayList<PersonnelVO> persons = new ArrayList<PersonnelVO>();
	
	Element element;
	public PersonnelTable(Element element, UIController controller) {
		super(element, controller);
		this.element = element;
	}

	@Override
	protected void getData() {
		PersonnelVO p = new PersonnelVO("123", "cui", "123", "manager", 0, 0, 0);
		persons.add(p);
		for (int i = 0; i < persons.size(); i++) {
			PersonnelVO person = persons.get(i);
			java.awt.Component[] component = { new MyTextField(person.getId()), new MyTextField(person.getName()),
					new MyTextField(person.getDepartmentNum()), new MyTextField(person.getDuty()),
					new MyTextField(person.getSalary() + ""), new MyTextField(person.getPerTime() + ""),
					new MyTextField(person.getBonus() + "") };
			MyTableLabel label = new MyTableLabel(element, 50, component);
			addData(label);
		}
	}

}
