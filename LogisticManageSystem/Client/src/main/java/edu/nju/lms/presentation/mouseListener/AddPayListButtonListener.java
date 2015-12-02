package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * @author tj
 * @date 2015年11月27日
 */
public class AddPayListButtonListener extends ButtonListener {

	public AddPayListButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		// TODO Auto-generated constructor stub
	}

	public void mouseReleased(MouseEvent e) {
		FinanceController finance = controller.getFinanceController();
		String[] content = new String[5];
		for (int i = 0; i < 5; i++) {
			JTextField text = (JTextField) units.get(i);
			content[i] = text.getText();
			if(content[i].isEmpty()){
				MyDialog dialog = new MyDialog("incomplete");
				return;
			}
			text.setText("");
		}
		JComboBox box = (JComboBox) units.get(5);
		String type = (String) box.getSelectedItem();
		SalaryVO vo = new SalaryVO(content[0],content[3],Double.parseDouble(content[1]),content[4],content[2],type);
		ResultMessage result = finance.createSalary(vo);
		if(result.isSuccess()){
			MyDialog dialog = new MyDialog("addSuccess");
		}else{
			MyDialog dialog = new MyDialog(result.getErrorMessage(),true);
		}
	}
}
