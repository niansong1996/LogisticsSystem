package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * Add a person to database
 *@author tj
 *@date 2015年11月22日
 */
public class AddPersonConfirmListener extends ButtonListener {

	public AddPersonConfirmListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}
	public void mouseReleased(MouseEvent e) {
		/*
		 * get and check data
		 */
		String[] info = new String[6];
		for(int i = 0;i<6;i++){
			JTextField text=(JTextField)units.get(i);
			info[i]=text.getText();
			if(info[i].isEmpty()){
				new MyDialog("incomplete");
				return;
			}
		}
		JComboBox<?> box = (JComboBox<?>)units.get(6);
		String duty = (String) box.getSelectedItem();

		/*
		 * save data
		 */
		PersonnelVO person = new PersonnelVO(info[0],info[1],info[2],duty,(Double.parseDouble(info[3])),
				(Double.parseDouble(info[4])),(Double.parseDouble(info[5])));
		PersonnelController personControl = controller.getPersonnelController();
		if(personControl!=null){
		ResultMessage result = personControl.addPersonnel(person);
			if(result.isSuccess()){
				for(int i = 0;i<6;i++){
					JTextField text=(JTextField)units.get(i);
					text.setText("");
				}
				new MyDialog("addSuccess");
			}else{
				new MyDialog(result.getErrorMessage(),true);
			}
		}
	}
}
