package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.CircleBase;
import edu.nju.lms.presentation.components.CircleButton;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * @author tj
 * @date 2015年12月16日
 */
public class ChangeAirListener extends ChangePartitionListener {

	public ChangeAirListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		CircleButton b = (CircleButton) button;
	}

	public void initialize() {
		button = (CircleButton) units.get(4);
		base = (CircleBase) units.get(7);
		this.flexible = (CircleBase) units.get(10);
		this.name = button.getName();
	}

	@Override
	public void change() {
		if (control.getTotalRowNum() != -1) {
			int tranNum = (int) (division * control.getTotalRowNum());
			ResultMessage result = control.setAirRowNum(tranNum);
			double division2 = 1.0*control.getFlexibleRowNum()/control.getTotalRowNum();
			flexible.setArc((int)(division2*360));
			if (!result.isSuccess()) {
				new MyDialog(result.getErrorMessage(), true);
			}
		}else{
			new MyDialog("请输入仓库总排数",true);
		}
	}
}
