package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.presentation.UIController;

/**
 * Clear text
 *@author tj
 *@date 2015年12月7日
 */
public class CancelAddExpressListener extends ButtonListener {
	
	public CancelAddExpressListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(int i =0;i<4;i++){
			JTextField field = (JTextField)units.get(i);
			field.setText("");
		}
		JTextField f = (JTextField)units.get(7);
		f.setText("");
	}

}
