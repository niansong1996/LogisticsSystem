package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 *@author tj
 *@date 2015年12月20日
 */
public class SetTotalRowListener extends ButtonListener {
	private WarehouseController control;
	private JTextField field;
	public SetTotalRowListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getWarehouseController();
		this.field = (JTextField) units.get(28);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(field.getText().isEmpty()){
			new MyDialog("请输入仓库总排数",true);
			return;
		}
		String num = field.getText();
		if(!Numeric.isNumeric(num)){
			new MyDialog("请输入数字",true);
			return;
		}
		ResultMessage result = control.setTotalRowNum(Integer.parseInt(num));
		if(!result.isSuccess()){
			new MyDialog(result.getErrorMessage(),true);
		}
		
	}

}
