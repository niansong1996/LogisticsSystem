package edu.nju.lms.presentation.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

public class MyCombox<T> extends JComboBox<T> {
	Element element;

	public MyCombox(Element element, UIController controller) {
		super();
		this.element = element;
		setOpaque(false);
		int w = Integer.parseInt(element.attributeValue("w"));
		int h = Integer.parseInt(element.attributeValue("h"));
		int x = Integer.parseInt(element.attributeValue("x"));
		int y = Integer.parseInt(element.attributeValue("y"));
		setBounds(x, y, w, h);
		 setUI(new BasicComboBoxUI(){
		 public void installUI(JComponent comboBox) {
		 super.installUI(comboBox);
		 listBox.setForeground(Color.WHITE);
		 listBox.setSelectionBackground(new Color(0,0,0,0));
		 listBox.setSelectionForeground(Color.BLACK);
		 }
		
		 protected JButton createArrowButton() {
		 return super.createArrowButton();
		 }
		 });

		setEditable(false);
		addMyItems();
	}

	public MyCombox() {
		this(null, null);
	}

	public void addMyItems() {
		String temp = element.attributeValue("items");
		String[] items = temp.split(";");
		for (int i = 0; i < items.length; i++) {
			addItem((T) items[i]);
		}
	}
	

}
