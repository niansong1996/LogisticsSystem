package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;

import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.VO.WarehouseInfoVO;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.DateChooser;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;
import edu.nju.lms.presentation.components.table.WarehouseStoreTable;

/**
 * search warehouse checkInfo
 * @author cuihao
 * @date 2015-12-08 18:37:38
 */
public class SearchWareCheckListener extends ButtonListener{

	private WarehouseController warehouse;
	private InventoryExcelVO inventory;
	
	public SearchWareCheckListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		warehouse = controller.getWarehouseController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		WarehouseStoreTable table = (WarehouseStoreTable) units.get(2);
		DateChooser start = (DateChooser) units.get(0);
		DateChooser end = (DateChooser) units.get(0);
		Calendar startDate = start.getCalendar();
		Calendar endDate = end.getCalendar();
		MyTextField wareNum = (MyTextField) units.get(3);
		if(wareNum.getText().isEmpty()){
			new MyDialog("incomplete", controller);
			return;
		}
		inventory = warehouse.checkWarehouseInfor(startDate, endDate, wareNum.getText());
		if(inventory!=null) {
			table.setDataList(table.createLabels(inventory));
		}
		WarehouseInfoVO vo = warehouse.showWarehouseInfo(startDate, endDate, wareNum.getText());
		// show information
		JLabel label = (JLabel) units.get(4);
		label.setText(vo.getCheckinNum() + "");
		JLabel out = (JLabel)units.get(5);
		out.setText(vo.getCheckoutNum()+"");
		JLabel all = (JLabel)units.get(6);
		all.setText(vo.getTotalNum()+"");
	}
	
	public InventoryExcelVO getInventoryVO(){
		return inventory;
	}

}
