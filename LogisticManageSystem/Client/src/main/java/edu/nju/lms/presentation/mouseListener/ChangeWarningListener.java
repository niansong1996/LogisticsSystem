package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 *@author tj
 *@date 2015年12月8日
 */
public class ChangeWarningListener extends ButtonListener {
	private WarehouseController control;
	public ChangeWarningListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getWarehouseController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTextField field = (JTextField) units.get(0);
		String warehouseNum = field.getText();
		JTextField f = (JTextField)units.get(1);
		String warning = f.getText();
		if(!Numeric.isNumeric(warning)){
			new MyDialog("信息格式错误",true);
		}
		ResultMessage result = control.setCordon(Double.parseDouble(warning), warehouseNum);
		if(result.isSuccess()){
			new MyDialog("修改成功",true);
		}else{
			new MyDialog(result.getErrorMessage(),true);
		}
	}

}
