package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.presentation.UIController;

/**
 *@author tj
 *@date 2015年11月24日
 */
public class ManageBackButtonListener extends ButtonListener {

	public ManageBackButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		// TODO Auto-generated constructor stub
	}
	public void mouseEntered(MouseEvent e) {
		button.setIn(true);
		button.repaint();
	}
	public void mouseReleased(MouseEvent e) {
		controller.changeTo("ManagerPanel");
		
	}
	
}
