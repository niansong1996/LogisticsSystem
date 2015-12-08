package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.EnumTransformer;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.UserTable;

public class SaveUserListener extends ButtonListener{
	private UserTable table;

	public SaveUserListener(ArrayList<Component> units,UIController controller, Component button) {
		super(units, controller, button);
		table = (UserTable) units.get(0);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		UserController userController=controller.getUserController();
		if(userController==null){
			System.out.println("userController is null!");
			return;
		}
		ArrayList<MyTableLabel> labels=table.getDataList();
		ResultMessage result=null;
		for(int i=0; i<labels.size();i++){
			MyTableLabel label=labels.get(i);
			
		}
loop:	for(int i=0;i<labels.size();i++){
			MyTableLabel label = labels.get(i);
			String[] info=new String[3];
			for(int j=0;j<3;j++){
				if(j==2)
					continue;
				JTextField f = (JTextField) label.getComponents(j);
				if (!f.isEditable())
					continue loop;
				info[j] = f.getText();
			}
			MyComboBox<String> power = (MyComboBox<String>) label.getComponents(2);
			info[2]=power.getSelectedItem().toString();
			UserVO user=new UserVO(info[0],info[1],EnumTransformer.str2PersonType(info[2]));
			result=userController.updateUser(user);
		}
		if (result.isSuccess()) {
			MyDialog dialog = new MyDialog("保存成功！", true);
		} else {
			MyDialog dialog = new MyDialog(result.getErrorMessage(), true);
		}
	}

}
