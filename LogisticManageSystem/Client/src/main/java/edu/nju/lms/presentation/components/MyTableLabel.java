package edu.nju.lms.presentation.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import org.dom4j.Element;

public class MyTableLabel extends JLabel implements MouseListener{

	private static final long serialVersionUID = 420418378988671847L;
	
	private int width;
	
	private int height;
	
	private java.awt.Component[] components;
	
	private String picPath = "pictures/white.png";
	
	MainButton button = null;
	
	public static boolean isWhite;

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
		button = new MainButton("delete");
		button.setBounds((components.length+1)*column+column/8, height/8, column*3/4, height*3/4);
		button.setVisible(false);
		add(button);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(new ImageIcon(picPath).getImage(),0,0,this.getWidth(), this.getHeight()+20,this);
	}

	public void mouseClicked(MouseEvent e) {
		repaint();
	}

	public void mouseEntered(MouseEvent e) {
		repaint();
	}

	public void mouseExited(MouseEvent e) {
		changeWhite();
		showButton(false);
		repaint();
	}

	public void mousePressed(MouseEvent e) {
		changeGrey();
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		showButton(true);
		repaint();
	}
	
	public java.awt.Component[] getComponents(){
		return components;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	private void changeGrey(){
		picPath = "pictures/addPath.png";
	}
	
	private void changeWhite(){
		picPath = "pictures/white.png";
	}
	
	private void showButton(boolean isShow) {
		button.setVisible(isShow);
	}

}
