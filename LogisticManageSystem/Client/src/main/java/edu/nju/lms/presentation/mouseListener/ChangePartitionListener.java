package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.CircleBase;
import edu.nju.lms.presentation.components.CircleButton;

/**
 * @author tj
 * @date 2015年12月17日
 */
public abstract class ChangePartitionListener extends ButtonListener implements MouseMotionListener {
	protected WarehouseController control;
	protected CircleButton button;
	protected CircleBase base;
	protected String name;
	protected double division;
	protected CircleBase flexible;
	public ChangePartitionListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		button.addMouseMotionListener(this);
		this.control = controller.getWarehouseController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		initialize();
		int x = e.getX() + button.getX();
		int y = e.getY() + button.getY();
		int c_x = base.getCircleX();
		int c_y = base.getCircleY();
		double distance = Math.sqrt(Math.pow(x - c_x, 2) + Math.pow(y - c_y, 2));
		double mysin = (y - c_y) / distance;
		double mycos = (x - c_x) / distance;
		// 左上
		if (x - c_x < 0 && y - c_y < 0) {
			base.setArc(-(int) (Math.asin(mycos) / (2 * Math.PI) * 360));
			button.setLocation((int) (c_x + mycos * 100 - 10), (int) (c_y + mysin * 100 - 10));
			// 左下
		} else if (x - c_x <= 0 && y - c_y >= 0) {
			base.setArc((int) (Math.asin(mysin) / (2 * Math.PI) * 360) + 90);
			button.setLocation((int) (c_x + mycos * 100 - 10), (int) (c_y + mysin * 100 - 15));
			// 右上
		} else if (x - c_x >= 0 && y - c_y <= 0) {
			base.setArc(-(int) (Math.asin(mysin) / (2 * Math.PI) * 360) + 270);
			button.setLocation((int) (c_x + mycos * 100 - 15), (int) (c_y + mysin * 100 - 15));
			// 右下
		} else if (x - c_x >= 0 && y - c_y >= 0) {
			base.setArc((int) (Math.asin(mycos) / (2 * Math.PI) * 360) + 180);
			button.setLocation((int) (c_x + mycos * 100 - 15), (int) (c_y + mysin * 100 - 10));
		}
		this.division = base.getArc()/360.0;
		
		change();

	}

	public void mouseMoved(MouseEvent e) {
	}

	public abstract void initialize();

	/**
	 *  调用逻辑层方法
	 */
	public abstract void change();
}
