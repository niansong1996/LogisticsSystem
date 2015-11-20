package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MainButton;

/**
 *@author tj
 *@date 2015年11月19日
 */
public class PersonnelManageButtonListener extends ButtonListener {

	public PersonnelManageButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}
	
	public void mouseReleased(MouseEvent e) {
		controller.changeTo("PersonnelManagePanel");
	}
}
