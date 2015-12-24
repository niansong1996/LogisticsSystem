package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * Add salary pay list
 * @author tj
 * @date 2015年12月6日
 */
public class AddSalaryPayListener extends ButtonListener {
	private FinanceController control;

	public AddSalaryPayListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getFinanceController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTextField field = (JTextField) units.get(5);
		String account = field.getText();
		if(account.isEmpty()){
			new MyDialog("incomplete",controller);
			return;
		}

		SalaryVO vo =  control.createSalary(account);
		ResultMessage result = control.saveSalary(vo);
		if (result.isSuccess()) {
			new MyDialog("付款成功", true,controller);
		} else {
			new MyDialog(result.getErrorMessage(), true,controller);
		}
		JTextField payTime = (JTextField) units.get(3);
		payTime.setText(vo.getPayTime());
		JTextField payAmount = (JTextField) units.get(4);
		payAmount.setText(vo.getAmount()+"");
	}

}
