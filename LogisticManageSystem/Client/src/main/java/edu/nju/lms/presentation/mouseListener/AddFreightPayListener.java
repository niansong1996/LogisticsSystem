package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.FreightVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 *@author tj
 *@date 2015年12月6日
 */
public class AddFreightPayListener extends ButtonListener {
	private FinanceController control;
	public AddFreightPayListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getFinanceController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTextField field = (JTextField) units.get(5);
		String account = field.getText();
		if(account.isEmpty()){
			new MyDialog("incomplete");
			return;
		}

		FreightVO vo =  control.createFreight(account);
		ResultMessage result = control.saveFreight(vo);
		if (result.isSuccess()) {
			new MyDialog("付款成功", true);
		} else {
			new MyDialog(result.getErrorMessage(), true);
		}
		JTextField payTime = (JTextField) units.get(3);
		payTime.setText(vo.getPayTime());
		JTextField payAmount = (JTextField) units.get(4);
		payAmount.setText(vo.getAmount()+"");

	}

}
