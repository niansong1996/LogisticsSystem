package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * 
 * @author cuihao
 *
 */
public class AddDispatchListener extends ButtonListener{

	public AddDispatchListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		TransportController transport = controller.getTransportController();
		if(transport==null) return;
		MyTextField person = (MyTextField) units.get(1);
		MyTextField commodity = (MyTextField) units.get(2);
		DispatchVO vo = new DispatchVO("", person.getText(), "", commodity.getText());
		DispatchVO dispatch = transport.createDispatchList(vo);
		ResultMessage result = transport.saveDispatchList(dispatch);
		if(result.isSuccess()) {
			new MyDialog("addSuccess");
		}else{
			new MyDialog(result.getErrorMessage(), true);
		}
	}

}
