package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.ReceiveVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController;

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
		JTextField field = (JTextField) units.get(7);
		String receiverName = field.getText();
		field = (JTextField) units.get(3);
		String expressNum = field.getText();
		ReceiveVO vo = new ReceiveVO(null,receiverName,null,expressNum);
		control.createReceiveList(vo);
	}

}
