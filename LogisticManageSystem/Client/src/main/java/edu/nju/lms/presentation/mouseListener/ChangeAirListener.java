package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.CircleBase;
import edu.nju.lms.presentation.components.CircleButton;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyLabel;

/**
 * @author tj
 * @date 2015年12月16日
 */
public class ChangeAirListener extends ChangePartitionListener {
	private MyLabel label;
	private MyLabel flexibleLabel;
	public ChangeAirListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		CircleButton b = (CircleButton) button;
		this.label = (MyLabel) units.get(0);
		this.flexibleLabel = (MyLabel) units.get(3);
	}

	public void initialize() {
		button = (CircleButton) units.get(4);
		base = (CircleBase) units.get(7);
		this.flexible = (CircleBase) units.get(10);
		this.name = button.getName();
	}

	@Override
	public boolean change() {
		if (control.getTotalRowNum() != -1) {
			int tranNum = (int) (division * control.getTotalRowNum());
			ResultMessage result = control.setAirRowNum(tranNum);
			double division2 = 1.0*control.getFlexibleRowNum()/control.getTotalRowNum();
			flexible.setArc((int)(division2*360));
			if (!result.isSuccess()) {
				new MyDialog(result.getErrorMessage(), true);
				return false;
			}
			double f1 = division*100;
			BigDecimal b = new BigDecimal(f1);
			f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
			label.setText("航空区："+f1+"%");
			double f2 = division2*100;
			BigDecimal b1 = new BigDecimal(f2);
			f2 = b1.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
			flexibleLabel.setText("机动区："+f2+"%");
		}else{
			new MyDialog("请输入仓库总排数",true);
			return false;
		}
		return true;
	}
}
