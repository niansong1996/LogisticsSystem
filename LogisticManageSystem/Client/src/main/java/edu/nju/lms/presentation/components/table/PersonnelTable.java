package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * Personnel table
 * @author cuihao
 * @date 2015-11-29 23:40:23
 */
public class PersonnelTable extends MyTable{

	private static final long serialVersionUID = -1092472707437508188L;
	
	private ArrayList<PersonnelVO> persons = new ArrayList<PersonnelVO>();
	
	public PersonnelTable(Element element, UIController controller) {
		super(element, controller);
	}

	@Override
	protected void getData() {
		persons = new ArrayList<PersonnelVO>();
		PersonnelVO p = new PersonnelVO("123", "cui", "123", "manager", 0, 0, 0);
		persons.add(p);
		persons.add(p);
		for (int i = 0; i < persons.size(); i++) {
			PersonnelVO person = persons.get(i);
			java.awt.Component[] component = { new MyTextField(person.getId()), new MyTextField(person.getName()),
					new MyTextField(person.getDepartmentNum()), new MyTextField(person.getDuty()),
					new MyTextField(person.getSalary() + ""), new MyTextField(person.getPerTime() + ""),
					new MyTextField(person.getBonus() + "") };
			MyTableLabel label = new MyTableLabel(element, 50, component,this);
			addData(label);
		}
	}

}
