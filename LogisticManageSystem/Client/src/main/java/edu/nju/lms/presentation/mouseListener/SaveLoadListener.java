package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.LoadType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;
import edu.nju.lms.presentation.components.table.CommodityTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * save load list
 * @author cuihao
 * @date 2015-12-07 12:57:17
 */
public class SaveLoadListener extends ButtonListener{

	TransportController transport;
	LoadType type[] = {LoadType.AIRPLANE,LoadType.TRAIN,LoadType.CAR};
	String city[] = {"北京","南京","上海","广州"};
	public SaveLoadListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		transport = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (transport == null)
			return;
		MyComboBox<?> loadtypeBox = (MyComboBox<?>) units.get(10);
		MyTextField businesshallNum = (MyTextField) units.get(4);
		MyTextField motorNUm = (MyTextField) units.get(3);
		MyComboBox<?> desticity = (MyComboBox<?>) units.get(8);
		MyTextField destibusiness = (MyTextField) units.get(5);
		MyTextField person = (MyTextField) units.get(6);
		MyTextField vehicle = (MyTextField) units.get(7);
		if(businesshallNum.getText().isEmpty()||motorNUm.getText().isEmpty()
				||destibusiness.getText().isEmpty()||person.getText().isEmpty()
				||vehicle.getText().isEmpty()){
			new MyDialog("incomplete", controller);
			return;
		}
		CommodityTable table = (CommodityTable) units.get(0);
		ArrayList<String> express = new ArrayList<String>();
		for (MyTableLabel label : table.getDataList()) {
			MyTextField commodity = (MyTextField) label.getComponents(0);
			express.add(commodity.getText());
		}
		LoadVO load = new LoadVO("", type[loadtypeBox.getSelectedIndex()], "", businesshallNum.getText(),
				motorNUm.getText(), city[desticity.getSelectedIndex()], destibusiness.getText(), vehicle.getText(),
				person.getText(), express, 0);
		LoadVO finalLoad = transport.createLoadList(load);
		ResultMessage result = transport.saveLoadList(finalLoad);
		if(result.isSuccess()) {
			new MyDialog("addSuccess", controller);
		}else{
			new MyDialog(result.getErrorMessage(),true,controller);
		}
	}

}
