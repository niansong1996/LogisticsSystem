package edu.nju.lms.presentation.components;

import javax.swing.JLabel;

import org.dom4j.Element;

public class MyTableLabel extends JLabel{

	private static final long serialVersionUID = 420418378988671847L;
	
	private int width;
	private int height;
	private int columnNum;

	public MyTableLabel(Element element, Object[] components) {
		setLayout(null);
		initializeComponents();
	}
	
	private void initializeComponents() {
		
	}
	
}
