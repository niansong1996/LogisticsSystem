package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

public class ButtonChangeListener extends ButtonListener{

	public ButtonChangeListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		controller.changeTo(button.getElement().attributeValue("change"));
	}

}
