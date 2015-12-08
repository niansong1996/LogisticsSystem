package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.UserTable;

public class FindUserListener extends ButtonListener{
	
	UserTable table;
	UserController userController;

	public FindUserListener(ArrayList<Component> units,UIController controller, Component button) {
		super(units, controller, button);
		table = (UserTable) units.get(0);
		userController=controller.getUserController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MyTextField id=(MyTextField)units.get(1);
		UserVO user=userController.findUserInfo(id.getText());
		id.setText("");
		if(user==null){
			new MyDialog("notExist");
			return;
		}
		ArrayList<MyTableLabel> labels=new ArrayList<MyTableLabel>(1);
		MyTableLabel label=table.createLabel(user);
		labels.add(label);
		table.setDataList(labels);
	}

}
