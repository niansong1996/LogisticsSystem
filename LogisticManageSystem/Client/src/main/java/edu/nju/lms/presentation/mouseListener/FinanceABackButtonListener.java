package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.presentation.UIController.UIController;

/**
 * @author tj
 * @date 2015年11月27日
 */
public class FinanceABackButtonListener extends ButtonListener {

	public FinanceABackButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		// TODO Auto-generated constructor stub
	}

	public void mouseReleased(MouseEvent e) {
		controller.changeTo("FinancialAdvancedPanel");
	}

}
