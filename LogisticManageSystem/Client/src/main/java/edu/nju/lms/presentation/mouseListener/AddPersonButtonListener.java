package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.presentation.MainPanel;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.config.PanelConfig;

/**
 *@author tj
 *@date 2015年11月20日
 */
public class AddPersonButtonListener extends ButtonListener{

	public AddPersonButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}

	public void mouseReleased(MouseEvent e) {
		controller.changeTo("AddPersonPanel");
	}
}
