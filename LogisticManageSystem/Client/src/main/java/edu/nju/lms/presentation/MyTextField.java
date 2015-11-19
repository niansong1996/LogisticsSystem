package edu.nju.lms.presentation;

import javax.swing.JTextField;

import org.dom4j.Element;

/**
 *@author tj
 *@date 2015年11月19日
 */
public class MyTextField extends JTextField {
	private int x;
	private int y;
	private int h;
	private int w;
	public MyTextField(Element text, UIController controller){
		w = Integer.parseInt(text.attributeValue("w"));
		h = Integer.parseInt(text.attributeValue("h"));
		x = Integer.parseInt(text.attributeValue("x"));
		y = Integer.parseInt(text.attributeValue("y"));
	}
}
