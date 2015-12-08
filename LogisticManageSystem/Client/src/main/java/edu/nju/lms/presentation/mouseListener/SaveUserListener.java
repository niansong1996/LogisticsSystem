package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
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

//		ArrayList<MyTableLabel> labels = table.getDataList();
//		ResultMessage result = null;
//		loop: for (int i = 0; i < labels.size(); i++) {
//			MyTableLabel label = labels.get(i);
//			String[] info = new String[8];
//			for (int j = 0; j < 8; j++) {
//				if (j == 5)
//					continue;
//				JTextField f = (JTextField) label.getComponents(j);
//				if (!f.isEditable())
//					continue loop;
//				info[j] = f.getText();
//			}
//			@SuppressWarnings("unchecked")
//			MyComboBox<String> sex = (MyComboBox<String>) label.getComponents(5);
//			if (sex.getSelectedItem().equals("男")) {
//				info[5] = "0";
//			} else {
//				info[5] = "1";
//			}
//			DriverVO driver = new DriverVO(info[0], info[1], info[2], info[3], info[4], Integer.parseInt(info[5]),
//					info[6], info[7]);
//			result = transport.updateDriver(driver);
//		if (result.isSuccess()) {
//			MyDialog dialog = new MyDialog("保存成功！", true);
//		} else {
//			MyDialog dialog = new MyDialog(result.getErrorMessage(), true);
//		}
	}

}
