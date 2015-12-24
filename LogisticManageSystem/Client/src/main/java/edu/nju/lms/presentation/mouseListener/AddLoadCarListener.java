package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.LoadCarVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;
import edu.nju.lms.presentation.components.table.MyTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * add loadCar list
 * @author cuihao
 *
 */
public class AddLoadCarListener extends ButtonListener{

	public AddLoadCarListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		TransportController transport = controller.getTransportController();
		if(transport==null) {
			return;
		}
		/*
		 * get data
		 */
		MyTable table = (MyTable) units.get(0);
		ArrayList<String> commoditynums = new ArrayList<String>();
		for(MyTableLabel label: table.getDataList()) {
			MyTextField text = (MyTextField) label.getComponents(0);
			String commodity = text.getText();
			commoditynums.add(commodity);
		}
		MyTextField businessHall = (MyTextField) units.get(3);
		String businessHallStr = businessHall.getText();
		MyTextField motorNum = (MyTextField) units.get(4);
		String motorNumStr = motorNum.getText();
		MyTextField destination = (MyTextField) units.get(5);
		String destinationStr = destination.getText();
		MyTextField carNum = (MyTextField) units.get(6);
		String carNumStr = carNum.getText();
		MyTextField driverNum = (MyTextField) units.get(7);
		String driverNumStr = driverNum.getText();
		if(businessHallStr.isEmpty()||motorNumStr.isEmpty()||destinationStr.isEmpty()
				||carNumStr.isEmpty()||driverNumStr.isEmpty()){
			new MyDialog("incomplete", controller);
			return;
		}
		/*
		 * create and save list
		 */
		LoadCarVO vo = new LoadCarVO("", "", businessHallStr, motorNumStr, destinationStr, carNumStr, driverNumStr, commoditynums, 0);
		LoadCarVO loadCarVO = transport.createLoadCarList(vo);
		ResultMessage result = transport.saveLoadCarList(loadCarVO);
		if(result.isSuccess()){
			new MyDialog("addSuccess", controller);
		}else{
			new MyDialog(result.getErrorMessage(), true,controller);
		}
	}

}
