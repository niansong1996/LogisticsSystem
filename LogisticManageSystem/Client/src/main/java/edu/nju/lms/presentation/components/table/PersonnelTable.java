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
		PersonnelController personnel = controller.getPersonnelController();
		ArrayList<PersonnelVO> persons = personnel.showAllPersonnel();
		for (int i = 0; i < persons.size(); i++) {
			PersonnelVO person = persons.get(i);
			String type = person.getDuty();
			MyComboBox box = new MyComboBox(element,controller);
			box.setSelectedItem(type);
			java.awt.Component[] component = { new MyTextField(person.getId()), new MyTextField(person.getName()),
					new MyTextField(person.getDepartmentNum()), box,new MyTextField(person.getSalary() + ""),
					new MyTextField(person.getPerTime() + ""),new MyTextField(person.getBonus() + "") };
			MyTableLabel label = new MyTableLabel(element, controller , 50, component,this);
			addData(label);
		}
	}

}
