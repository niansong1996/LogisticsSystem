package edu.nju.lms.presentation.panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.presentation.button.ButtonAdd;
import edu.nju.lms.presentation.button.ButtonFind;

public class AdminPanel extends JPanel{
	private Image admin;
	private ButtonAdd btnAdd;
	private ButtonFind btnFind;
	private UserblService userbl;
	private AddPanel addPanel;
	public AdminPanel(UserblService userbl){
		this.userbl = userbl;
		this.setLayout(null);
		admin = new ImageIcon("pictures/admin.png").getImage();
		btnAdd=new ButtonAdd(100,100);
		btnFind=new ButtonFind(100,100);
		this.add(btnAdd);
		this.add(btnFind);
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(admin, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
