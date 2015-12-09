package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.SendVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyLabel;

/**
 *@author tj
 *@date 2015年12月6日
 */
public class SearchSendListListener extends ButtonListener {
	private TransportController control;
	private JTextField field;
	public SearchSendListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getTransportController();
		this.field = (JTextField) units.get(3);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String expressNum = field.getText();
		if(expressNum.isEmpty()){
			return;
		}
		SendVO vo = control.findSendList(expressNum);
		if(vo==null){
			new MyDialog("查找不到对应单据！",true);
			return;
		}
		ArrayList<String> baseInfo = vo.getBaseInfor();
		for(int i =0;i<3;i++){
			String str = baseInfo.get(i);
			MyLabel label = (MyLabel) units.get(i+5);
			label.setText(str);
		}	
	}

}
