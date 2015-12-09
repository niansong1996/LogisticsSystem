package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 * @author tj
 * @date 2015年11月26日
 */
public class ShowSalaryStrategyButtonListener extends ButtonListener {
	private FinanceController finance;

	public ShowSalaryStrategyButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		finance = controller.getFinanceController();
	}

	public void mouseReleased(MouseEvent e) {
		if (finance != null) {
			for (int i = 0; i < 8; i++) {
				JTextField basicField = (JTextField) units.get(i);
				JTextField perTimeField = (JTextField) units.get(i + 8);
				JTextField bonusField = (JTextField) units.get(i + 16);
				String type = units.get(i).getName();
				SalaryStrategyVO vo = finance.findSalaryStrategy(type);
				 basicField.setText(vo.getBasic()+"");
				 perTimeField.setText(vo.getPerTime()+"");
				 bonusField.setText(vo.getBasic()+"");
				/*basicField.setText("hh");
				perTimeField.setText("hhhh");
				bonusField.setText("sss");
				controller.getFrame().repaint();*/
			}
	}
	}
}
