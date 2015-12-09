package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import edu.nju.lms.presentation.UIController.UIController;

public class LogInListener extends ButtonListener{

	public LogInListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}
	
	public void mouseEntered(MouseEvent e) {
		button.setIn(true);
		controller.changeTo("MainPanel");
		button.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
