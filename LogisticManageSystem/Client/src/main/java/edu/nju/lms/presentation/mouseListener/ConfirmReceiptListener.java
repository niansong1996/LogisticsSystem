package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;

import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.DateChooser;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyLabel;

/**
 * @author tj
 * @date 2015年12月7日
 */
public class ConfirmReceiptListener extends ButtonListener {
	private FinanceController control;
    
	public ConfirmReceiptListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		control = controller.getFinanceController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTextField field = (JTextField) units.get(5);
		if(field.getText().isEmpty()){
			return;
		}
		DateChooser choose = (DateChooser) units.get(1);
		Calendar date = Calendar.getInstance();
		date.setTime(choose.getDate());
		double sum = control.getReceiptSum(date);
		MyLabel sumLabel = (MyLabel) units.get(4);
		ResultMessage result = control.addMoney(field.getText(), sum);
		if(result.isSuccess()){
			new MyDialog("收款成功！",true);
		}else{
			new MyDialog(result.getErrorMessage(),true);
		}
	}

}
