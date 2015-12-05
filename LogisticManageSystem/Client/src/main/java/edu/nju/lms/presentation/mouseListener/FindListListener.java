package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.presentation.UIController;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class FindListListener extends ButtonListener {
	private ListController control;
	public FindListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getListController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTextField idField = (JTextField) units.get(2);
		String id = idField.getText();
		idField.setText("");
		if(id.isEmpty()||control==null){
			return;
		}
		//TODO
	}

}
