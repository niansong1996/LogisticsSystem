package edu.nju.lms.presentation.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import org.dom4j.Element;

import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 * 
 * @author cuihao
 *
 */
public class WarningBar extends JLabel{
	
	private static final long serialVersionUID = -5529274290876539754L;

	protected int x;
	protected int y;
	protected int h;
	protected int w;
	private String name;
	protected Element element;
	private WarehouseController warehouse;
	
	public WarningBar(Element element, UIController controller) {
		w = Integer.parseInt(element.attributeValue("w"));
		h = Integer.parseInt(element.attributeValue("h"));
		x = Integer.parseInt(element.attributeValue("x"));
		y = Integer.parseInt(element.attributeValue("y"));
		name =element.attributeValue("name");
		this.element = element;
		warehouse = controller.getWarehouseController();
		setBounds(x, y, w, h);
		initialize();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRoundRect(0, h/3, w, h/3, h/3, h/3);
	}
	
	private void initialize(){
		
	}
}
