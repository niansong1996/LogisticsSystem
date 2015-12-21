package edu.nju.lms.presentation.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.dom4j.Element;

import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.presentation.UIController.UIController;

/**
 * @author tj
 * @date 2015年12月16日
 */
public class CircleBase extends JLabel {
	private static final long serialVersionUID = 543076666126749793L;
	private int x;
	private int y;
	private int h;
	private int w;
	private int arc;
	private String name;
	private WarehouseController control;
	private String isInit;

	public CircleBase(Element element, UIController controller) {
		this.control = controller.getWarehouseController();
		this.isInit = element.attributeValue("isInit");
		w = Integer.parseInt(element.attributeValue("w"));
		h = Integer.parseInt(element.attributeValue("h"));
		x = Integer.parseInt(element.attributeValue("x"));
		y = Integer.parseInt(element.attributeValue("y"));
		name = element.attributeValue("name");
		setBounds(x, y, w, h);
		initializeArc();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
		g2d.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
		g2d.setStroke(new BasicStroke(10));
		g2d.drawArc(5, 5, getWidth() - 10, getHeight() - 10, 90, arc);
	}

	public void initializeArc() {
		double division = 0;
		int num = 0;
		if (isInit.equals("false")) {
			if (name.equals("AIRPLANE")) {
				num = control.getAirRowNum();
			} else if (name.equals("TRAIN")) {
				num = control.getTrainRowNum();
			} else if (name.equals("CAR")) {
				num = control.getCarRowNum();
			} else if (name.equals("FLEXIBLE")) {
				num = control.getFlexibleRowNum();
			}
		} else {
			if(name.equals("FLEXIBLE")){
				num = control.getFlexibleRowNum();
			}
		}
		division = 1.0*num / control.getTotalRowNum();
		setArc((int) (division * 360));
	}

	public void setArc(int arc) {
		this.arc = arc;
		this.repaint();
	}

	public String getName() {
		return name;
	}

	public int getCircleX() {
		return x + 100;
	}

	public int getCircleY() {
		return y + 100;
	}

	public int getArc() {
		return arc;
	}

}
