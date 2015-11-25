package edu.nju.lms.presentation.components;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicComboBoxUI;
import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

public class MyCombox<T> extends JComboBox<T> {

	private static final long serialVersionUID = 3980256366114323391L;
	Element element;

	public MyCombox(Element element, UIController controller) {
		super();
		this.element = element;
		setOpaque(false);
		if(element!=null){
			int w = Integer.parseInt(element.attributeValue("w"));
			int h = Integer.parseInt(element.attributeValue("h"));
			int x = Integer.parseInt(element.attributeValue("x"));
			int y = Integer.parseInt(element.attributeValue("y"));
			
			setBounds(x, y, w, h);
		}
		setUI(new MyComBoxUI());

		setEditable(false);
		addMyItems();
	}

	public MyCombox() {
		this(null, null);
	}

	@SuppressWarnings("unchecked")
	public void addMyItems() {
		if(element!=null){
			String temp = element.attributeValue("items");
			String[] items = temp.split(";");
			for (int i = 0; i < items.length; i++) {
				addItem((T) items[i]);
			}
		}
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("test");
		frame.setTitle("ScrollBar Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(180, 70);
        frame.setAlwaysOnTop(true);
        MyCombox<String> s = new MyCombox<String>();
        s.addItem("总经理");
        s.addItem("财务人员");
        frame.getContentPane().add(s);
        frame.setVisible(true);
	}

}
