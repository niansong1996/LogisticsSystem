package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.presentation.UIController;

public class AddUserListener extends ButtonListener{

	public AddUserListener(ArrayList<Component> units, UIController controller,Component button) {
		super(units, controller, button);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		controller.changeTo("AddUserPanel");
		
	}

}
