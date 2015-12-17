package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.CircleBase;
import edu.nju.lms.presentation.components.CircleButton;

/**
 *@author tj
 *@date 2015年12月17日
 */
public class ChangeCarListener extends ChangePartitionListener{

	public ChangeCarListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}


	@Override
	public void initialize() {
		button = (CircleButton) units.get(6);
		base = (CircleBase) units.get(9);
		this.name = button.getName();
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		
	}

}
