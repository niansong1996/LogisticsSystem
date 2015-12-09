package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.RentVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * Add rent pay list
 * @author tj
 * @date 2015年12月6日
 */
public class AddRentPayListener extends ButtonListener {
	private FinanceController control;

	public AddRentPayListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getFinanceController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		/*
		 * get data
		 */
		String[] info = new String[4];
		for (int i = 0; i < 4; i++) {
			JTextField field = (JTextField) units.get(i + 3);
			info[i] = field.getText();
			if(info[i].isEmpty()){
				new MyDialog("incomplete");
				return;
			}
			field.setText("");
		}
		if (!Numeric.isNumeric(info[1]) || !Numeric.isNumeric(info[3])) {
			new MyDialog("信息格式不正确", true);
			return;
		}
		/*
		 * create and save rent list
		 */
		RentVO vo = new RentVO(null, info[0], info[2], Double.parseDouble(info[1]), Integer.parseInt(info[3]));
		vo = control.createRent(vo);
		ResultMessage result = control.saveRent(vo);
		if (result.isSuccess()) {
			new MyDialog("付款成功", true);
		} else {
			new MyDialog(result.getErrorMessage(), true);
		}
	}

}
