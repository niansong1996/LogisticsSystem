package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MainTable;
import edu.nju.lms.presentation.tableModel.PersonnelTableModel;

/**
 *@author tj
 *@date 2015年11月20日
 */
public class DeletePersonButtonListener extends ButtonListener {

	MainTable table;
	
	public DeletePersonButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (MainTable) units.get(0);
	}
	
	public void mouseReleased(MouseEvent e) {
		PersonnelTableModel model = (PersonnelTableModel) table.getModel();
		for(int i = 0; i < model.getRowCount(); i++) {
			if(model.getValueAt(i, 0).equals(true)){
				String id = (String) model.getValueAt(i, 1);
				PersonnelController control = controller.getPersonnelController();
				control.deletePersonnel(id);
				model.removeRow(i);
				i--;
			}
		}
		table.repaint();
	}

}
