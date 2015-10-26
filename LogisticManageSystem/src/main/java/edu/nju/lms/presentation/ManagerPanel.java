package edu.nju.lms.presentation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.nju.lms.businessLogicService.UserblService;

/**
 *@author tj
 *@date 2015年10月26日
 */
public class ManagerPanel extends JPanel{
	private UserblService userbl;
	private Image back;
	private AddPanel addPanel;
	public ManagerPanel(UserblService userbl){
		 this.userbl = userbl;
		 back = new ImageIcon("pictures/back.jpg").getImage();
		 this.setLayout(null);
		 addPanel = new AddPanel(userbl);
		 this.add(addPanel);
	}
	public void paintComponent(Graphics g){
		g.drawImage(back, 0, 0, this.getWidth(),this.getHeight(),null);
	}
}
