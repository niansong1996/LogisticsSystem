package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MainButton;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * @author tj
 * @date 2015年11月18日
 */
public class SignInButtonListener extends ButtonListener {
	UserController userController;

	public SignInButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		userController = controller.getUserController();
	}

	public void mouseReleased(MouseEvent e) {
		controller.changeTo("warehousePanel");
//		JTextField n = (JTextField) units.get(1);
//		JTextField p = (JTextField) units.get(2);
//		String name = n.getText();
//		String password = p.getText();
//		if(name.isEmpty()||password.isEmpty()){
//			return;
//		}
//		n.setText("");
//		p.setText("");
//		UserVO info = userController.findUserInfo(name);
//		if (info.getUserName() == null) {
//			MyDialog error = new MyDialog("notExist");
//		} else if (info.getPassword().equals(password)) {
//			controller.setLogID(name);
//			switch (info.getPower()) {
//			case MANAGER:
//				controller.changeTo("ManagerPanel");
//				break;
//			case FINANCIAL_ADVANCED:
//				controller.changeTo("FinancialAdvancedPanel");
//				break;
//			case FINANCIAL_NORMAL:
//				controller.changeTo("FinancialCommonPanel");
//				break;
//			case ADMINISTRATOR:
//				controller.changeTo("AdministratorPanel");
//				break;
//			case COUNTER_INTERMEDIATE:
//				controller.changeTo("counterInterPanel");
//				break;
//			case COUNTER_BUSSINESS:
//				controller.changeTo("counterBussinessPanel");
//				break;
//			case WAREHOUSE:
//				controller.changeTo("warehousePanel");
//				break;
//			case COURIER:
//				controller.changeTo("courierPanel");
//				break;
//
//			}
//		} else {
//			MyDialog error = new MyDialog("passwordError");
//		}
	}
}
