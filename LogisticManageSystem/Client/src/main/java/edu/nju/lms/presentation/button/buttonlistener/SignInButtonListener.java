package edu.nju.lms.presentation.button.buttonlistener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.button.MainButton;

/**
 *@author tj
 *@date 2015年11月18日
 */
public class SignInButtonListener extends ButtonListener {
	UserController userController;
	public SignInButtonListener(ArrayList<Component> units, UIController controller, MainButton button) {
		super(units, controller, button);
		userController = controller.getUserController();
	}
	
	public void mouseReleased(MouseEvent e) {
		JTextField n = (JTextField) units.get(1);
		JTextField p = (JTextField)units.get(2);
		String name = n.getText();
		String password = n.getText();
		n.setText("");
		p.setText("");
		controller.createDepartmentController();
		controller.changeTo("ManagerPanel");
		UserVO info = userController.findUserInfo(name);
		if(info==null){
			JOptionPane.showMessageDialog(null, "不存在此用户！");
		}else if(info.getPassword().equals(password)){
			controller.setLogID(name);
			switch(info.getPower()){
				case MANAGER:
					controller.createDepartmentController();
					controller.changeTo("ManagerPanel");break;
				case FINANCIAL_ADVANCED:break;
				case FINANCIAL_NORMAL:break;
				case ADMINISTRATOR:break;
				case COUNTER_INTERMEDIATE:break;
				case COUNTER_BUSSINESS:break;
				case WAREHOUSE:break;
				case COURIER:break;
					
			}
		}else{
			JOptionPane.showMessageDialog(null, "密码错误！");
		}
	}
}
