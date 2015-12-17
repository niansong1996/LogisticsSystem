package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.CircleBase;
import edu.nju.lms.presentation.components.CircleButton;

/**
 * @author tj
 * @date 2015年12月16日
 */
public class ChangeAirListener extends ChangePartitionListener {

	public ChangeAirListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}

	public void initialize() {
		button = (CircleButton) units.get(4);
		base = (CircleBase) units.get(7);
		this.name = button.getName();
	}

	// 调用逻辑层方法
	public void change() {
		// TODO

	}
}
