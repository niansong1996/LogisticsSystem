package edu.nju.lms.presentation.components;

import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import org.dom4j.Element;

import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.mouseListener.ChangeAirListener;

/**
 * @author tj
 * @date 2015年12月16日
 */
public class CircleButton extends MainButton {
	private static final long serialVersionUID = 440604333686058781L;
	private WarehouseController control;
	private String name;
	private UIController ui;
	private double division;
	private String isInit;

	public CircleButton(Element button, UIController controller) {
		super(button, controller);
		this.control = controller.getWarehouseController();
		this.name = button.attributeValue("belong");
		this.isInit = button.attributeValue("isInit");
		setInitialLoc();
		setBounds(x, y, w, h);
		this.ui = controller;
	}

	public void setInitialLoc() {
		if (isInit.equals("true")) {
			division = 0;
		} else {
			int num = 0;
			if (name.equals("AIRPLANE")) {
				num = control.getAirRowNum();
			} else if (name.equals("TRAIN")) {
				num = control.getTrainRowNum();
			} else if (name.equals("CAR")) {
				num = control.getCarRowNum();
			} else if (name.equals("FLEXIBLE")) {
				num = control.getFlexibleRowNum();
			}
			division = num / control.getTotalRowNum();
		}
		x-=7;
		int d_x = 100 - (int) (Math.sin(2 * division * Math.PI) * 100);
		int d_y = 100 - (int) (Math.cos(2 * division * Math.PI) * 100);
		x += d_x;
		y += d_y;
		if (division >= 0.25 && division <= 0.5) {
			y -= 10;
		} else if (division >= 0.5 && division <= 0.75) {
			x -= 10;
			y -= 10;
		} else if (division >= 0.75 && division <= 1) {
			x -= 10;
		}
	}

	public void setLoc(int d_x, int d_y) {
		d_x -= 10;
		d_y -= 10;
		x += d_x;
		y += d_y;
		setBounds(x, y, w, h);
		ui.getFrame().repaint();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDivision() {
		return this.division;
	}

	public String getIsInit() {
		return isInit;
	}

	public void setDivision(double division) {
		this.division = division;
	}
	
}
