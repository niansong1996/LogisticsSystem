package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MainTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.PersonnelTable;
import edu.nju.lms.presentation.tableModel.PersonnelTableModel;

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
		ArrayList<MyTableLabel> labels = table.getDataList();
		for(int i =0;i<labels.size();i++){
			MyTableLabel label = labels.get(i);
			label.getComponent(0);
			//TODO
		}
//		PersonnelTableModel model = (PersonnelTableModel) table.getModel();
//		ArrayList<PersonnelVO> persons = model.getChanged();
//		PersonnelController control = controller.getPersonnelController();
//		for (PersonnelVO changed : persons) {
//			control.updatePersonnel(changed);
//		}
	}
}
