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
		JTextField n = (JTextField) units.get(1);
		JTextField p = (JTextField) units.get(2);
		String name = "";
		name = n.getText();
		String password = "";
		password = p.getText();
		n.setText("");
		p.setText("");
		controller.changeTo("ManagerPanel");
		controller.initialize(PersonType.COURIER);
//		if (name != "" && password != "") {
//			if(userController==null){
//				return;
//			}
//			UserVO info = userController.findUserInfo(name);
//			System.out.println("password"+info.getPassword());
//			System.out.println(password);
//			if (info.getUserName() == null) {
//				MyDialog error = new MyDialog("notExist");
//			} else if (info.getPassword().equals(password)) {
//				controller.setLogID(name);
//				controller.initialize(info.getPower());
//				switch (info.getPower()) {
//				case MANAGER:
//					controller.changeTo("ManagerPanel");
//					break;
//				case FINANCIAL_ADVANCED:
//					break;
//				case FINANCIAL_NORMAL:
//					break;
//				case ADMINISTRATOR:
//					break;
//				case COUNTER_INTERMEDIATE:
//					break;
//				case COUNTER_BUSSINESS:
//					break;
//				case WAREHOUSE:
//					break;
//				case COURIER:
//					break;
//
//				}
//			} else {
//				MyDialog error = new MyDialog("passwordError");
//			}
//		}
	}
}
