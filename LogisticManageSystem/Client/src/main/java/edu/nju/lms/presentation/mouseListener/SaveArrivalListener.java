package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ArrivalState;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;
import edu.nju.lms.presentation.components.table.CommodityTable;

public class SaveArrivalListener extends ButtonListener{

	TransportController transport;
	ArrivalState state[] = {ArrivalState.COMPLETE,ArrivalState.BROKEN,ArrivalState.MISSING};
	String city[] = {"北京","南京","广州","上海"};
	
	public SaveArrivalListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		transport = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(transport==null) return;
		MyComboBox stateBox = (MyComboBox) units.get(3);
		MyComboBox setOutBox = (MyComboBox) units.get(4);
		MyTextField courierNum = (MyTextField) units.get(0);
		MyTextField commodityNum = (MyTextField) units.get(1);
		MyComboBox destination = (MyComboBox) units.get(5);
		ArrivalVO arrival = new ArrivalVO("", state[stateBox.getSelectedIndex()], commodityNum.getText(),city[destination.getSelectedIndex()] , city[setOutBox.getSelectedIndex()],"",courierNum.getText());
		ArrivalVO finalArrival = transport.createArrivalList(arrival);
		ResultMessage result = transport.saveArrivalList(finalArrival);
		if (result.isSuccess()) {
			new MyDialog("addSuccess");
		} else {
			new MyDialog(result.getErrorMessage(), true);
		}
	}

}
