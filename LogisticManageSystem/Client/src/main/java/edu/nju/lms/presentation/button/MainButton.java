package edu.nju.lms.presentation.button;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.dom4j.Element;

/**
 *@author tj
 *@date 2015年11月18日
 */
public class MainButton extends JLabel{
	private int x;
	private int y;
	private int h;
	private int w;
	private String name;
	private boolean isIn;
	public MainButton(Element button){
		w = Integer.parseInt(button.attributeValue("width"));
		h = Integer.parseInt(button.attributeValue("height"));
		x = Integer.parseInt(button.attributeValue("x"));
		y = Integer.parseInt(button.attributeValue("y"));
		name =button.attributeValue("name");
	}
	
	public void paintComponent(Graphics g){
		String path = "";
		if(isIn){
			path = "pictures/buttons/"+name+"1"+".png";
			g.drawImage(new ImageIcon(path).getImage(), 0,0,this.getWidth(),this.getHeight(), this);
		}else{
			path = "pictures/buttons/"+name+".png";
			g.drawImage(new ImageIcon(path).getImage(), 0,0,this.getWidth(),this.getHeight(), this);
		}
	}
	public void setIn(boolean isIn){
		this.isIn = isIn;
	}
	
}
