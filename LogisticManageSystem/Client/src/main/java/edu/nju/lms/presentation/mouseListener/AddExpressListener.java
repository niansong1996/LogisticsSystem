package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.table.CheckInTable;

/**
 *@author tj
 *@date 2015年12月7日
 */
public class AddExpressListener extends ButtonListener {
	private CheckInTable table;
	public AddExpressListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.table = (CheckInTable) units.get(5);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		

	}

}
