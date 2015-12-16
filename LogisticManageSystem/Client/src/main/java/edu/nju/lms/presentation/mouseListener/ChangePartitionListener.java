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
 * @date 2015年12月16日
 */
public class ChangePartitionListener extends ButtonListener implements MouseMotionListener {
	private WarehouseController control;
	private CircleButton button;
	private CircleBase base;
	private int oldX, oldY;

	public ChangePartitionListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		button.addMouseMotionListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		button = (CircleButton) units.get(0);
		base = (CircleBase) units.get(1);
		oldX = e.getX();
		oldY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// //判断鼠标是不是在圆上运动
		// int x = e.getX()+button.getX();
		// int y = e.getY()+button.getY();
		// int c_x = base.getCircleX();
		// int c_y = base.getCircleY();
		// double distance = Math.pow(x-c_x, 2)+Math.pow(y-c_y, 2);
		// System.out.println(distance);
		// if(Math.abs(distance-10000)<1000){
		// button.setLoc(e.getX(),e.getY());
		// }
	}

	public void mouseDragged(MouseEvent e) {
		button = (CircleButton) units.get(0);
		base = (CircleBase) units.get(1);
	    int x = e.getX()+button.getX();
		int y = e.getY()+button.getY();
		int c_x = base.getCircleX();
		int c_y = base.getCircleY();
		double distance = Math.sqrt(Math.pow(x-c_x, 2)+Math.pow(y-c_y, 2));
		double mysin = (y-c_y)/distance;
		double mycos = (x-c_x)/distance;
		//左上
		if(e.getX()<0&&e.getY()<0){
			base.setArc((int)(Math.asin(mysin)/(2*Math.PI)*360));
			button.setLocation((int)(c_x+mycos*100-10),(int)(c_y+mysin*100-10));
		//左下
		}else if(e.getX()<=0&&e.getY()>=0){
			base.setArc(-(int)(Math.asin(mysin)/(2*Math.PI)*360)+90);
			button.setLocation((int)(c_x+mycos*100-10),(int)(c_y+mysin*100-13));
		//右下
		}else if(e.getX()>=0&&e.getY()<=0){
			base.setArc(-(int)(Math.asin(mysin)/(2*Math.PI)*360)+180);
			button.setLocation((int)(c_x+mycos*100-13),(int)(c_y+mysin*100-13));
		//右上
		}else if(e.getX()>=0&&e.getY()>=0){
			base.setArc((int)(Math.asin(mysin)/(2*Math.PI)*360)+270);
			button.setLocation((int)(c_x+mycos*100-13),(int)(c_y+mysin*100-10));
		}
	}

	public void mouseMoved(MouseEvent e) {
	}

}
