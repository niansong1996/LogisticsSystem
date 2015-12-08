package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyTextField;

public class CheckCommodityListener extends ButtonListener{
	TransportController transportController;
	
	public CheckCommodityListener(ArrayList<Component> units,UIController controller, Component button) {
		super(units, controller, button);
		transportController=controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MyTextField text = (MyTextField) units.get(0);
		String commodityNum = text.getText();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("temp.lms"));
			bw.write(commodityNum);
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		controller.changeTo("InquireInfoPanel");
	}

}
