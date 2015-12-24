package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;
import edu.nju.lms.presentation.components.table.CommodityTable;

/**
 * Add a commodity to commodityTable
 * @author cuihao
 *
 */
public class CommodityAddListener extends ButtonListener{

	CommodityTable table;
	ArrayList<Component> units;
	TransportController t=null;
	
	public CommodityAddListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (CommodityTable) units.get(0);
		this.units = units;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		t=controller.getTransportController();
		MyTextField num = (MyTextField) units.get(2);
		String text = num.getText();
		if(text.isEmpty()){
			new MyDialog("incomplete",controller);
			return;
		}
		num.setText("");
		if(t.findSendList(text)==null){
			new MyDialog("未找到该订单",true,controller);
		}else{
			table.addCommodity(text);
		}
		
	}

}
