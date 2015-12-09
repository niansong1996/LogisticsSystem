package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import edu.nju.lms.VO.SendVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MainButton;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * @author tj
 * @date 2015年12月6日
 */
public class SaveSendListListener extends ButtonListener {
	private TransportController control;

	public SaveSendListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MainButton button = (MainButton) units.get(21);
		MouseListener[] listeners = button.getMouseListeners();
		CreateSendListListener createListener = (CreateSendListListener)listeners[0];
		SendVO vo = createListener.getVo();
		ResultMessage result = control.saveSendList(vo);
		if(result.isSuccess()){
			new MyDialog("addSuccess");
		}else{
			new MyDialog(result.getErrorMessage(),true);
		}
	}
}
