package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.InventoryExcelVO;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MainButton;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;

/**
 *@author tj
 *@date 2015年12月7日
 */
public class ExportWareExcelListener extends ButtonListener {

	WarehouseController warehouse;
	InventoryExcelVO excelVO = null;
	
	public ExportWareExcelListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		warehouse = controller.getWarehouseController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MainButton button = (MainButton) units.get(7);
		MyTextField wareNum = (MyTextField) units.get(3);
		SearchWareCheckListener listener = (SearchWareCheckListener) button.getMouseListeners()[0];
		InventoryExcelVO excelvo = listener.getInventoryVO();
		if(excelvo!=null) {
			ResultMessage result = warehouse.exportExcel(excelvo, wareNum.getText());
			if(result.isSuccess()) {
				new MyDialog("导出成功",true);
			}else{
				new MyDialog(result.getErrorMessage(),true);
			}
		}
	}

}
