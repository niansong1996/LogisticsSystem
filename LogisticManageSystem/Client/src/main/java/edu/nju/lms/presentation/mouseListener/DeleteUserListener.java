package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyCheckBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.UserTable;

public class DeleteUserListener extends ButtonListener{
	private UserTable user;
	private UserController userController;
	
	public DeleteUserListener(ArrayList<Component> units,
			UIController controller, Component button) {
		super(units, controller, button);
		user=(UserTable)units.get(0);
		userController=controller.getUserController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ArrayList<MyTableLabel> data=user.getDataList();
		ResultMessage result=null;	
		for(int i=0;i<data.size();i++){
			MyTableLabel label=data.get(i);
			MyCheckBox check = (MyCheckBox) label.getComponent(0);
			if(check.isSelected()){
				JTextField field = (JTextField) label.getComponents(0);
				result=userController.deleteUser(field.getText());
				System.out.println(result.isSuccess()+result.getErrorMessage());
				if(result.isSuccess()){
					user.my_remove(i);
					i--;
				}
			}
		}
		if (result.isSuccess()) {
			new MyDialog("删除成功！", true);
		} else {
			new MyDialog(result.getErrorMessage(), true);
		}
	}

}
