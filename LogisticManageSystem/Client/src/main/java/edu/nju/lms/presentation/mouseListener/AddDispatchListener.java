package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * Add dispatch list
 * @author cuihao
 * @date 2015-12-06 15:06:49
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
		if(person.getText().isEmpty()||commodity.getText().isEmpty()){
			new MyDialog("incomplete");
			return;
		}
		DispatchVO vo = new DispatchVO("", person.getText(), "", commodity.getText());
		/*
		 * firstly, complete dispatch list
		 */
		DispatchVO dispatch = transport.createDispatchList(vo);
		/*
		 * save list
		 */
		ResultMessage result = transport.saveDispatchList(dispatch);
		if(result.isSuccess()) {
			new MyDialog("addSuccess");
		}else{
			new MyDialog(result.getErrorMessage(), true);
		}
	}

}
