package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController;

public class AddDriverListener extends ButtonListener{

	TransportController transport;
	public AddDriverListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		transport = new TransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
