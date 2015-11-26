package edu.nju.lms.presentation.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import org.dom4j.Element;

public class MyTableLabel extends JLabel implements MouseListener{

	private static final long serialVersionUID = 420418378988671847L;
	
	private int width;
	private int height;
	private java.awt.Component[] components;

	public MyTableLabel(Element element, int height, java.awt.Component[] components) {
		setLayout(null);
		width = Integer.parseInt(element.attributeValue("w"));
		this.height = height;
		this.components = components;
		initializeComponents();
		setPreferredSize(new Dimension(width, height));
		addMouseListener(this);
	}
	
	private void initializeComponents() {
		int column = width/(components.length + 2);
		JCheckBox check = new JCheckBox("", false);
		check.setBounds((column-30)/2, (height-30)/2, 20, 20);
		add(check);
		for(int i = 1; i <= components.length; i++) {
			java.awt.Component component = components[i-1];
			component.setBounds(i*column+column/8, height/8, column*3/4, height*3/4);
			add(component);
		}
		MainButton button = new MainButton("delete");
		button.setBounds((components.length+1)*column+column/8, height/8, column*3/4, height*3/4);
		add(button);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, this.getWidth(), this.getHeight());
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
	
}
