package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.presentation.UIController.UIController;

public class InquireListener extends ButtonListener{

	public InquireListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		// TODO Auto-generated constructor stub
	}
	
	public void mouseEntered(MouseEvent e) {
		button.setIn(true);
		controller.changeTo("InquirePanel");
		button.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
