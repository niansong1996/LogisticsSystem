package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.CircleBase;
import edu.nju.lms.presentation.components.CircleButton;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * @author tj
 * @date 2015年12月17日
 */
public class ChangeTrainListener extends ChangePartitionListener {

	public ChangeTrainListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}

	@Override
	public void initialize() {
		button = (CircleButton) units.get(5);
		base = (CircleBase) units.get(8);
		this.flexible = (CircleBase) units.get(10);
		this.name = button.getName();
	}

	@Override
	public void change() {
		if (control.getTotalRowNum() != -1) {
			int tranNum = (int) (division * control.getTotalRowNum());
			ResultMessage result = control.setTrainRowNum(tranNum);
			double division2 = 1.0*control.getFlexibleRowNum()/control.getTotalRowNum();
			flexible.setArc((int)(division2*360));
			if (!result.isSuccess()) {
				new MyDialog(result.getErrorMessage(), true);
			}
		} else {
			new MyDialog("请输入仓库总排数", true);
		}
	}

}
