package edu.nju.lms.presentation.mouseListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


import edu.nju.lms.presentation.components.MyTextField;

/**
 *@author tj
 *@date 2015年12月9日
 */
public class TextFieldListener implements FocusListener{
	protected MyTextField field;
	public TextFieldListener(MyTextField button) {
		this.field = (MyTextField)button;
	}
	public void focusGained(FocusEvent e) {
		field.setIn(true);
		field.repaint();
	}
	public void focusLost(FocusEvent e) {
		field.setIn(false);
		field.repaint();
	}

	

}
