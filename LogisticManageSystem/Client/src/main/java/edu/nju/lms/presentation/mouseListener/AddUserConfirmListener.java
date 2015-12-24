package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.EnumTransformer;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * Add a user of the system
 * @author oppalu
 * @date 2015-12-09 15:19:24
 */
public class AddUserConfirmListener extends ButtonListener{

	public AddUserConfirmListener(ArrayList<Component> units,UIController controller, Component button) {
		super(units, controller, button);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTextField nam=(JTextField) units.get(0);
		String name=nam.getText();
		JTextField pass=(JTextField) units.get(1);
		String password=pass.getText();
		if (name.isEmpty() || password.isEmpty()) {
			new MyDialog("incomplete",controller);
			return;
		}
		JComboBox<?> box = (JComboBox<?>) units.get(2);
		String t = (String) box.getSelectedItem();
		PersonType type = EnumTransformer.str2PersonType(t);
		
		UserVO user=new UserVO(name,password,type);
		UserController userController=controller.getUserController();
		
		if(userController!=null){
			ResultMessage result =userController.addUser(user);
			if(result.isSuccess()){
				nam.setText("");
				pass.setText("");
				new MyDialog("addSuccess",controller);
			}else{
				new MyDialog(result.getErrorMessage(),true,controller);
			}
		}
	}

}
