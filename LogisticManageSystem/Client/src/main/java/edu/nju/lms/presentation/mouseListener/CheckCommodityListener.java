package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController;

public class CheckCommodityListener extends ButtonListener{
	TransportController transportController;
	
	public CheckCommodityListener(ArrayList<Component> units,UIController controller, Component button) {
		super(units, controller, button);
		transportController=controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		controller.changeTo("InquireInfoPanel");
	}

}
