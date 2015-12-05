package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.presentation.UIController;
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
	
	public CommodityAddListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (CommodityTable) units.get(0);
		this.units = units;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MyTextField num = (MyTextField) units.get(2);
		String text = num.getText();
		num.setText("");
		table.addCommodity(text);
	}

}
