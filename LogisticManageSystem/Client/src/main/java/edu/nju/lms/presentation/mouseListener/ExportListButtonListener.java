package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class ExportListButtonListener extends ButtonListener {

	public ExportListButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		FinanceController finance = controller.getFinanceController();
		finance.exportEarning(earnings)
	}

}
