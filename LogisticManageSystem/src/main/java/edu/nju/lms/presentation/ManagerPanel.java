package edu.nju.lms.presentation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *@author tj
 *@date 2015年10月26日
 */
public class ManagerPanel extends JPanel{
	private Image back;
	public ManagerPanel(){
		 back = new ImageIcon("pictures/back.jpg").getImage();
	}
	public void paintComponent(Graphics g){
		g.drawImage(back, 0, 0, this.getWidth(),this.getHeight(),null);
		System.out.println("xxx");
	}
}
