package edu.nju.lms.presentation.components;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

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
		setBounds(x,y,w,h);
		setOpaque(false);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setFont(new Font("微软雅黑", Font.ITALIC, 23));
	}
}
