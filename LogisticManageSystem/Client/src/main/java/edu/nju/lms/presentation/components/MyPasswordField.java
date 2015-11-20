package edu.nju.lms.presentation.components;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

/**
 *@author tj
 *@date 2015年11月19日
 */
public class MyPasswordField extends JPasswordField{
	private int x;
	private int y;
	private int h;
	private int w;
	public MyPasswordField(Element text, UIController controller){
		w = Integer.parseInt(text.attributeValue("w"));
		h = Integer.parseInt(text.attributeValue("h"));
		x = Integer.parseInt(text.attributeValue("x"));
		y = Integer.parseInt(text.attributeValue("y"));
		setBounds(x,y,w,h);
	}


}
