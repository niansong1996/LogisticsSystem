package edu.nju.lms.presentation.mouseListener;

import java.awt.Button;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.DateChooser;
import edu.nju.lms.presentation.components.MyLabel;

/**
 * @author tj
 * @date 2015年12月7日
 */
public class ShowSumReceiptListener extends ButtonListener {
	private FinanceController control;
	private double sum;
	public ShowSumReceiptListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getFinanceController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		DateChooser choose = (DateChooser) units.get(1);
		Calendar date = Calendar.getInstance();
		date.setTime(choose.getDate());
		sum = control.getReceiptSum(date);
		MyLabel sumLabel = (MyLabel) units.get(4);
		sumLabel.setText("当日成本收益为：" + sum + "");
	}

	public double getSum() {
		return sum;
	}
}
