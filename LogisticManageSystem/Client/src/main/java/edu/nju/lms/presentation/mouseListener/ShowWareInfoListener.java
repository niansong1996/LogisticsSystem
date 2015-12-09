package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.WarehouseInfoVO;
import edu.nju.lms.VO.WarehouseVO;
import edu.nju.lms.businessLogicService.WareHouseblService;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.DateChooser;

/**
 * @author tj
 * @date 2015年12月8日
 */
public class ShowWareInfoListener extends ButtonListener {
	private WareHouseblService control;

	public ShowWareInfoListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getWarehouseController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		DateChooser c = (DateChooser) units.get(4);
		start.setTime(c.getDate());
		DateChooser d = (DateChooser) units.get(5);
		end.setTime(d.getDate());
		JTextField field = (JTextField) units.get(3);
		if (field.getText().isEmpty()) {
			return;
		}
		WarehouseInfoVO vo = control.showWarehouseInfo(start, end, field.getText());
		// show information
		JLabel label = (JLabel) units.get(0);
		label.setText(vo.getCheckinNum() + "");
		JLabel out = (JLabel)units.get(1);
		out.setText(vo.getCheckoutNum()+"");
		JLabel all = (JLabel)units.get(2);
		all.setText(vo.getTotalNum()+"");
	}
}