package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.table.CheckoutTable;

/**
 * @author tj
 * @date 2015年12月7日
 */
public class AddCheckoutListener extends ButtonListener {
	private CheckoutTable table;

	public AddCheckoutListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.table = (CheckoutTable) units.get(5);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String[] info = new String[4];
		for (int i = 0; i < 4; i++) {
			JTextField field = (JTextField) units.get(i);
			if (field.getText().isEmpty()) {
				return;
			}
			info[i] = field.getText();
		}
		MyComboBox box = (MyComboBox) units.get(4);
		String partition = (String) box.getSelectedItem();
		table.addLabel(info[0], partition, info[1], info[2], info[3]);
	}

}
