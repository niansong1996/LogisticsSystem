package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.ReceiveVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyLabel;

/**
 *@author tj
 *@date 2015年12月6日
 */
public class SaveReceiveListListener extends ButtonListener {
	private TransportController control;
	public SaveReceiveListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTextField namefield = (JTextField) units.get(7);
		String receiverName = namefield.getText();
		if(receiverName.isEmpty()){
			new MyDialog("incomplete");
			return;
		}
		JTextField field = (JTextField) units.get(3);
		String expressNum = field.getText();
		ReceiveVO vo = new ReceiveVO(null,receiverName,null,expressNum);
		vo = control.createReceiveList(vo);
		ResultMessage result = control.saveReceiveList(vo);
		if(result.isSuccess()){
			new MyDialog("收件成功",true);
			field.setText("");
			namefield.setText("");
			JTextField express = (JTextField) units.get(3);
			express.setText("");
			JTextField contact = (JTextField)units.get(8);
			contact.setText("");
			for(int i =4;i<7;i++){
				MyLabel label = (MyLabel)units.get(i);
				label.setText("");
			}
		}else{
			new MyDialog(result.getErrorMessage(),true);
		}
	}

}
