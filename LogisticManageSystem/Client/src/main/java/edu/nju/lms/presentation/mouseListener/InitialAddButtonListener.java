package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * @author tj
 * @date 2015年11月27日
 */
public class InitialAddButtonListener extends ButtonListener {

	public InitialAddButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		// TODO Auto-generated constructor stub
	}

	public void mouseReleased(MouseEvent e) {
		String content[] = new String[6];
		for(int i =0;i<6;i++){
			JTextField text = (JTextField) units.get(i);
			String c = text.getText();
			if(c.isEmpty()){
				new MyDialog("incomplete");
				return;
			}
			content[i]=c;
		}
		
	}
}
