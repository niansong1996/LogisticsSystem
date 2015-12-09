package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * Add an account to database
 * @author tj
 * @date 2015年12月7日
 * @see FinanceController
 */
public class AddAccountConfirmListener extends ButtonListener {
	private FinanceController control;
	public AddAccountConfirmListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		control = controller.getFinanceController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		/*
		 * get text field
		 */
		JTextField account = (JTextField) units.get(0);
		JTextField balance = (JTextField) units.get(1);
		/*
		 * check input
		 */
		if(account.getText().isEmpty()||account.getText().isEmpty()){
			new MyDialog("incomplete");
			return;
		}
		/*
		 * whether is number
		 */
		if(!Numeric.isNumeric(balance.getText())){
			new MyDialog("信息格式不正确",true);
			return;
		}
		/*
		 * add an account
		 */
		AccountVO vo = new AccountVO(account.getText(),Double.parseDouble(balance.getText()));
		ResultMessage result = control.addAccount(vo);
		/*
		 * show result
		 */
		if(result.isSuccess()){
			/*
			 * clear text field
			 */
			account.setText("");
			balance.setText("");
			new MyDialog("addSuccess");
		}else{
			new MyDialog(result.getErrorMessage(),true);
		}
	}

}
