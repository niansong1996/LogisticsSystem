package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * @author tj
 * @date 2015年11月26日
 */
public class SaveSalaryStrategyButtonListener extends ButtonListener {

	public SaveSalaryStrategyButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		// TODO Auto-generated constructor stub
	}

	public void mouseReleased(MouseEvent e) {
//		FinanceController control = controller.getFinanceController();
//		ResultMessage result = null;
//		for (int i = 0; i < 8; i++) {
//			String type = units.get(i).getName();
//			JTextField basicField = (JTextField) units.get(i);
//			JTextField perTimeField = (JTextField) units.get(i + 8);
//			JTextField bonusField = (JTextField) units.get(i + 16);
//			if (basicField.getText().isEmpty() || perTimeField.getText().isEmpty() || bonusField.getText().isEmpty()) {
//				MyDialog error = new MyDialog("incomplete");
//				return;
//			}
//			double basic = Double.parseDouble(basicField.getText());
//			double perTime = Double.parseDouble(perTimeField.getText());
//			double bonus = Double.parseDouble(bonusField.getText());
//			SalaryStrategyVO vo = new SalaryStrategyVO(type, basic, perTime, bonus);
//			if (control.findSalaryStrategy(type) == null) {
//				result = control.addSalaryStrategy(vo);
//			} else {
//				result = control.updateSalaryStrategy(vo);
//			}
//		}
//		if (result.isSuccess()) {
//			MyDialog error = new MyDialog("addSuccess");
//		} else {
//			MyDialog error = new MyDialog(result.getErrorMessage(), true);
//		}
	}
}
