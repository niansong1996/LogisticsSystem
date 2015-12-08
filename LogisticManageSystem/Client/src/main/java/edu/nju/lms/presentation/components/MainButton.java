package edu.nju.lms.presentation.components;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

/**
 *@author tj
 *@date 2015年11月18日
 */
public class MainButton extends JLabel{

	private static final long serialVersionUID = 4647675998577572101L;
	private int x;
	private int y;
	private int h;
	private int w;
	private String name;
	private boolean isIn;
	private boolean isPressed;
	private Element element;
	public MainButton(Element button,UIController controller){
		w = Integer.parseInt(button.attributeValue("w"));
		h = Integer.parseInt(button.attributeValue("h"));
		x = Integer.parseInt(button.attributeValue("x"));
		y = Integer.parseInt(button.attributeValue("y"));
		name =button.attributeValue("name");
		element = button;
		setBounds(x,y,w,h);
	}
	
	public MainButton(String name){
		this.name = name;
	}
	
	public void paintComponent(Graphics g){
		String path = "";
		if(isIn){
			path = "pictures/buttons/"+name+"1.png";
		}else if(isPressed){
			path = "pictures/buttons/"+name+"2.png";
		}else{
			path = "pictures/buttons/"+name+".png";
		}
		g.drawImage(new ImageIcon(path).getImage(), 0,0,this.getWidth(),this.getHeight(), this);
	}
	public void setIn(boolean isIn){
		this.isIn = isIn;
	}
	public void setPressed(boolean isPressed){
		this.isPressed = isPressed;
	}

	public Element getElement() {
		return element;
	}
	
	public String getName(){
		return name;
	}

}
