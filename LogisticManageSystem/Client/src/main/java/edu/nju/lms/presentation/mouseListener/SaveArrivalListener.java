package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ArrivalState;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyTextField;
import edu.nju.lms.presentation.components.table.CommodityTable;

public class SaveArrivalListener extends ButtonListener{

	TransportController transport;
	ArrivalState state[] = {ArrivalState.COMPLETE,ArrivalState.BROKEN,ArrivalState.MISSING};
	
	public SaveArrivalListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		transport = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		CommodityTable table = (CommodityTable) units.get(0);
		MyComboBox stateBox = (MyComboBox) units.get(4);
		MyComboBox setOutBox = (MyComboBox) units.get(5);
		MyTextField courierNum = (MyTextField) units.get(1);
	}

}
