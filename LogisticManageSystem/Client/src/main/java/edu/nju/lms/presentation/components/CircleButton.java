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
	public CircleButton(Element button, UIController controller) {
		super(button, controller);
		control = controller.getWarehouseController();
		name = button.attributeValue("belong");
		setInitialLoc();
		setBounds(x, y, w, h);
		this.ui = controller;
	}

	public void setInitialLoc() {
		// PartitionType type = PartitionType.valueOf(name);
		// String warehouseNum = control.getCurrentWarehouseNum();
		// PartitionVO vo = control.showPartition(warehouseNum);
		// if(vo==null){
		// return;
		// }
		// ArrayList<Partition>lists = vo.getPartitionInfor();
		// Partition p = null;
		// // 在返回的list里找到属于当前分区类型的partition对象
		// for (int i = 0; i < 4; i++) {
		// p = lists.get(i);
		// if (p.getType().equals(type)) {
		// break;
		// }
		// }
		// if (p != null) {
		// double division = p.getCapacity() / control.getTotalRowNum();
		// x+= (int)Math.sin(2*division*Math.PI);
		// y+= (int)Math.cos(2*division*Math.PI);
		// }
		double division = 0.4;
		x-=5;
		int d_x = 100-(int) (Math.sin(2 * division * Math.PI) * 100);
		int d_y = 100-(int) (Math.cos(2 * division * Math.PI) * 100);
		x+=d_x;
		y+=d_y;
		if(division>=0.25&&division<=0.5){
			y-=10;
		}else if(division>=0.5&&division<=0.75){
			x-=10;
			y-=10;
		}else if(division>=0.75&&division<=1){
			x-=10;
		}
	}
	public void setLoc(int d_x,int d_y){
		d_x-=10;
		d_y-=10;
		x+=d_x;
		y+=d_y;
		setBounds(x,y,w,h);
		ui.getFrame().repaint();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
